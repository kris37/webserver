package dynamicDataSource;

/**
 * Created by panqiang on 2017/5/21.
 *  @see DataSources/DataSource.xml:17
 */
public class DataSourceContextHolder {
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();
    //默认数据源（userDataSource）

    public static final String dataSourceUser = "dataSourceUser";

    //另外一个数据源（和配置文件中的key对应）
    public static final String dataSourceCity = "dataSourceCity";

    public static void setDbType(String dbType) {
        contextHolder.set(dbType);
    }

    public static String getDbType() {
        return ((String) contextHolder.get());
    }

    public static void clearDbType() {
        contextHolder.remove();
    }
}
