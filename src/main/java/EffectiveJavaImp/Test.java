package EffectiveJavaImp;


import java.io.File;
import java.io.FileFilter;
import java.text.SimpleDateFormat;
import java.util.stream.Stream;

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
        //System.out.print(new SimpleDateFormat("yyyyMMdd-HH").format(System.currentTimeMillis()));
        File [] hiddenFile=new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return !pathname.isHidden();
            }
        });

        for (File file:hiddenFile) {
            System.out.println(file.getName());
        }
        System.out.println(hiddenFile.length);

    }
}
