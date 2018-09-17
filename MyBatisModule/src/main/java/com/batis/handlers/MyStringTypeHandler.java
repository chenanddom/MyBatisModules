package com.batis.handlers;

import jdk.internal.instrumentation.TypeMappings;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import org.apache.log4j.Logger;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: chendom
 * Date: 2018-08-24
 * Time: 8:59
 */
/*
public class StringTypeHandler extends BaseTypeHandler<String> {
    private Logger logger = Logger.getLogger(StringTypeHandler.class);
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, String s, JdbcType jdbcType) throws SQLException {
        logger.info("------------------execute here---------------------");
        preparedStatement.setString(i,s+"-test-");
    }

    @Override
    public String getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return resultSet.getString(s);
    }

    @Override
    public String getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return resultSet.getString(i);
    }

    @Override
    public String getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return callableStatement.getString(i);
    }
}
*/
/*@MappedTypes({String.class})
@MappedJdbcTypes(JdbcType.VARCHAR)*/
public class MyStringTypeHandler implements TypeHandler<String>{
    private Logger logger = Logger.getLogger(MyStringTypeHandler.class);

    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, String s, JdbcType jdbcType) throws SQLException {
        logger.info("------------------execute here---------------------");
        preparedStatement.setString(i,s+"-test-");
    }

    @Override
    public String getResult(ResultSet resultSet, String s) throws SQLException {
        logger.info("------------------getResult(ResultSet resultSet, String s)---------------------");
        return resultSet.getString(s)+"-test-";
    }

    @Override
    public String getResult(ResultSet resultSet, int i) throws SQLException {
        logger.info("------------------getResult(ResultSet resultSet, int i)---------------------");
        return resultSet.getString(i);
    }

    @Override
    public String getResult(CallableStatement callableStatement, int i) throws SQLException {
        logger.info("------------------getResult(CallableStatement callableStatement, int i)---------------------");
        return callableStatement.getString(i);
    }
}
