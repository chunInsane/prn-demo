package my.chuninsane.prn.util;

import my.chuninsane.prn.spi.AliPayService;
import my.chuninsane.prn.spi.PayService;
import my.chuninsane.prn.spi.WechatPayService;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author chuninsane
 */
public class ServiceLoaderTest {

    private ServiceLoader<PayService> serviceLoader = ServiceLoader.load(PayService.class);

    @Test
    public void testFindClass() {
        Class<PayService> cls = serviceLoader.findClass("aliPay");
        Assert.assertNotNull(cls);
        Assert.assertEquals(AliPayService.class, cls);
        cls = serviceLoader.findClass("wechatPay");
        Assert.assertNotNull(cls);
        Assert.assertEquals(WechatPayService.class, cls);
    }

    @Test
    public void testNewDefault() {
        PayService payService = serviceLoader.newDefault();
        Assert.assertNotNull(payService);
        Assert.assertTrue(payService instanceof AliPayService);
    }
}
