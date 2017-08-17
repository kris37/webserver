package EffectiveJavaImp.JavaLambda;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by panqiang on 2017/6/7.
 */
@FunctionalInterface
public interface BufferedReaderProcessor {
    String processor(BufferedReader br) throws IOException;
}
