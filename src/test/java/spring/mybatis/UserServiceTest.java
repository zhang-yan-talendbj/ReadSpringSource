package spring.mybatis;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceTest {
    @Test
    public void testMapper() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        UserMapper userDao = (UserMapper) context.getBean("userMapper");
        System.out.println(userDao.getUser(1));



    }

    @Test
    public void testScanMapper() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis-scan.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.save();
    }
}

