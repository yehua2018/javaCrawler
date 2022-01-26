package com.java.sl.dao;

import java.sql.*;

public class SqlDB {
    //数据库用户名
    private static final String USERNAME = "root";
    //数据库密码
    private static final String PASSWORD = "qwert123";
    //驱动信息
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    //数据库地址
    private static final String HOST = "jdbc:mysql://localhost:3306/java?allowPublicKeyRetrieval=true&useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC";
    private Connection conn=null;
    //private PreparedStatement pstmt;
    public SqlDB() {
        try{
            Class.forName(DRIVER);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public Connection getConn() throws SQLException{
        Connection conn = null;
        try {
             conn = DriverManager.getConnection(HOST, USERNAME,PASSWORD);
        }catch (Exception e) {
            e.printStackTrace();
//            throw RuntimeException(e);
        }
        return conn;
    }
    /*
    查询类sql的通用方法
     */
    public ResultSet sqlExecute(String sql){

        // 执行sql
        ResultSet resultSet = null;
        try{
            // 获取数据库连接
            if(conn == null || conn.isClosed()){
                conn = getConn();
            }
            Statement statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);
            conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        return resultSet;
    }

    /*
    执行sql的通用方法
     */
    public void dqlExecute(String sql){

        // 执行sql
        try{
            // 获取数据库连接
            if(conn == null || conn.isClosed()){
                conn = getConn();
            }
            Statement statement = conn.createStatement();
            statement.execute(sql);
            conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
