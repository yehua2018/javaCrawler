package com.java.sl;

import java.sql.*;

public class SqlDB {
    //数据库用户名
    private static final String USERNAME = "root";
    //数据库密码
    private static final String PASSWORD = "ttdsj84261@";
    //驱动信息
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    //数据库地址
    private static final String HOST = "jdbc:mysql://localhost:3306/DemoTest";
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
            conn = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
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
