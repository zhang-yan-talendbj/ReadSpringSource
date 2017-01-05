package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.aop.TestBean;

/**
 * Created by thinkdeeply on 1-5.
 */
public class AopTest {
    public static void main(String[] args) {
        ApplicationContext bf = new ClassPathXmlApplicationContext("aspectTest.xml");
        TestBean bean = (TestBean) bf.getBean("test");
        bean.test();
    }
}
