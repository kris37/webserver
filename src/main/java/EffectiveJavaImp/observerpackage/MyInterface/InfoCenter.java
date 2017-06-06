package EffectiveJavaImp.observerpackage.MyInterface;

import java.util.ArrayList;

/**
 * Created by panqiang on 2017/6/6.
 */
public abstract class InfoCenter<T> {
    private String CenterName;
    protected ArrayList<T> list=new ArrayList();

    public String getCenterName() {
        return CenterName;
    }

    public void setCenterName(String centerName) {
        CenterName = centerName;
    }

    public void join(T t){
        this.list.add(t);
    }
    /**
     *
     * @param t 注意需要重新对象的equals 方法
     */
    public void quit(T t){
        this.list.remove(t);
    }
    //抽象方法 通知 observer 实现
    public abstract void notice(T t);

}
