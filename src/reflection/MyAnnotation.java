package reflection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by zfz on 2018/4/6.
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    String name();
    String value();
}
