package EffectiveJavaImp.factorypackage;

/**
 * Created by panqiang on 2017/4/24.
 */
public class StaticFactoryInt implements StaticFactoryInterface<Integer> {

    private int min;
    private int max;
    StaticFactoryInt(int min,int max){

    }
    public Integer echo() {
        return this.min+this.max;
    }

}
