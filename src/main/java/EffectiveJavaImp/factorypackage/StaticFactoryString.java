package EffectiveJavaImp.factorypackage;

import EffectiveJavaImp.factorypackage.StaticFactoryInterface;

/**
 * Created by panqiang on 2017/4/24.
 */
public class StaticFactoryString implements StaticFactoryInterface<String> {

    private int min;
    private int max;
    StaticFactoryString(int min,int max){
        this.min=min;
        this.max=max;
    }
    public String echo() {
        return String.valueOf(min)+String.valueOf(max);
    }
}
