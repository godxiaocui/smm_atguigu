package test;

import com.czh.ssm.spring.pojo.Clazz;
import com.czh.ssm.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IocByXml {
    @Test
    public void test(){
        // 获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Student studentOne = ioc.getBean("studentOne", Student.class);
        System.out.println(studentOne);
    }
    @Test
    public void test2(){
        // 获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Student studentTwo = ioc.getBean("studentThree", Student.class);
        System.out.println(studentTwo);
        Clazz clazz = ioc.getBean("clazz", Clazz.class);
        System.out.println(clazz);
    }

}
