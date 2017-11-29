package demo.igeak.com.database.greendao;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by igeak on 2017/11/15.
 */

@Target({ElementType.METHOD,ElementType.TYPE,ElementType.FIELD,ElementType.LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
public @interface UserAnnotation {
    String name() default "";
    int age() default 10;
    //PersonAnnotation person();
}
