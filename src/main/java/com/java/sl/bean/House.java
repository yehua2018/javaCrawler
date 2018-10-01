package com.java.sl.bean;

/**
 * Author: zhangliujie
 * Time: 2018/9/30
 * Email: liujiezhangbupt@gmail.com
 * Description:
 */
public class House {

    //基本属性
    private String url; // url标识
    private String title; //标题
    private String houseType;//户型
    private String area;//面积
    private String towards;//朝向
    private String floor;//楼层高
    private String fitment;//装修情况
    private String community;//小区
    private String location;//地址
    private String price;//售价

    //构建方法
    public House(){

    }

    //get、set方法
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }
    public String getHouseType() {
        return this.houseType;
    }
    public void setArea(String area) {
        this.area = area;
    }
    public String getArea() {
        return this.area;
    }
    public void setTowards(String towards) {
        this.towards = towards;
    }
    public String getTowards() {
        return this.towards;
    }
    public void setFloor(String floor) {
        this.floor = floor;
    }
    public String getFloor() {
        return this.floor;
    }
    public void setCommunity(String community) {
        this.community = community;
    }
    public String getCommunity() {
        return this.community;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getLocation() {
        return this.location;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public String getPrice() {
        return this.price;
    }

    public void setFitment(String fitment) {
        this.fitment = fitment;
    }
    public String getFitment() {
        return this.fitment;
    }

}
