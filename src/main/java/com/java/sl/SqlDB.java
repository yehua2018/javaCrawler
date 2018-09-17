package com.java.sl;

import java.sql.*;

public class SqlDB {
    static final String DRIVER = "com.mysql.jdbc.Driver";
    String host = "jdbc:mysql://localhost:3306/studb";
    String username = "root";
    String password = "";
    Connection conn;


    public Connection getConn(){
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(host, username, password);
        }catch(ClassNotFoundException e) {
            //数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        }catch(SQLException e) {
            //数据库连接失败异常处理
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }
    /*
    执行sql的通用方法
     */
    public ResultSet execute(String sql){
        // 获取数据库连接
        if(conn == null){
            conn = getConn();
        }
        // 执行sql
        ResultSet resultSet = null;
        try{
            Statement statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);
        }catch (SQLException e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        return resultSet;
    }
}
