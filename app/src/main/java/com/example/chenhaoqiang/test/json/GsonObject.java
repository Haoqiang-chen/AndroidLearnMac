package com.example.chenhaoqiang.test.json;

import lombok.Getter;

/**
 * GSON中需要被序列化的类
 *@author chenhaoqiang
 *@date 2018/7/16
 */
@Getter
public class GsonObject {
    private int value1 = 1;
    private transient int value2 = 2;
    private String str1 = "string1";

    public GsonObject(){

    }
}
