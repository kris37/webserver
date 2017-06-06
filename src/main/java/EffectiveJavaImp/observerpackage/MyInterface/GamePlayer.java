package EffectiveJavaImp.observerpackage.MyInterface;

/**
 * Created by panqiang on 2017/6/6.
 */
public interface GamePlayer {

    void notice(InfoCenter ic);
    String getName();
    void setName(String name);
    void help();

}
