package com.example.chenhaoqiang.test.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 用于学些GSON的类
 * https://github.com/google/gson
 *@author chenhaoqiang
 *@date 2018/7/16
 */
public class GsonTest {

    public GsonTest(){
        /**
         * 将一个类对象进行序列化
         * 注意不要序列化拥有循环引用的对象，因为会产生无限递归的情况
         * 序列化对象中需要注意的地方：
         *    在需要序列化的类中尽量使用private来定义变量
         *    不需要使用注解来声明一个变量是否需要序列化或者反序列化，因为默认情况下当前类及其父类中的变量都包括其中
         *    如果变量被声明为 transient，则该该变量将不会被序列化和反序列化
         *    可以正确处理null的情况：在序列化时null字段将不会被序列化；在反序列化时JSON中缺少的记录将被序列化为相应字段的默认值即基本变量和对象的默认值
         *    如果字段是合成类型（synthetic）则将不会被序列化和反序列化
         *    若内部类、匿名类、局部类中某个字段和外部类中的字段相同则不会被序列化和反序列化
         *    嵌套类（包括内部类）：
         *        GSON可以序列化静态嵌套类
         *        GSON可以反序列化静态嵌套类，但是GSON不能自动反序列化纯内部类，因为纯内部类的无参数构造方法需要一个对象来引用，可以声明为静态或者实现InstanceCreator来反序列化
         *    */
        GsonObject gsonObject = new GsonObject();
        Gson gson = new Gson();
        String json = gson.toJson(gsonObject);
        System.out.println(json);

        /**
         * 将一个json String反序列化为一个类对象*/
        GsonObject gsonObject1 = gson.fromJson(json, GsonObject.class);
        System.out.println(Integer.toString(gsonObject1.getValue1()) + Integer.toString(gsonObject1.getValue2()) + gsonObject1.getStr1());

        /**
         * 数组的序列化与反序列化
         * GSON支持具有任意复杂类型元素的多维数组*/
        int array[] = new int[]{1, 2, 3, 4, 5};
        String jsonArray = gson.toJson(array); //序列化
        System.out.println(jsonArray);

        int array1[] = gson.fromJson(jsonArray, int[].class);//反序列化
        System.out.println(array[2]);

        /**
         * 集合的序列化与反序列化
         * 反序列化时注意应该获取集合的Type类型
         * */
        Collection<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        String jsonCollection = gson.toJson(integers);
        System.out.println(jsonCollection);

        Type collectionType = new TypeToken<Collection<Integer>>(){}.getType();
        Collection<Integer> integers1 = gson.fromJson(jsonCollection, collectionType);
        System.out.println(integers1.size());

        /**
         * 范型的序列化与反序列化
         * 对于范型要使用TypeToken类来获取范型的类型
         * 使用方法如：Type collectionType = new TypeToken<Collection<Integer>>(){}.getType();
         * */

        /**
         * 5种注解
         * SerializedName：用于转换json中数据的key的名称
         * Expose：与GsonBuilder()创建的Gson对象共同使用，此时默认情况下不添加此注解的字段都不会被序列化和反序列化
         * Since(float v)：结合GsonBuilder.setVersion(n)进行版本控制，当n>=v时才会进行
         * Util(float v)：结合GsonBuilder.setVersion(n)进行版本控制，当n<v时才会进行
         *
         * */
    }
}
