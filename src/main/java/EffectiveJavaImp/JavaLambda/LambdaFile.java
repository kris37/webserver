package EffectiveJavaImp.JavaLambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by panqiang on 2017/6/7.
 * for java8 lambda and try with resources method
 */
public class LambdaFile {
    public static String processFile(BufferedReaderProcessor bp) throws IOException{
        try(
            BufferedReader bf=new BufferedReader(new FileReader("/Users/panqiang/Works/self/study/webserver/src/main/resources/data.txt")) ){
            return bp.processor(bf);
        }
    }
}
