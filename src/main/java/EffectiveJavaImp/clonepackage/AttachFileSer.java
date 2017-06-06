package EffectiveJavaImp.clonepackage;

import java.io.Serializable;

/**
 * Created by panqiang on 2017/6/6.
 */
public class AttachFileSer implements Serializable{
    private static final long serialVersionUID = -4581076628878029311L;
    private String context;

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AttachFileSer that = (AttachFileSer) o;

        return context != null ? context.equals(that.context) : that.context == null;
    }

    @Override
    public int hashCode() {
        return context != null ? context.hashCode() : 0;
    }

}
