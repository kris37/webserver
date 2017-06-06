package EffectiveJavaImp.factorypackage;

import EffectiveJavaImp.factorypackage.MyInterface.Pizza;

/**
 * Created by panqiang on 2017/6/5.
 */
public class PotatoPizza implements Pizza {

    public PotatoPizza() {

    }

    public void echoName() {
        System.out.println("patatoPizza");
    }

    public String ingredients() {
        return "patato+flour+cheese";
    }
}
