package java.com.java.sl;

import junit.framework.Test; 
import junit.framework.TestSuite; 
import junit.framework.TestCase; 

/** 
* Page Tester. 
* 
* @author <Authors name> 
* @since <pre>09/17/2018</pre> 
* @version 1.0 
*/ 
public class PageTest extends TestCase { 
public PageTest(String name) { 
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
* Method: fetch(URL url) 
* 
*/ 
public void testFetchUrl() throws Exception { 
//TODO: Test goes here... 
} 



public static Test suite() { 
return new TestSuite(PageTest.class); 
} 
} 
