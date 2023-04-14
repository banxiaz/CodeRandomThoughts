package 代理模式.静态代理;

public class Main {
    public static void main(String[] args) {
        SmsService smsService = new SmsServiceImpl(); //被代理对象
        SmsService smsProxy = new SmsProxy(smsService); //代理对象
        smsProxy.send("java");
    }
}
