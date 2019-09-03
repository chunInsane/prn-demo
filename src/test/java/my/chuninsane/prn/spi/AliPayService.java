package my.chuninsane.prn.spi;

import my.chuninsane.prn.annotation.SPI;

/**
 * @author chuninsane
 */
@SPI(name = "aliPay", isDefault = true)
public class AliPayService implements PayService {

    @Override
    public void pay() {
        System.out.println("aliPay");
    }
}
