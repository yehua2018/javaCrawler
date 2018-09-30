package com.java.sl.bean;

/**
 * Author: zhangliujie
 * Time: 2018/9/30
 * Email: liujiezhangbupt@gmail.com
 * Description:
 */
public class Ershoufang extends House{

    public Ershoufang() {

    }

    // 房源基本属性信息
    private String houseStructure;//户型结构
    private String inArea;//套内面积
    private String buildingType;//建筑类型
    private String buildingStructure;//建筑结构
    private String ladderHouseHoldProportion;//梯户比例
    private String ladderOrNot;//是否有电梯
    private String propertyRight;//产权年限
    // 房源交易信息
    private String forTheTime;//挂牌时间
    private String transaction;//交易权属
    private String lastTranTime;//上次交易时间
    private String houseUse;//房屋用途
    private String houseTimeLine;//房屋年限
    private String mortgageMessage;//抵押信息
    private String houseReplacement;//房本备件

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
}
