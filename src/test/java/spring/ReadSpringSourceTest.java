package spring;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.io.ClassPathResource;
import spring.aop.ITest;
import spring.aop.TestBean;
import spring.app.SimplePostProcessor;
import spring.app.TestEvent;
import spring.bean.A;
import spring.bean.ValuesBean;
import spring.custom.User;
import spring.ioc.MyTestBean;
import spring.jdbc.UserService;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by thinkdeeply on 1-5.
 */
public class ReadSpringSourceTest {
    @Test
    public void aop() throws Exception {
        ApplicationContext bf = new ClassPathXmlApplicationContext("aspectTest.xml");
        ITest bean = (ITest) bf.getBean("test");

//        bean.setTestBean(bean);
        bean.test();
    }

    @Test
    public void xmlAop() throws Exception {
        ApplicationContext bf = new ClassPathXmlApplicationContext("read-aop.xml");
        ITest bean = (ITest) bf.getBean("test");
        bean.test();
    }

    @Test
    public void application() throws Exception {
        ApplicationContext bf = new ClassPathXmlApplicationContext("application.xml");
        TestBean bean = (TestBean) bf.getBean("test");
        System.out.println(bean.getTestStr());
    }

    @Test
    public void applicationProperties() throws Exception {
        ApplicationContext bf = new ClassPathXmlApplicationContext("application-properties.xml");
        ValuesBean bean1 = bf.getBean(ValuesBean.class);
        System.out.println(bean1);
    }

    @Test
    public void applicationConverter() throws Exception {
        ApplicationContext bf = new ClassPathXmlApplicationContext("application-converter.xml");
        TestBean bean = (TestBean) bf.getBean("test");
        bean.test();
    }

    public void testStringToPhoneNumberConvert() {
//         DefaultConversionService conversionService = new DefaultConversionService();
//         conversionService.addConverter(new StringToPhoneNumberConverter());
//         String phoneNumberStr = "010-12345678";
//         PhoneNumberModel phoneNumber = conversionService.convert(phoneNumberStr, PhoneNumber
//                Model.class);
//         Assert.assertEquals("010", phoneNumber.getAreaCode());
    }

    @Test
    public void testConvert() throws Exception {
        DefaultConversionService service = new DefaultConversionService();

//        Currency currency = service.convert("RMB", Currency.class);
//        System.out.println(currency);

        Collection<String> list = service.convert("Deb, Mike, Kim", Collection.class);
        System.out.println(list);

    }

    @Test
    public void applicationEvent() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-event.xml");
        // TestBean bean = (TestBean) applicationContext.getBean("test");
        // bean.test();

        TestEvent event = new TestEvent("hello", "message");
        applicationContext.publishEvent(event);

    }

    @Test
    public void postprocessor() throws Exception {
        ApplicationContext bf = new ClassPathXmlApplicationContext("bean-factory-processor.xml");
        SimplePostProcessor bean = (SimplePostProcessor) bf.getBean("simpleBean");
        System.out.println(bean);
    }

    @Test
    public void customTag() throws Exception {
        ApplicationContext bf = new ClassPathXmlApplicationContext("custom.xml");
        User user = (User) bf.getBean("testbean");
        System.out.println(user.getUserName() + "," + user.getEmail());
    }

    @Test
    public void ioc() throws Exception {
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("bean-ioc.xml"));
        MyTestBean bean = (MyTestBean) bf.getBean("myTestBean");
        assertEquals("testStr", bean.getTestStr());
    }

    @Test
    public void beanDependency() throws Exception {
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("bean-abc.xml"));
        A bean = (A) bf.getBean("a");

        System.out.println(bean);
    }

    @Test
    public void factoryBean() throws Exception {
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("conf-factory-bean.xml"));

        System.out.println(bf.getBean("tool"));
        System.out.println(bf.getBean("tool"));
        System.out.println(bf.getBean("tool"));
        System.out.println(bf.getBean("tool"));
        System.out.println(bf.getBean("tool"));
    }

    @Test
    public void jdbc() throws Exception {
        ApplicationContext act = new ClassPathXmlApplicationContext("test-bean.xml");
        UserService userService = (UserService) act.getBean("userService");
        spring.jdbc.User user = new spring.jdbc.User();
        user.setName("张三");
        user.setAge(20);
        user.setSex("男");
        // 保存一条记录
        userService.save(user);
        List<spring.jdbc.User> person1 = userService.getUsers();
        System.out.println("++++++++得到所有User");
        for (spring.jdbc.User person2 : person1) {
            System.out.println(
                    person2.getId() + " " + person2.getName() + " " + person2.getAge() + " " + person2.getSex());
        }

    }

    @Test
    public void testBeanDefinitionRegistry() {
        BeanDefinitionRegistry beanDefinitionRegistry = new SimpleBeanDefinitionRegistry();
        AnnotatedGenericBeanDefinition genericBeanDefinition = new AnnotatedGenericBeanDefinition(Test.class);
        beanDefinitionRegistry.registerBeanDefinition("springBean",genericBeanDefinition);
        System.out.println(beanDefinitionRegistry.isBeanNameInUse("springBean"));
    }
}
