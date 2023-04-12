package test;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class DatasourceTest {
    @Test
    public void test() throws SQLException {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-datasource.xml");
        DruidDataSource datasource = ioc.getBean("datasource", DruidDataSource.class);
        System.out.println(datasource.getConnection());
    }
}
