package EffectiveJavaImp.factorypackage.MyInterface;

/**
 * Created by panqiang on 2017/6/5.
 * 为工厂类的接口，具体实现由具体产品工厂实现
 *
 */
public interface PizzaFactory {
    Pizza createPizza();
}
