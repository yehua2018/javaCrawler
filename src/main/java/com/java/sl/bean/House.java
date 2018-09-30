package com.java.sl.bean;

/**
 * Author: zhangliujie
 * Time: 2018/9/30
 * Email: liujiezhangbupt@gmail.com
 * Description:
 */
public class House {
    //基本属性
    private String houseType;//户型
    private String area;//面积
    private String houseOrientation;//朝向
    private String storeyHeight;//楼层高
    private String fitment;//装修情况
    private String plot;//小区
    private String location;//地址
    private String sale;//售价
    private String heatingMethod;//供暖方式
    //get、set方法
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
    public void setHouseOrientation(String houseOrientation) {
        this.houseOrientation = houseOrientation;
    }
    public String getHouseOrientation() {
        return this.houseOrientation;
    }
    public void setStoreyHeight(String storeyHeight) {
        this.storeyHeight = storeyHeight;
    }
    public String getStoreyHeight() {
        return this.storeyHeight;
    }
    public void setPlot(String plot) {
        this.plot = plot;
    }
    public String getPlot() {
        return this.plot;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getLocation() {
        return this.location;
    }
    public void setSale(String sale) {
        this.sale = sale;
    }
    public String getSale() {
        return this.sale;
    }

    public void setFitment(String fitment) {
        this.fitment = fitment;
    }
    public String getFitment() {
        return this.fitment;
    }

    public void setHeatingMethod(String heatingMethod) {
        this.heatingMethod = heatingMethod;
    }
    public String getHeatingMethod() {
        return this.heatingMethod;
    }

    //构建方法
    public House(){

    }

}
