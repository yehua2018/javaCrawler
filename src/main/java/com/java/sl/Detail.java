package com.java.sl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Detail {
    /*
    负责解析页面中的二手房房源信息
     */
    public Map<String, String> ershoufang(String html){
        Map<String, String> info = new HashMap<String, String>();
        Document doc = Jsoup.parse(html);
        Elements content = doc.select("div[class=introContent]").select("ul");

        int liCount = content.get(0).select("li").size();
        Elements item_k = content.get(0).select("[class=label]");
        Elements item_v = content.select("li");
        for (int i =0; i< liCount ;i++) {
            String k = item_k.get(i).text();
            String val = item_v.get(i).text();
            val = val.replace(k, "");
            info.put(k, val);
        }
        return info;
    }

    public Map<String, String> ershoufang(URL url){
        Page page = new Page();
        String htmls = page.fetch(url);
        Map<String, String> info = new HashMap<String, String>();
        info = ershoufang(htmls);
        return info;
    }
    /*
     负责解析页面中的租房源信息
     */
    public Map<String, String> zufang(String html){
        Map<String, String> info = new HashMap<String, String>();

        return info;
    }
}
