package spring.annotation;

import org.junit.Test;
import org.springframework.core.annotation.AliasFor;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

public class AliasForDemo {


    public static class TestBean
    {

        @AliasFor("test")
        public void test()
        {}
    }


    @Test
    public void test1() throws NoSuchMethodException {
        Method method=TestBean.class.getMethod("test",null);

        AliasFor aliasFor1=method.getAnnotation(AliasFor.class);
        AliasFor aliasFor2= AnnotationUtils.synthesizeAnnotation(aliasFor1,null);
        AliasFor aliasFor3=AnnotationUtils.getAnnotation(method,AliasFor.class);

        System.out.println(aliasFor1);
    }

    @Test
    public void test2() throws NoSuchMethodException {

        ContextConfig contextConfig1 = SimpleConfigTestCase.class.getAnnotation(ContextConfig.class);
        ContextConfig contextConfig2=AnnotationUtils.synthesizeAnnotation(contextConfig1,null);
        ContextConfig contextConfig3=AnnotationUtils.getAnnotation(SimpleConfigTestCase.class,ContextConfig.class);
    }

    @ContextConfig("simple.xml")
    static class SimpleConfigTestCase {
    }

    @Retention(RetentionPolicy.RUNTIME)
    @interface ContextConfig {

        @AliasFor("location")
        String value() default "";

        @AliasFor("value")
        String location() default "";

        Class<?> klass() default Object.class;
    }
}