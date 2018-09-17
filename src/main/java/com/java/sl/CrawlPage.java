package com.java.sl;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlPage {
    //声明属性信息
    private String url_id;
    private String url_code;
    private String create_date;
    private String update_date;
    private int url_type;
    //自定义构建方法
    CrawlPage(String url_code,String create_date,String update_date,int url_type){
        this.url_id = null;//default
        this.url_code = url_code;
        this.create_date = create_date;
        this.update_date = update_date;
        this.url_type = url_type;
    }
    //url_id 的getter、setter方法
//    public void setUrl_id(String url_id){
//        this.url_id = url_id;
//    }
//    public String getUrl_id(){
//        return url_id;
//    }
//    //url_code 的getter、setter方法
//    public void setUrl_code(String url_code){
//        this.url_code = url_code;
//    }
//    public String getUrl_code(){
//        return url_code;
//    }
//    //create_date 的getter、setter方法
//    public void setCreate_date(String create_date){
//        this.create_date = create_date;
//    }
//    public String getCreate_date(){
//        return create_date;
//    }
//    //update_date 的getter、setter方法
//    public void setUpdate_date(String update_date){
//        this.update_date = update_date;
//    }
//    public String getUpdate_date(){
//        return update_date;
//    }
//    //url_type 的getter、setter方法
//    public void setUrl_type(int url_type){
//        this.url_type = url_type;
//    }
//    public int getUrl_type(){
//        return url_type;
//    }
//
//    public static void main(String[] args){
//        String home_url = "https://bj.lianjia.com/ershoufang/";
//        String homePage = getString(home_url);
//        Set<String> urls = getUrlList(homePage);
//        for(String url : urls){
//            System.out.println(url);
//            System.out.println(getInformation(url));
//            System.exit(0);
//        }
//        //数据库操作
//        java.sql.Date sdate;//声明数据库支持的时间类型
//        java.util.Date udate;//声明java支持的时间类型；
//        udate = new java.util.Date();//获取系统日期
//        sdate = new java.sql.Date(udate.getTime());//java获取系统日期后由数据库date方法转换成数据库支持的格式
//        //url_code由getUrlList方法获取，url_type在各方法内定义
//    }
//    //根据URL获取网页内容
//    public static String getString(String inUrl){
//        StringBuffer html = new StringBuffer();
//        try {
//            URL url = new URL(inUrl);
//            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
//            String line = reader.readLine();
//            while(line != null){
//                line = reader.readLine();
//                html.append(line);
//            }
//            reader.close();
//        }
//        catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
//        return html.toString();
//    }
//    //    从传入的内容中获取URL列表
//    public static Set<String> getUrlList(String html) {
//        Set<String> urls = new HashSet<String>();
//        //设定URL格式正则匹配模式
//        Pattern pattern = Pattern.compile("(https://bj.lianjia.com/ershoufang/\\d+.html)");
//        Matcher matcher = pattern.matcher(html);
//        while(matcher.find()) {
//            urls.add(matcher.group());
//        }
//        return urls;
//    }
//    //从每个URL获取房子具体信息
//    public static Map<String, String> getInformation(String url){
//        String html = getString(url);
//        Document doc = Jsoup.parse(html);
//
//        Map<String, String> result = new HashMap<String, String>();
//        Elements content = doc.select("div[class=introContent]").select("ul");
//
//        int liCount = content.get(0).select("li").size();
//        Elements item_k = content.get(0).select("[class=label]");
//        Elements item_v = content.select("li");
//        for (int i =0; i< liCount ;i++) {
//            String k = item_k.get(i).text();
//            String val = item_v.get(i).text();
//            val = val.replace(k, "");
//            result.put(k, val);
//        }
//        return result;
//    }
//    //对url列表做jdbc操作
//    //链接Connection的获取方法
//    private static Connection getConn(){
//        String driver = "com.mysql.jdbc.Driver";//声明Mysql数据库驱动，并赋值给driver一个变量
//        String url = "jdbc:mysql://localhost:3306/DemoTest";//服务器上数据库的url
//        String username = "root";//数据库账户
//        String password = "ttdsj84261@";//数据库密码
//        Connection conn = null;//声明数据库链接
//        try {
//            /*强制JVM将com.mysql.jdbc.Driver这个类加载入内存，
//            并将其注册到DriverManager类，然后根据DriverManager.getConnection（url，user,pwd）中的url找到相应的驱动类，
//            最后调用该该驱动类的connect(url, info)来获得connection对象。
//            参考链接：https://www.cnblogs.com/liuxianan/archive/2012/08/04/2623258.html
//             */
//            Class.forName(driver);
//            //生成连接
//            conn = (Connection) DriverManager.getConnection(url,username,password);
//        }
//        //捕获加载驱动程序异常
//        catch (ClassNotFoundException e){
//            System.err.println("加载jdbc驱动程序失败");
//            e.printStackTrace();
//        }
//        //捕获连接数据库异常
//        catch (SQLException e) {
//            System.err.println("连接数据库失败");
//            e.printStackTrace();
//        }
//        return conn;
//    }
//    //execute selection，该方法返回类型为Interger，为一个对象，用一个引用指向这个对象，初始值为null
//    private static Integer selectSql(){
//        Connection conn = getConn();//调用连接数据库方法
//        String select = "select url_id,url_code,create_date,update_date,url_type from Estate_Url where url_code = ? or url_code is null";//查询Estate_Url表中所有的记录
//        PreparedStatement statement;//预编译语句声明
//        try {
//            statement = (PreparedStatement) conn.prepareStatement(select);//使用prepareStatement预编译sql语句
//            ResultSet rs = statement.executeQuery();//预编译语句在数据库执行
//            int colCnt = rs.getMetaData().getColumnCount();//获取查询数据的元数据
//            System.out.println("===============================================================");
//            System.out.println("url_id"+"\t"+"url_code"+"\t"*5+"create_date"+"\t"+"update_date"+"\t"+"url_type");
//            //根据指针指向记录，依次打印出每条记录的元数据
//            while (rs.next()){
//                for (int i = 1; i <= colCnt; i++){
//                    System.out.print(rs.getString(i)+"\t");
//                }
//            }
//            System.out.println("===============================================================");
//        }
//        catch (SQLException e){
//            e.printStackTrace();
//        }
//        return null;
//    }
//    //execute insert
//    private static int insertSql(CrawlPage crawlPage){
//        Connection conn = getConn();//调用连接数据库方法
//        int i = 0;//插入记录数，初始为零
//        String insert = "insert into Estate_Url(url_code,create_date,update_date,url_type) values(?,now()，now()，?)";//插入新的数据
//        PrepareStatement statement;//预编译语句声明
//        try{
//            statement = (prepareStatement) conn.prepareStatement(insert);
//            statement.setString(crawlPage.getUrl_code());
//            statement.setString(crawlPage.getUrl_type());
//            i = statement.excuteUpdate();
//            statement.close();
//            conn.close();
//        }
//        catch (SQLException e){
//            e.printStackTrace();
//        }
//        return i;//返回插入记录数
//    }
//    //execute deleteSql
//    private static int deleteSql(String url_code) {
//        Connection conn = getConn();
//        String delete = "delete from Estate_Url where url_code = ? or url_code is null";//删除输入的url记录
//        PrepareStatement statement;
//        int i = 0;
//        try {
//            statement = (PrepareStatement) conn.prepareStatement(delete);
//            i = statement.executeUpdate();
//            System.out.println("result: " + i);
//            statement.close();
//            conn.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return i;
//    }
//    //execute updateSql
//    private static int updateSql(CrawlPage crawlPage){
//        Connection conn = getConn();
//        String update = "update Estate_Url set update_date = now() where url_code = '"+ crawlPage.getUrl_code()+"' or url_code is null";//更新数据，只改变的最后更新时间
//        PrepareStatement statement;
//        int i = 0;
//        try {
//            statement = (PrepareStatement) conn.prepareStatement(update);
//            i = statement.executeUpdate();
//            System.out.println("result: "+i);
//            statement.close();
//            conn.close();
//        }
//        catch (SQLException e){
//            e.printStackTrace();
//        }
//        return i;
//    }
}


