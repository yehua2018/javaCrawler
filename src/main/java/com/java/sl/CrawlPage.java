package com.java.sl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlPage {
    public static void main(String[] args){
        String home_url = "https://bj.lianjia.com/ershoufang/";
        String homePage = getString(home_url);
        Set<String> urls = getUrlList(homePage);
        for(String url : urls){
            System.out.println(url);
            System.out.println(getInformation(url));
            System.exit(0);
        }

    }
    //根据URL获取网页内容
    public static String getString(String inUrl){
        StringBuffer html = new StringBuffer();
        try {
            URL url = new URL(inUrl);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = reader.readLine();
            while(line != null){
                line = reader.readLine();
                html.append(line);
            }
            reader.close();
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return html.toString();
    }
//    从传入的内容中获取URL列表
    public static Set<String> getUrlList(String html) {
        Set<String> urls = new HashSet<String>();
        //设定URL格式正则匹配模式
        Pattern pattern = Pattern.compile("(https://bj.lianjia.com/ershoufang/\\d+.html)");
            Matcher matcher = pattern.matcher(html);
            while(matcher.find()) {
                urls.add(matcher.group());
            }
        return urls;
    }
    //从每个URL获取房子具体信息
    public static Map<String, String> getInformation(String url){
        String html = getString(url);
        Document doc = Jsoup.parse(html);

        Map<String, String> result = new HashMap<String, String>();
        Elements content = doc.select("div[class=introContent]").select("ul");

        int liCount = content.get(0).select("li").size();
        Elements item_k = content.get(0).select("[class=label]");
        Elements item_v = content.select("li");
        for (int i =0; i< liCount ;i++) {
            String k = item_k.get(i).text();
            String val = item_v.get(i).text();
            val = val.replace(k, "");
            result.put(k, val);
        }
        return result;
    }
}


