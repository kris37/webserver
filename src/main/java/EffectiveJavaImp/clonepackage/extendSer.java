package EffectiveJavaImp.clonepackage;

import java.io.Serializable;

/**
 * Created by panqiang on 2017/6/6.
 */
public class extendSer  extends AttachFileSer /*implements Serializable*/ {

    //private static final long serialVersionUID = 2967746776724826031L;
    private String Name;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        extendSer extendSer = (extendSer) o;

        return Name != null ? Name.equals(extendSer.Name) : extendSer.Name == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (Name != null ? Name.hashCode() : 0);
        return result;
    }
}
