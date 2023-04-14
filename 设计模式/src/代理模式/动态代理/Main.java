package 代理模式.动态代理;

import 代理模式.静态代理.SmsService;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        //这里演示了动态代理的核心方法，并没有在代理类中真正的调用代理类
        SmsService smsService = (SmsService) Proxy.newProxyInstance(
                Main.class.getClassLoader(),
                new Class<?>[]{SmsService.class},
                new SmsProxy()
        );
        smsService.send("hello");
    }
}
