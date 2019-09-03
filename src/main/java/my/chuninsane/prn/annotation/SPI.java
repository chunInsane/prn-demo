package my.chuninsane.prn.annotation;

import java.lang.annotation.*;

/**
 * @author chuninsane
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface SPI {

    String name();

    boolean isDefault() default false;
}
