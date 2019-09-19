package spring.design;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.SqlProvider;
import org.springframework.jdbc.core.StatementCallback;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by yan.zhang on 5-24.
 */
public class Demo {

    public static void main(String[] args) {

    }


    public void execute(final String sql) throws DataAccessException {
        class ExecuteStatementCallback implements StatementCallback<Object>, SqlProvider {
            @Override
            public Object doInStatement(Statement stmt) throws SQLException {
                stmt.execute(sql);
                return null;
            }

            @Override
            public String getSql() {
                return sql;
            }
        }
        execute(new ExecuteStatementCallback());
    }

    private void execute(StatementCallback executeStatementCallback) {

    }


}
