package EffectiveJavaImp.factorypackage;

import EffectiveJavaImp.factorypackage.MyInterface.Pizza;
import EffectiveJavaImp.factorypackage.MyInterface.PizzaFactory;

/**
 * Created by panqiang on 2017/6/5.
 */
public class PatatoPizzaFactory implements PizzaFactory {

    public Pizza createPizza() {
        return new PotatoPizza();
    }
}
