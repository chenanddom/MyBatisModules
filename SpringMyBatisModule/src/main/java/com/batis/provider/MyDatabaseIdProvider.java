package com.batis.provider;

import org.apache.ibatis.mapping.DatabaseIdProvider;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: chendom
 * Date: 2018-08-28
 * Time: 8:39
 */
public class MyDatabaseIdProvider implements DatabaseIdProvider {
    private Properties properties;
    @Override
    public void setProperties(Properties properties) {
        this.properties=properties;
    }

    @Override
    public String getDatabaseId(DataSource dataSource) throws SQLException {
        String dbName = dataSource.getConnection().getMetaData().getDatabaseProductName();
       String dbId = (String) this.properties.get(dbName);
        return dbId;
    }
}
