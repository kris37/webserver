package EffectiveJavaImp.factorypackage;

import EffectiveJavaImp.factorypackage.MyInterface.Pizza;

/**
 * Created by panqiang on 2017/6/5.
 */
public class BeefPizza implements Pizza {

    public BeefPizza() {
    }

    public void echoName() {
        System.out.println("beef pizza");
    }

    public String ingredients() {
        return "beef+flour+cheese.";
    }
}
