package com.example.chenhaoqiang.test.retrofit;

import lombok.Getter;
import lombok.Setter;

/**
 * 从接口中请求的数据格式
 * 接口中采用GSON格式
 *@author chenhaoqiang
 *@date 2018/7/25
 */
@Getter
public class RequestData {
    private int status;
    private content content;

    private static class content {
        private String from;
        private String to;
        private String vendor;
        private String out;
        private int errNo;
    }

    //定义 输出返回数据 的方法
    public void show() {
        System.out.println(status);
        System.out.println(content.from);
        System.out.println(content.to);
        System.out.println(content.vendor);
        System.out.println(content.out);
        System.out.println(content.errNo);
    }
}
