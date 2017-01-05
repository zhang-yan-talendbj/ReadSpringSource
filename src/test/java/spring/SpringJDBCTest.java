package spring;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.jdbc.User;
import spring.jdbc.UserService;

public class SpringJDBCTest {
    public static void main(String[] args) {
        ApplicationContext act = new ClassPathXmlApplicationContext("test-bean.xml");
        UserService userService = (UserService) act.getBean("userService");
        User user = new User();
        user.setName("张三");
        user.setAge(20);
        user.setSex("男");
        // 保存一条记录
        userService.save(user);
        List<User> person1 = userService.getUsers();
        System.out.println("++++++++得到所有User");
        for (User person2 : person1) {
            System.out.println(
                    person2.getId() + " " + person2.getName() + " " + person2.getAge() + " " + person2.getSex());
        }
    }
}