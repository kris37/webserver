package EffectiveJavaImp.clonepackage;

/**
 * Created by panqiang on 2017/6/6.
 */
public class WeekLog implements Cloneable{
    private String name;
    private String date;
    private String context;
    private int num;
    private AttachFile at;

    public AttachFile getAt() {

        return at;
    }

    public void setAt(AttachFile at) {
        this.at = at;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

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

    @Override
    public WeekLog clone() throws CloneNotSupportedException {
        Object obj=null;
        try{
            obj=super.clone();
            return (WeekLog)obj;
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
            System.out.println("not support clone!");
            return null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeekLog weekLog = (WeekLog) o;

        if (num != weekLog.num) return false;
        if (name != null ? !name.equals(weekLog.name) : weekLog.name != null) return false;
        if (date != null ? !date.equals(weekLog.date) : weekLog.date != null) return false;
        if (context != null ? !context.equals(weekLog.context) : weekLog.context != null) return false;
        return at != null ? at.equals(weekLog.at) : weekLog.at == null;
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

    @Override
    public String toString() {
        return "WeekLog{" +
                "name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", context='" + context + '\'' +
                ", num=" + num +
                ", at=" + at +
                '}';
    }
}
