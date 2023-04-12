package com.czh.spring;

import com.czh.spring.controller.UserController;
import com.czh.spring.dao.UserDao;
import com.czh.spring.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationTest {
    /**
     * 注解，下面四个注解没有任何区别，对应的mvc的层次不同，开发人员用来标识层
     * @Component：将类标识为普通组件
     * @Controller：将类标识为控制层组件
     * @Service：将类标
     * @Repository：将类标识为持久层组件
     * 可通过标识组件的注解的value属性设置自定义的bean的id
     * 通过注解+扫描配置的bean的id。默认值是类的小驼峰，即类名首字母小写的结果
     *
     * @Autowired
     * 1. 注解能标识的位置
     * a, 标识在成员变量上。此时不需要设置成员变量set方法
     * B， 标识在set方法上
     * C， 当前成员变量付值的有参构造上
     * 2。 注解的原理
     * a 默认通过bytype的方式，从容器中匹配类型为某个bean的属性赋值
     * b 若有多个类型的bean，会自动转为byName去实现
     * 以上都不行的话
     *  使用@Qualifier注解：根据@Qualifier注解中指定的名称作为bean的id进行匹配
     *
     */


    @Test
    public void test(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("spring-ioc_annotation.xml");
        UserController bean = ioc.getBean("userController",UserController.class);
    bean.saveUser();

    }
}
