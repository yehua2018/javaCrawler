package com.java.sl.bean;

import lombok.*;

/**
 * Author: zhangliujie
 * Time: 2018/9/30
 * Email: liujiezhangbupt@gmail.com
 * Description:
 */
@Getter(value = AccessLevel.PUBLIC)
@Setter(value = AccessLevel.PUBLIC)
@ToString()
@EqualsAndHashCode
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

}
