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
public class Rent extends House{
    public Rent() {

    }
    private String rentType;//租赁方式
    private String payType;//付款方式
    private String vacantOrNot;//房屋状况
}
