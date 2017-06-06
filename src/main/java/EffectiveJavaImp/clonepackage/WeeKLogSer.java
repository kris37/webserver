package EffectiveJavaImp.clonepackage;

import java.io.*;

/**
 * Created by panqiang on 2017/6/6.
 */
public class WeeKLogSer implements Serializable{

    private static final long serialVersionUID = -7048606477299965860L;
    private String name;
    private String date;
    private String context;
    private int num;
    private extendSer at;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public extendSer getAt() {
        return at;
    }

    public void setAt(extendSer at) {
        this.at = at;
    }

   public WeeKLogSer deepClone() throws IOException, ClassNotFoundException {
        // 序列化 写出
       ByteArrayOutputStream bao=new ByteArrayOutputStream();
       ObjectOutputStream oos=new ObjectOutputStream(bao);
       oos.writeObject(this);//将 对象写入bao
        // 反序列化 读入
       ByteArrayInputStream bis=new ByteArrayInputStream(bao.toByteArray());
       ObjectInputStream ois=new ObjectInputStream(bis);
       return (WeeKLogSer) ois.readObject();




   }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeeKLogSer that = (WeeKLogSer) o;

        if (num != that.num) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (context != null ? !context.equals(that.context) : that.context != null) return false;
        return at != null ? at.equals(that.at) : that.at == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (context != null ? context.hashCode() : 0);
        result = 31 * result + num;
        result = 31 * result + (at != null ? at.hashCode() : 0);
        return result;
    }
}
