package EffectiveJavaImp.singletonepackage;

/**
 * Created by panqiang on 2017/4/27.
 */
public class SingleTon3 {
    /*
    静态内部类[推荐用]
    而静态内部类方式在Singleton类被装载时并不会立即实例化，而是在调用getInstance()方法时，才会装载SingletonInstance类，进而完成Singleton的实例化。
    类的静态属性只会在第一次加载类的时候初始化，所以在这里，JVM帮助我们保证了线程的安全性，在类进行初始化时，别的线程是无法进入的。
    */

        private SingleTon3() {}
        //private 静态内部类
        private static class SingletonInstance {
            private static final SingleTon3 INSTANCE = new SingleTon3();
        }
        //只有调用此方法的时候才会加载 懒汉式
        public static SingleTon3 getInstance() {
            // 第一次访问静态类的时候才会初始化
            return SingletonInstance.INSTANCE;
        }

}
