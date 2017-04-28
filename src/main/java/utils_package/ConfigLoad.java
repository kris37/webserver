package utils_package;

import java.io.IOException;
import java.io.ObjectInput;
import java.util.Map;
import java.util.Properties;

/**
 * Created by panqiang on 2017/4/24.
 */
public enum ConfigLoad {
    SINGLETON;// 单例模式
    private volatile Properties pros = new Properties();
    public void init() {
        if(!pros.isEmpty()) pros.clear();
            try {
                pros.load(ConfigLoad.class.getClassLoader().getResourceAsStream("logsplitregx.properties"));
            } catch (IOException e) {
                e.printStackTrace();
            }

    }

    public String get_pro(String key){
        return this.pros.getProperty(key,null);
    }
    //set online reflush method
}
