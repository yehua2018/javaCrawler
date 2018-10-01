package com.java.sl.bean;

import org.assertj.core.data.MapEntry;

import java.util.Map;

/**
 * Author: zhangliujie
 * Time: 2018/9/30
 * Email: liujiezhangbupt@gmail.com
 * Description:
 */
public class Ershoufang extends House {

    public Ershoufang() {

    }

    private String room;
    private String year;

    // 房源基本属性信息
    private Map baseInfo;

    private String houseStructure;//户型结构
    private String inArea;//套内面积
    private String buildingType;//建筑类型
    private String buildingStructure;//建筑结构
    private String ladderHouseHoldProportion;//梯户比例
    private String ladderOrNot;//是否有电梯
    private String propertyRight;//产权年限

    // 房源交易信息
    private Map tradInfo;

    private String forTheTime;//挂牌时间
    private String transaction;//交易权属
    private String lastTranTime;//上次交易时间
    private String houseUse;//房屋用途
    private String houseTimeLine;//房屋年限
    private String mortgageMessage;//抵押信息
    private String houseReplacement;//房本备件

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Map getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(Map baseInfo) {
        this.baseInfo = baseInfo;
    }

    public Map getTradInfo() {
        return tradInfo;
    }

    public void setTradInfo(Map tradInfo) {
        this.tradInfo = tradInfo;
    }
    public String getHouseStructure() {
        return houseStructure;
    }

    public void setHouseStructure(String houseStructure) {
        this.houseStructure = houseStructure;
    }

    public String getInArea() {
        return inArea;
    }

    public void setInArea(String inArea) {
        this.inArea = inArea;
    }

    public String getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType;
    }

    public String getBuildingStructure() {
        return buildingStructure;
    }

    public void setBuildingStructure(String buildingStructure) {
        this.buildingStructure = buildingStructure;
    }

    public String getLadderHouseHoldProportion() {
        return ladderHouseHoldProportion;
    }

    public void setLadderHouseHoldProportion(String ladderHouseHoldProportion) {
        this.ladderHouseHoldProportion = ladderHouseHoldProportion;
    }

    public String getLadderOrNot() {
        return ladderOrNot;
    }

    public void setLadderOrNot(String ladderOrNot) {
        this.ladderOrNot = ladderOrNot;
    }

    public String getPropertyRight() {
        return propertyRight;
    }

    public void setPropertyRight(String propertyRight) {
        this.propertyRight = propertyRight;
    }

    public String getForTheTime() {
        return forTheTime;
    }

    public void setForTheTime(String forTheTime) {
        this.forTheTime = forTheTime;
    }

    public String getTransaction() {
        return transaction;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }

    public String getLastTranTime() {
        return lastTranTime;
    }

    public void setLastTranTime(String lastTranTime) {
        this.lastTranTime = lastTranTime;
    }

    public String getHouseUse() {
        return houseUse;
    }

    public void setHouseUse(String houseUse) {
        this.houseUse = houseUse;
    }

    public String getHouseTimeLine() {
        return houseTimeLine;
    }

    public void setHouseTimeLine(String houseTimeLine) {
        this.houseTimeLine = houseTimeLine;
    }

    public String getMortgageMessage() {
        return mortgageMessage;
    }

    public void setMortgageMessage(String mortgageMessage) {
        this.mortgageMessage = mortgageMessage;
    }

    public String getHouseReplacement() {
        return houseReplacement;
    }

    public void setHouseReplacement(String houseReplacement) {
        this.houseReplacement = houseReplacement;
    }

    public void freshInfo(){

        // 房屋基础信息
        if(baseInfo.containsKey("户型结构"))
            houseStructure = (String) baseInfo.get("户型结构");
        if(baseInfo.containsKey("套内面积"))
            inArea = (String) baseInfo.get("套内面积");
        if(baseInfo.containsKey("建筑类型"))
            buildingType = (String) baseInfo.get("建筑类型");
        if(baseInfo.containsKey("建筑结构"))
            buildingStructure = (String) baseInfo.get("建筑结构");
        if(baseInfo.containsKey("梯户比例"))
            ladderHouseHoldProportion = (String) baseInfo.get("梯户比例");
        if(baseInfo.containsKey("是否有电梯"))
            ladderOrNot = (String) baseInfo.get("是否有电梯");
        if(baseInfo.containsKey("产权年限"))
            propertyRight = (String) baseInfo.get("产权年限");

        // 房屋交易信息
        if(tradInfo.containsKey("挂牌时间"))
            forTheTime = (String) tradInfo.get("挂牌时间");
        if(tradInfo.containsKey("交易权属"))
            transaction = (String) tradInfo.get("交易权属");
        if(tradInfo.containsKey("上次交易"))
            lastTranTime = (String) tradInfo.get("上次交易");
        if(tradInfo.containsKey("房屋用途"))
            houseUse = (String) tradInfo.get("房屋用途");
        if(tradInfo.containsKey("房屋年限"))
            houseTimeLine = (String) tradInfo.get("房屋年限");
        if(tradInfo.containsKey("抵押信息"))
            mortgageMessage = (String) tradInfo.get("抵押信息");
        if(tradInfo.containsKey("房本备件"))
            houseReplacement = (String) tradInfo.get("房本备件");


    }

    @Override
    public String toString() {
        return "Ershoufang{" +
                "room='" + room + '\'' +
                ", year='" + year + '\'' +
                ", baseInfo=" + baseInfo +
                ", houseStructure='" + houseStructure + '\'' +
                ", inArea='" + inArea + '\'' +
                ", buildingType='" + buildingType + '\'' +
                ", buildingStructure='" + buildingStructure + '\'' +
                ", ladderHouseHoldProportion='" + ladderHouseHoldProportion + '\'' +
                ", ladderOrNot='" + ladderOrNot + '\'' +
                ", propertyRight='" + propertyRight + '\'' +
                ", tradInfo=" + tradInfo +
                ", forTheTime='" + forTheTime + '\'' +
                ", transaction='" + transaction + '\'' +
                ", lastTranTime='" + lastTranTime + '\'' +
                ", houseUse='" + houseUse + '\'' +
                ", houseTimeLine='" + houseTimeLine + '\'' +
                ", mortgageMessage='" + mortgageMessage + '\'' +
                ", houseReplacement='" + houseReplacement + '\'' +
                '}';
    }
}
