package spring.transaction;

import org.springframework.jdbc.core.JdbcTemplate;
import spring.jdbc.User;

import javax.sql.DataSource;

public class UserServiceImpl implements UserService {
    private JdbcTemplate jdbcTemplate;

    // 设置数据源
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void save(User user) throws Exception {
        jdbcTemplate.update("insert into user(name,age,sex)values(?,?,?)",
                new Object[] { user.getName(), user.getAge(), user.getSex() },
                new int[] { java.sql.Types.VARCHAR, java.sql.Types.INTEGER, java.sql.Types.VARCHAR });
        // 事务测试，加上这句代码则数据不会保存到数据库中
        throw new RuntimeException("aa");
    }
}