package spring;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import spring.aop.TestBean;
import spring.custom.User;
import spring.ioc.MyTestBean;
import spring.jdbc.UserService;

/**
 * Created by thinkdeeply on 1-5.
 */
public class ReadSpringSourceTest {
    @Test
    public void aop() throws Exception {
        ApplicationContext bf = new ClassPathXmlApplicationContext("aspectTest.xml");
        TestBean bean = (TestBean) bf.getBean("test");
        bean.test();
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
}
