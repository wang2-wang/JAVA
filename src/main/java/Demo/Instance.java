package Demo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)   //说明自定义注解在类和接口使用
@Retention(RetentionPolicy.RUNTIME)     //说明注解在运行期生效
public @interface Instance {
}
