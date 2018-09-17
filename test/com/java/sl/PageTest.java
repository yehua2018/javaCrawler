package com.java.sl;

import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.net.URL;

/** 
* Page Tester. 
* 
* @author <Authors name> 
* @since <pre>九月 17, 2018</pre> 
* @version 1.0 
*/ 
public class PageTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: fetch(URL url) 
* 
*/ 
@Test
public void testFetchUrl() throws Exception {
    String url = "https://bj.lianjia.com/ershoufang/";
    URL inUrl = new URL(url);
    Page page = new Page();
    String html = page.fetch(inUrl);
    System.out.println(html);
} 


} 
