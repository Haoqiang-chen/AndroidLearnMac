package com.example.chenhaoqiang.test.retrofit;

import android.content.Context;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * http://square.github.io/retrofit/
 * 使用Retrofit对象进行网络请求
 * 首先创建retrofit的实例并设置数据解析器的类型
 * 然后创建网络请求接口的实例并进行异步的网络请求
 * 在请求成功或者失败的回调函数里写自己的逻辑
 *@author chenhaoqiang
 *@date 2018/7/25
 */
public class RequestRetrofit {

    public RequestRetrofit(final Context context){
        //创建Retrofit实例
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://fy.iciba.com/") //网络请求的URL地址可以分为两个部分分别设置
                .addConverterFactory(GsonConverterFactory.create())//设置数据解析器 在使用不同解析器时需要在Gradle中添加依赖
                .build();
        //创建网络请求接口的实例
        RequestService requestService = retrofit.create(RequestService.class);
        requestService.getRequestData().enqueue(new Callback<RequestData>() {
            @Override
            public void onResponse(Call<RequestData> call, Response<RequestData> response) {
                response.body().show();
                System.out.println("网络请求信息：" +response.message());
            }

            @Override
            public void onFailure(Call<RequestData> call, Throwable t) {
                System.out.println("网络请求失败");
            }
        });

    }
}
