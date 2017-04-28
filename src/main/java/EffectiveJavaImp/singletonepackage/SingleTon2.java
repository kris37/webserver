package EffectiveJavaImp.singletonepackage;

/**
 * Created by panqiang on 2017/4/27.
 */
public class SingleTon2 {
    /*
    饿汉式（静态常量)
    优点：写法简单，在类装载时完成实例化。避免了线程同步问题。
    缺点：一定会实例化类，没有达到Lazy Loading的效果。如果从未使用过这个实例，会造成内存的浪费。
     */
    private static final SingleTon2 ourInstance = new SingleTon2();

    public static SingleTon2 getInstance() {
        return ourInstance;
    }

    private SingleTon2() {
    }
}
/*
 静态代码块，与常量式一致
public class Singleton {

    private static Singleton instance;

    static {
        instance = new Singleton();
    }

    private Singleton() {}

    public Singleton getInstance() {
        return instance;
    }

 */
