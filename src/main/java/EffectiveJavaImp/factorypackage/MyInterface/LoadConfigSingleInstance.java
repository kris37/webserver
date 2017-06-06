package EffectiveJavaImp.factorypackage.MyInterface;

import EffectiveJavaImp.singletonepackage.SingleTon;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by panqiang on 2017/6/5.
 */
public enum  LoadConfigSingleInstance {
    config;

    private  final Properties pros=new Properties();;
    LoadConfigSingleInstance (){
        init();
    }
    private  void init(){
        //reload properties

        if(null!=pros && !pros.isEmpty()) pros.clear();
        try {
            // load properties
            System.out.println("init enum singleTone class ......");
            pros.load(LoadConfigSingleInstance.class.getClassLoader().getResourceAsStream("Factory.properties"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
       // return this;
    }
    public String getConfig(String setttingKey){
        return this.pros.getProperty(setttingKey);
    }
}
