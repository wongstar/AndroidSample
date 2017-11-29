package demo.igeak.com.database.greendao;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Created by igeak on 2017/11/15.
 */

@Target({ElementType.METHOD,ElementType.LOCAL_VARIABLE,ElementType.FIELD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PersonAnnotation {
    String say() default "hello";
    String move() default "walk";
    Sex  sex() default Sex.MAN;
}
