package com.java.sl.core;


import com.java.sl.bean.Ershoufang;
import com.java.sl.bean.HouseData;
import us.codecraft.webmagic.Page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: zhangliujie
 * Time: 2018/9/30
 * Email: liujiezhangbupt@gmail.com
 * Description:
 */
public class PageParser {

    public Ershoufang process(Page page, String houseType){
        Ershoufang houseData = dealEr(page);

        return houseData;
    }

    public Ershoufang dealEr(Page page){
        Ershoufang houseInfo = new Ershoufang();

        houseInfo.setUrl(page.getUrl().toString());

        String title = page.getHtml().xpath("/html/body/div[3]/div/div/div[1]/h1/text()").get(); // 标题
        houseInfo.setTitle(title);

        String price = page.getHtml().xpath("/html/body/div[5]/div[2]/div[2]/span[1]/text()").get(); // 价格 单位：万
        houseInfo.setPrice(price);

        String room = page.getHtml().xpath("/html/body/div[5]/div[2]/div[3]/div[1]/div[1]/text()").get(); // 2室1厅
        houseInfo.setRoom(room);

        String floor = page.getHtml().xpath("/html/body/div[5]/div[2]/div[3]/div[1]/div[2]/text()").get(); // 中楼层/共21层
        houseInfo.setFloor(floor);

        String toward = page.getHtml().xpath("/html/body/div[5]/div[2]/div[3]/div[2]/div[1]/text()").get(); // 南 北
        houseInfo.setTowards(toward);

        String fitment = page.getHtml().xpath("/html/body/div[5]/div[2]/div[3]/div[2]/div[2]/text()").get(); // 平层/简装
        houseInfo.setFitment(fitment);

        String area = page.getHtml().xpath("/html/body/div[5]/div[2]/div[3]/div[3]/div[1]/text()").get(); // 102.09平米
        houseInfo.setArea(area);

        String year = page.getHtml().xpath("/html/body/div[5]/div[2]/div[3]/div[3]/div[2]/text()").get(); // 2007年建/板塔结合
        houseInfo.setYear(year);

        String community = page.getHtml().xpath("/html/body/div[5]/div[2]/div[4]/div[1]/a[1]/text()").get(); //三环新城6号院
        houseInfo.setCommunity(community);

        String location = listToString(page.getHtml().xpath("/html/body/div[5]/div[2]/div[4]/div[2]/span[2]/allText()").all());
        houseInfo.setLocation(location);
        // 获取房屋基本属性
        Map<String, String> baseInfo = getBaseInfo(page);
        houseInfo.setBaseInfo(baseInfo);

        // 获取房屋交易属性
        Map<String, String> tradingInfo = getTradInfo(page);
        houseInfo.setTradInfo(tradingInfo);

        houseInfo.freshInfo();

        return houseInfo;
    }

    protected Map<String, String> getBaseInfo(Page page){
        Map<String, String> baseInfo = new HashMap<String, String>();
        List<String> tags = page.getHtml().xpath("//*[@id=\"introduction\"]/div/div/div[1]/div[2]/ul/li/span/text()").all();
        List<String> vals = page.getHtml().xpath("//*[@id=\"introduction\"]/div/div/div[1]/div[2]/ul/li/text()").all();
        for(int i=0;i<tags.size();++i){
            baseInfo.put(tags.get(i), vals.get(i).replace(" ", ""));
        }
        return baseInfo;
    }

    protected Map<String, String> getTradInfo(Page page){
        Map<String, String> tradingInfo = new HashMap<String, String>();
        List<String> tags = page.getHtml().xpath("//*[@id=\"introduction\"]/div/div/div[2]/div[2]/ul/li/span[1]/text()").all();
        List<String> vals = page.getHtml().xpath("//*[@id=\"introduction\"]/div/div/div[2]/div[2]/ul/li/span[2]/text()").all();
        for(int i = 0; i < tags.size();i++) {
            tradingInfo.put(tags.get(i),vals.get(i).replace(" ", ""));
        }
        return tradingInfo;
    }

    // 把list转换为string，用空格分割
    public static String listToString(List<String> stringList) {
        if (stringList == null) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        boolean flag = false;
        for (String string : stringList) {
            if (flag) {
                result.append(" ");
            } else {
                flag = true;
            }
            result.append(string);
        }
        return result.toString().replace("&nbsp;", "");
    }
}
