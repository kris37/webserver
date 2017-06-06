package EffectiveJavaImp.clonepackage;

import java.io.IOException;

/**
 * Created by panqiang on 2017/6/6.
 * Clone 方法都是实现的浅clone，对象中封装的对象在内存中是一个。要实现 深拷贝需要类实现 serializable

 */
public class Test {
    public static void main(String args[]) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        WeekLog weekLog = new WeekLog();
        weekLog.setName("kris37");
        weekLog.setContext("week");
        weekLog.setDate("20170606");
        weekLog.setNum(10000);
        AttachFile attachFile = new AttachFile();
        attachFile.setContext("name");
        weekLog.setAt(attachFile);
        WeekLog clonelog = weekLog.clone();
        System.out.println(clonelog.getAt().toString());
        System.out.println(weekLog.getAt().toString());
        attachFile.setContext("fuck");
        System.out.println(clonelog.getAt().toString());
        System.out.println(weekLog.getAt().toString());

//        System.out.println((weekLog.getName()));
////        System.out.println(clone.getName()==weekLog.getName());
////        System.out.println(clone.getNum()==weekLog.getNum());
////        System.out.println(clone==weekLog);
////        System.out.println(clone.equals(weekLog));
////        System.out.println(clone.toString());
//
//        System.out.println(weekLog.getAt().toString());
//        System.out.println(weekLog.getAt().getContext());
//        attachFile.setContext("age");
//        clone.setAt(attachFile);
//        System.out.println(weekLog.getAt().toString());
//        System.out.println(weekLog.getAt().getContext());

        WeeKLogSer weekLogser = new WeeKLogSer();
        weekLogser.setName("kris37");
        extendSer attachFileser = new extendSer();

        attachFileser.setName("extends");
        weekLogser.setAt(attachFileser);

        WeeKLogSer clone = weekLogser.deepClone();
        System.out.println((clone.getAt()).toString());
        System.out.println((weekLogser.getAt()).toString());

        attachFileser.setName("implemnts");
//        extendSer newEx = new extendSer();
//        newEx.setName("what");
//        clone.setAt(newEx);

        System.out.println((clone.getAt()).toString());
        System.out.println((weekLogser.getAt()).toString());
        System.out.println(clone.getAt()==(weekLogser.getAt()));
        System.out.println(clone.getAt().equals(weekLogser.getAt()));

//        System.out.println(clone==weekLogser);
//        System.out.println(clone.equals(weekLogser));
//        clone.setName("panqiang");
//        System.out.println(clone==weekLogser);
//        System.out.println(clone.equals(weekLogser));

    }
}