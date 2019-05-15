package spring.transaction;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import spring.jdbc.User;

@Transactional(propagation = Propagation.REQUIRED)
public interface UserService {
    public void save(User user) throws Exception;
}