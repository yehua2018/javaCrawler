package com.java.sl;

import com.java.sl.dao.SqlDB;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.sql.ResultSet;

/** 
* SqlDB Tester. 
* 
* @author <Authors name> 
* @since <pre>九月 17, 2018</pre> 
* @version 1.0 
*/ 
public class SqlDBTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getConn() 
* 
*/ 
@Test
public void testGetConn() throws Exception {
//TODO: Test goes here...
    SqlDB sqlDB = new SqlDB();
    sqlDB.getConn();
} 

/** 
* 
* Method: execute(String sql) 
* 
*/ 
@Test
public void testExecute() throws Exception { 
//TODO: Test goes here...
    SqlDB sqlDB = new SqlDB();
    String sql = null;
    //插入数据测试
    //sql = "insert into housing_estates (url,create_date,last_modified_date,url_type) values('https://bj.lianjia.com',now(),now(),0)";
    //删除
    //sql = "delete from housing_estates";
    //更新
    sql = "update housing_estates set url_type = 1 where url_type = 0";
    System.out.println(sqlDB.dmlExecute(sql));
    //查询测试
    sql = "select * from housing_estates";
    ResultSet resultSet = sqlDB.dqlExecute(sql);
    int colcnt = resultSet.getMetaData().getColumnCount();
    while (resultSet.next()){
        for(int i = 1; i <= colcnt; i++){
            System.out.print(resultSet.getString(i)+"\t");
        }
        System.out.println();
    }
} 


} 
