package EffectiveJavaImp.factorypackage;

import EffectiveJavaImp.factorypackage.MyInterface.LoadConfigSingleInstance;
import EffectiveJavaImp.factorypackage.MyInterface.Pizza;
import EffectiveJavaImp.factorypackage.MyInterface.PizzaFactory;
import EffectiveJavaImp.factorypackage.MyInterface.RefectFactoryGet;

/**
 * Created by panqiang on 2017/6/5.
 *
 */
public class Test {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        PizzaFactory factory;
        Pizza pizza;
        /*
        factory=new PatatoPizzaFactory();// 此处更改为使用 读取配置文件类名通过反射来创建工厂类
        */
        String className=LoadConfigSingleInstance.config.getConfig("PatatoFactoryClassName");
        factory = RefectFactoryGet.<PatatoPizzaFactory>getFactory(className);
        pizza=factory.createPizza();
        pizza.echoName();
        System.out.println(pizza.ingredients());
    }
}
