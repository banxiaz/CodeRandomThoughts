package SPIDemo;

import SPIDemo.spi.LoggerService;

public class Main {
    public static void main(String[] args) {
        LoggerService service = LoggerService.getService();
        service.info("hello SPI");
        service.debug("hellohello SPI");
    }
}
