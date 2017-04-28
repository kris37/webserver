package EffectiveJavaImp.factorypackage;

/**
 * Created by panqiang on 2017/4/24.
 * 实例优先考虑静态工厂法
 * 静态工厂方法集合，实现特定类组合的创建
 */
public final class StaticFactorys {

    private StaticFactorys(){}

    public static final StaticFactoryInterface<Integer> getRes(int min, int max){
        return new StaticFactoryInt(min,max);
    }
    public static final StaticFactoryInterface<String> getStr(int min, int max){
        return new StaticFactoryString(min,max);
    }

}
