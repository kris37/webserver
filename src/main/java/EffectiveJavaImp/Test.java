package EffectiveJavaImp;

import EffectiveJavaImp.builderpackage.BuilderStruct;
import EffectiveJavaImp.factorypackage.StaticFactorys;

import java.text.SimpleDateFormat;

/**
 * Created by panqiang on 2017/4/24.
 */
public class Test {
    public static void main(String [] args){
        //StaticFactorys sf1= StaticFactorys.getBetween(1,2);
        //StaticFactorys sf2= StaticFactorys.getBetween(2,4);

        //System.out.println(sf1.toString());
        //        System.out.println(sf2.toString());
        //BuilderStruct bs= new BuilderStruct.Builder("kris",25,"male").setprovine("liaoning").setcity("anshan").settel("18588450737").build();

       //System.out.print(bs.toString());
        System.out.print(new SimpleDateFormat("yyyyMMdd-HH").format(System.currentTimeMillis()));

    }
}
