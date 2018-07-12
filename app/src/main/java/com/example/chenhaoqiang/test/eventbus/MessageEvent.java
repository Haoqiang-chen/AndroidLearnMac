package com.example.chenhaoqiang.test.eventbus;

import lombok.Getter;
import lombok.Setter;

/**
 * EventBus中的事件
 *@author chenhaoqiang
 *@date 2018/7/12
 */
public class MessageEvent {
    @Getter
    @Setter
    private String message;

    public MessageEvent(String message){
        this.message = message;
    }
}
