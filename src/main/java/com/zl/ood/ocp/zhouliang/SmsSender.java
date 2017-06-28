package com.zl.ood.ocp.zhouliang;

/**
 * Created by zhouliang on 2017-06-28.
 */
public class SmsSender implements Sender {
    @Override
    public void send(String msg) {
        System.out.println("SmsSender send msg");
    }
}
