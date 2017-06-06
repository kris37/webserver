package EffectiveJavaImp.factorypackage.MyInterface;


/**
 * Created by panqiang on 2017/6/5.
 * 采用泛型方法 进行声明转换
 */
public class RefectFactoryGet {

    public static <T> T getFactory(String fullClassName) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class obj=Class.forName(fullClassName);
        return (T)obj.newInstance();
    }
}
