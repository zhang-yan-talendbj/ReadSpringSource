package spring.transaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.jdbc.User;

/**
 * Created by thinkdeeply on 3-21.
 */
public class TransactionTest {

    public static void main(String[] args) throws Exception {
        ApplicationContext act = new ClassPathXmlApplicationContext("spring-transaction.xml");
        UserService userService = (UserService) act.getBean("userService");
        User user = new User();
        user.setName("张三ccc");
        user.setAge(20);
        user.setSex("男");
        // 保存一条记录
        userService.save(user);
    }
}
