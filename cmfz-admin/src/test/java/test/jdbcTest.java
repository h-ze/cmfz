package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by 11022 on 2018/7/4 0004.
 */
public class jdbcTest {
    @Test
    public void test1() throws SQLException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        DataSource dataSource =ac.getBean(DataSource.class);
        System.out.println(dataSource.getConnection());
    }
}
