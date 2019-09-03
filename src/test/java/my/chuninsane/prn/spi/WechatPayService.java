package my.chuninsane.prn.spi;

import my.chuninsane.prn.annotation.SPI;

/**
 * @author chuninsane
 */
@SPI(name = "wechatPay")
public class WechatPayService implements PayService {

    @Override
    public void pay() {
        System.out.println("wechatPay");
    }
}
