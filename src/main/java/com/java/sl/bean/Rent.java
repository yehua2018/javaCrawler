package com.java.sl.bean;

/**
 * Author: zhangliujie
 * Time: 2018/9/30
 * Email: liujiezhangbupt@gmail.com
 * Description:
 */
public class Rent extends House{
    public Rent() {

    }
    private String rentType;//租赁方式
    private String payType;//付款方式
    private String vacantOrNot;//房屋状况

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getVacantOrNot() {
        return vacantOrNot;
    }

    public void setVacantOrNot(String vacantOrNot) {
        this.vacantOrNot = vacantOrNot;
    }
}