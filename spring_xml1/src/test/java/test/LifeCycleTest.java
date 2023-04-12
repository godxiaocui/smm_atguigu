package test;

import com.czh.ssm.spring.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeCycleTest {
    @Test
    public void testLife(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring-lifecycle.xml");
        User bean = ac.getBean(User.class);
        System.out.println("生命周期：4、通过IOC容器获取bean并使用");
        ac.close();
    }
}
