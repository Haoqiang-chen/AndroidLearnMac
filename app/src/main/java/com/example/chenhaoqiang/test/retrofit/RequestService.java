package com.example.chenhaoqiang.test.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
/**
 * 用于网络请求的接口
 * Retrofit将http请求抽象为Java接口
 * 然后根据接口中定义的请求（Call）进行网络请求
 *@author chenhaoqiang
 *@date 2018/7/25
 */
public interface RequestService {

    @GET("ajax.php?a=fy&f=auto&t=auto&w=hello%20world")
    Call<RequestData> getRequestData();
}
