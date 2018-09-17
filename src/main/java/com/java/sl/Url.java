package com.java.sl;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Url {
    /*
    负责解析url列表
     */
    public List<String> parseUrls(String html, String type){
        if(type == null){
            type = "ershoufang";
        }
        List<String> urls = new ArrayList<String>();
        //设定URL格式正则匹配模式
        Pattern pattern = Pattern.compile("(https://bj.lianjia.com/"+type+"/\\d+.html)");
        Matcher matcher = pattern.matcher(html);
        while(matcher.find()) {
            urls.add(matcher.group());
        }
        return urls;
    }
}
