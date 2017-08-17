package EffectiveJavaImp.JavaLambda;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by panqiang on 2017/6/7.
 * Java 的函数 类 lambda 接口
 * Predicate 接受泛型 T对象 test 方法返回boolean 类型
 * Consumer 结构泛型T 对象 accept 方法返回 void
 * Function 接受 T对象 apply 方法返回R 对象
 */
public class Test {
    public static void main(String[]args) throws IOException {
       String res= LambdaFile.processFile((BufferedReader br)->br.readLine()+"\n"+br.readLine());
       System.out.println(res);
    }
}
