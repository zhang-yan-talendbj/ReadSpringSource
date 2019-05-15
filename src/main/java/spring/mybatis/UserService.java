package spring.mybatis;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by thinkdeeply on 3-21.
 */
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public void save(){
        User user = userMapper.getUser(1);
        System.out.println(user);
    }
}
