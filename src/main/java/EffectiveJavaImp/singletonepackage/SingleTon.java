package EffectiveJavaImp.singletonepackage;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by panqiang on 2017/4/27.
 */
public enum SingleTon {
    SINGLE;
    private volatile Properties pros=new Properties();
    public  void init(){
        //reload properties
        if(!pros.isEmpty()) pros.clear();
        try {
            // load properties
            pros.load(SingleTon.class.getClassLoader().getResourceAsStream("logsplitregx.properties"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
