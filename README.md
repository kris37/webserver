### **相关依赖**
具体可参考 `pom.xml` 文件, 这里只做简单说明:

* spring-test 是为了在测试类上直接使用如下注解启动spring容器
    ```
    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration(locations = {"/ApplicationContext.xml"})
    ```
* spring-aspects 是为了事务的AOP切入, spring-jdbc 是为了引入事务管理器
* c3p0 是数据库连接池
* mybatis-spring 是通过扫描辅助注入mybatis的mapper，可以不用一个个写对应的mapper的bean声明
* 引入logback日志管理并将其他类型日志都转接到logback

### **Spring容器配置**
Spring的容器配置在 ApplicationContext.xml 中，它导入数据库链接配置的resource.properties, 通过扫描自动注入使用注解配置的bean， 数据层相关的bean都配置在DataSource.xml里，ApplicationContex.xml通过`import` 引入里面的beans
```
    <!-- 配置properties里读取属性信息 -->
    <bean class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer" id="propertyConfigurer">
        <property name="locations">
            <list>
                <value>classpath*:resource.properties</value>
            </list>
        </property>
    </bean>
    <context:component-scan base-package="com.albert.spring.mybatis"/>
    <import resource="DataSource.xml" />
```

### **数据层配置文件**

数据层主要包括三块，数据源，mybatis的mapper，事务管理。
1. 数据源采用c3p0连接池，一个bean以及一堆属性配置。
2. mapper的注入包括两个方面，session工厂与mapper注入, 基本的 MyBatis 中,session 工厂可以使用 SqlSessionFactoryBuilder 来创建。而在 MyBatis-Spring 中,则使用 SqlSessionFactoryBean 来替代，也要配置基本的配置文件与mapper.xml文件；mapper注入只需要mapper接口的基础包名。
```
    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="dataSource" ref="dataSource" />
        <!--<property name="configLocation" value="classpath:mybatis.xml" />-->
        <!-- Mapper文件存放的位置，当Mapper文件跟对应的Mapper接口处于同一位置的时候可以不用指定该属性的值 -->
        <property name="mapperLocations" value="classpath*:sqlmap/*.xml" />
    </bean>

    <!--单个 mapper -->
    <!--<bean id="userDao" class="org.mybatis.spring.mapper.MapperFactoryBean">-->
        <!--<property name="mapperInterface" value="com.albert.spring.mybatis.dao.mapper.UserMapper" />-->
    <!--</bean>-->

    <!-- 多个 mapper  -->
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <property name="annotationClass" value="org.springframework.stereotype.Repository" />
        <!-- 扫描器开始扫描的基础包名，支持嵌套扫描 -->
        <property name="basePackage" value="com.albert.spring.mybatis.dao.mapper" />
    </bean>
```
3. 事务管理使用jdbc的DataSourceTransactionManager，`<tx:annotation-driven transaction-manager="transactionManager" />`是为了能在方法上使用spring的事务管理注解；事务的传播特性指的是在一个方法中调用另一个方法时，第一个方法的事务与第二个方法的事务之间的关联，spring默认是REQUIRED, 也就是第一个方法调用第二个方法（配置了REQUIREDD）时,如果第一个方法产生了事务就用第一个方法产生的事务，否则就创建一个新的事务。
```

    <!-- 事务管理 -->
    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource" />
    </bean>
    <tx:annotation-driven transaction-manager="transactionManager" />
    <!-- 事务的传播特性 -->
    <tx:advice id="txadvice" transaction-manager="transactionManager">
        <tx:attributes>
            <tx:method name="add*" propagation="REQUIRED"/>
            <tx:method name="get*" propagation="REQUIRED" />

            <!--hibernate4必须配置为开启事务 否则 getCurrentSession()获取不到 -->
            <tx:method name="*" propagation="REQUIRED" read-only="true" />
        </tx:attributes>
    </tx:advice>
    <!-- 那些类那些方法使用事务 -->
    <aop:config>
        <!-- 只对业务逻辑层实施事务 -->
        <aop:pointcut id="allManagerMethod"
                      expression="execution(* com.albert.spring.mybatis.service.*.*.*(..))" />
        <aop:advisor pointcut-ref="allManagerMethod" advice-ref="txadvice" />
    </aop:config>
```
> 注意spring父子容器对事务增强的影响（子容器可以访问父容器中的内容，但父容器不能访问子容器中的内容），具体来说，与spring-mvc集成时，类如果先在子容器WebApplicationContext注入，那么由于父容器ApplicationContext不能访问子容器中内容，事务处理的的Bean在父容器中，无法访问子容器中被增强bean的内容，就无法进行事务AOP增强。

### **mybatis使用**
MyBatis是半ORM框架，sql写在xml文件里，执行sql的方法写在一个声明的接口里，使用时使用xml生成接口的实现对象，中间从调用方法的参数拼接sql和执行结果到内存中对象的映射都由mybatis自动完成，当然也支持自己扩充丰富其功能。
>注意同名的xml里的命名空间必须与完整接口名对应，xml里的执行sql的id与接口里方法名对应