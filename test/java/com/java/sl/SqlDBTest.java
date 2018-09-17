package java.com.java.sl;

import junit.framework.Test; 
import junit.framework.TestSuite; 
import junit.framework.TestCase; 

/** 
* SqlDB Tester. 
* 
* @author <Authors name> 
* @since <pre>09/17/2018</pre> 
* @version 1.0 
*/ 
public class SqlDBTest extends TestCase { 
public SqlDBTest(String name) { 
super(name); 
} 

public void setUp() throws Exception { 
super.setUp(); 
} 

public void tearDown() throws Exception { 
super.tearDown(); 
} 

/** 
* 
* Method: getConn() 
* 
*/ 
public void testGetConn() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: execute(String sql) 
* 
*/ 
public void testExecute() throws Exception { 
//TODO: Test goes here... 
} 



public static Test suite() { 
return new TestSuite(SqlDBTest.class); 
} 
} 
