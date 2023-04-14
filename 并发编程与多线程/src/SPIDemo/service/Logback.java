package SPIDemo.service;

import SPIDemo.spi.Logger;

public class Logback implements Logger {

    @Override
    public void info(String msg) {
        System.out.println("Logback info 打印日志：" + msg);
    }

    @Override
    public void debug(String msg) {
        System.out.println("Logback debug 打印日志：" + msg);
    }
}
