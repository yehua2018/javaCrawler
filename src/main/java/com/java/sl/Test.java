package com.java.sl;

import java.net.URL;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) throws Exception {
        Page page = new Page();
        String html = page.fetch("https://bj.lianjia.com/ershoufang/");
        System.out.println(html);
        Url url = new Url();
        List<String> urls = url.parseUrls(html,"ershoufang");
        System.out.println(urls);
        Detail detail = new Detail();
//        String d_page = page.fetch("https://bj.lianjia.com/ershoufang/101103229329.html");
        URL d_url = new URL("https://bj.lianjia.com/ershoufang/101103229329.html");
        Map<String,String> info = detail.ershoufang(d_url);
        System.out.println(info);
//        Map<String,String> infor = detail.ershoufang(url);
    }
}
