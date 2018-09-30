package com.java.sl.core;

import com.java.sl.bean.Ershoufang;
import com.java.sl.bean.HouseData;
import com.java.sl.dao.HouseDao;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Author: zhangliujie
 * Time: 2018/9/30
 * Email: liujiezhangbupt@gmail.com
 * Description:
 */
public class LianjiaProcessor implements PageProcessor{
    private static String houseType = "ershoufang"; // 板块名称
    private static int size = 0;  // 抓取的房源数目
    private static Set historyUrls = new HashSet();

    // 抓取网站的相关配置，包括：编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    public Site getSite(){
        return site;
    }

    public void process(Page page){
        // 解析列表页
        if(!page.getUrl().regex("lianjia.com/"+ houseType + "/\\d+.html").match()){
            List<String> urls = page.getHtml().xpath("//*[@id=\"leftContent\"]/ul").links()
                    .regex("https://bj.lianjia.com/"+ houseType + "/\\d+.html").all();
            urls = removeDuplcate(urls);  // 去重
            page.addTargetRequests(urls);

            // 下一页
            List<String> nextPage = page.getHtml().xpath("//*[@id=\"leftContent\"]/div[8]/div[2]/div/a/@href").all();
            System.out.println(nextPage);

        }
        // 解析详情页详情页
        else{
            size ++;
            PageParser pageParser = new PageParser();
            Ershoufang houseData = pageParser.process(page, houseType);

            new HouseDao().add(houseData, houseType); // 保存到数据库
//            System.out.println(houseData);
        }
    }

    // 元素去重
    public List<String> removeDuplcate(List<String> items){
        Set set = new HashSet();
        set.addAll(items);
        items.clear();
        items.addAll(set);
        return items;
    }

    public static void main(String[] args){
        long startTime, endTime;
        System.out.println("【爬虫开始】请耐心等待一大波数据到你碗里来...");
        startTime = System.currentTimeMillis();
        // 从用户博客首页开始抓，开启5个线程，启动爬虫
        Spider.create(new LianjiaProcessor()).addUrl("https://bj.lianjia.com/ershoufang/").thread(5).run();
        endTime = System.currentTimeMillis();
        System.out.println("【爬虫结束】共抓取" + size + "个房源，耗时约" + ((endTime - startTime) / 1000) + "秒，已保存到数据库，请查收！");
    }
}
