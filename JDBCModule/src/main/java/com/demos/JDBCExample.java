package com.demos;

import com.bean.CityResident;

import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: chendom
 * Date: 2018-08-20
 * Time: 13:00
 */
public class JDBCExample {

    private Connection getConnection() {
        java.sql.Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/mybatis?tinyInt1isBit=false&useUnicode=true&characterEncoding=utf-8&autoReconnect=true&failOverReadOnly=false&zeroDateTimeBehavior=convertToNull";
            String userName = "root";
            String passWorld = "root@123";
            connection = DriverManager.getConnection(url, userName, passWorld);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return connection;
    }

    public CityResident getCityResident(Long id) {
        Connection connection = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = connection.prepareStatement("select id,name,age,sex from test_demo1 where id=?");
            ps.setLong(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                CityResident CityResident = new CityResident();
                CityResident.setId(rs.getLong("id"));
                CityResident.setName(rs.getString("name"));
                CityResident.setAge(rs.getInt("age"));
                CityResident.setSex(rs.getInt("sex"));
                return CityResident;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(rs, ps, connection);
        }
        return null;
    }

    private void closeConnection(ResultSet rs, Statement stmt, Connection connection) {

        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (stmt != null && !stmt.isClosed()) {
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCExample example = new JDBCExample();
        CityResident CityResident = example.getCityResident(1L);
        System.out.println("CityResident:" + CityResident.toString());

    }
}
