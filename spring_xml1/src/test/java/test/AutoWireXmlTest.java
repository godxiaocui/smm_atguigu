package test;

import com.czh.ssm.spring.controller.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoWireXmlTest {
    /**
     * 手动装配
     */
    @Test
    public void test(){
        ApplicationContext ioc= new ClassPathXmlApplicationContext("spring-autowire.xml");
        UserController bean = ioc.getBean(UserController.class);
        bean.saveUser();
    }
    /**
     * 自动装配
     * 根据指定的策略，在ioc容器中匹配某一个bean，自动为bean中的类型属性接口或者属性付值
     */
}
