package com.example.chenhaoqiang.test.json;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * JSON是一个轻量级的数据交换格式，可用于在不同平台间进行数据交换
 * JSON的语法规则：
 *     数据用name/value对存储，name是唯一的非空字符串
 *     数据用逗号分隔
 *     {}保存JSONObject即保存JSON对象
 *     []保存JSON数组
 * JSON中value的取值为：
 *     数字：（整数或者浮点数）
 *     字符串：""
 *     逻辑值：（true or false）
 *     数组：[]中 或者JSONArray
 *     对象：{}中 或者JSONObject
 *     空：null
 * JSON的主要API：位于org.json包中
 *     JSONObject：JSON对象类，表示一个JSON对象
 *     JSONArray：JSON数组类，表示一组有序的数值
 *     JSONTokener：JSON解析类，用于将JSON编码的字符串解析为相应的对象
 *     JSONStringer：JSON文本构建类，用于严格按照JSON的语法规则创建JSON
 *
 * JSON创建类：创建一个简单的JSON并输出
 * {
 *     "array":[
 *     {"json1":"1"},
 *     {"json2","2"},
 *     {"json3","3"}
 *     ],
 *     "object":{"name","value"}
 * }
 *@author chenhaoqiang
 *@date 2018/7/16
 */
public class CreatJson {


    public  CreatJson(){

        try {
            JSONObject root = new JSONObject();

            JSONArray array = new JSONArray();
            JSONObject json1 = new JSONObject();
            json1.put("json1", "1");
            JSONObject json2 = new JSONObject();
            json2.put("json2", "2");
            JSONObject json3 = new JSONObject();
            json3.put("json3", "3");
            array.put(json1);
            array.put(json2);
            array.put(json3);

            JSONObject object = new JSONObject();
            object.put("name", "value");

            root.put("array", array).put("object", object);

            /**
             * JSONObject的toString方法可以将JSON对象编码为JSON字符串
             * 注意System.out.println在Run里输出*/
            System.out.println(root.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }




    }
}
