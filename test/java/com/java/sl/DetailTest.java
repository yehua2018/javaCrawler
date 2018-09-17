package java.com.java.sl;

import junit.framework.Test; 
import junit.framework.TestSuite; 
import junit.framework.TestCase; 

/** 
* Detail Tester. 
* 
* @author <Authors name> 
* @since <pre>09/17/2018</pre> 
* @version 1.0 
*/ 
public class DetailTest extends TestCase { 
public DetailTest(String name) { 
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
* Method: ershoufang(String html) 
* 
*/ 
public void testErshoufangHtml() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: ershoufang(URL url) 
* 
*/ 
public void testErshoufangUrl() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: zufang(String html) 
* 
*/ 
public void testZufang() throws Exception { 
//TODO: Test goes here... 
} 



public static Test suite() { 
return new TestSuite(DetailTest.class); 
} 
} 
