package src.com.huahua.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description:
 * 关于 Target 元注解
 *   自定义注解的作用域
 * 关于 Retention 注解
 *   注解保留策略
 * @author：张佳伟
 * @date: 2024/7/25
 */
@Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Pet {
}
