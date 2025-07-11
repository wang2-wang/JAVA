package Demo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)  //注解作用在字段
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoDi {
}
