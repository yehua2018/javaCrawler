package com.java.sl;

import java.sql.*;

public class SqlDB {
    //数据库用户名
    private static final String USERNAME = "root";
    //数据库密码
    private static final String PASSWORD = "147258";
    //驱动信息
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    //数据库地址j
    private static final String HOST = "jdbc:mysql://localhost:3306/mysql_test?useSSL = false&useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC";
    private Connection conn=null;
    //private PreparedStatement pstmt;
    public SqlDB() {
        try{
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
            System.out.println("数据库连接成功！");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public Connection getConn(){
        try {
            conn = DriverManager.getConnection(HOST, USERNAME,PASSWORD);
            System.out.println("Successfully.");
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
    public ResultSet dqlExecute(String sql){
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
    public int dmlExecute(String sql){
        // 获取数据库连接
        if(conn == null){
            conn = getConn();
        }
        // 执行sql
        int i = 0;
        try{
            Statement statement = conn.createStatement();
            i = statement.executeUpdate(sql);
        }catch (SQLException e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        return i;
    }
}
