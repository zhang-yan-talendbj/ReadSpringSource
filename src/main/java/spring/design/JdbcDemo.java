package spring.design;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo {

    public static void main(String[] args) throws SQLException {

//        多个结果集 allowMultiQueries=true
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?allowMultiQueries=true", "root", "password");

        Statement statement = connection.createStatement();

//        String s = "insert into user(name,age,sex) values('abc',1,1); ";
        boolean execute = statement.execute("select * from user;"+"select * from book;"
                );
        ResultSet resultSet = statement.getResultSet();

        while (resultSet.next()) {
            System.out.println(resultSet.getString(2));
        }

        boolean moreResults = statement.getMoreResults();
        if (moreResults) {
            resultSet= statement.getResultSet();
            while (resultSet.next()) {
                System.out.println(resultSet.getString(2));
            }
        }
    }
}
