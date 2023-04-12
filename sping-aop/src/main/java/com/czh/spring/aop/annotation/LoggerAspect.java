package com.czh.spring.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 *
 * aop其实是一个 try catch finally的执行顺序
 * 切面类
 * 使用方式
 * @Before
 * @After 在finally 之后执行的
 * @AfterReturning( 目标方法返回值之后执行
 * @AfterThrowing:异常通知，在目标方法的catch字句中执行
 *
 * 2。切入点表达式：设置在标识通知的注解value属性中
 * "execution(public int com.czh.spring.aop.annotation.CalculatorImpl.add(int,int))")
 * "execution(* com.czh.spring.aop.annotation.CalculatorImpl.*(..))"
 * 第一个* 表示任意的访问修饰符和返回值类型
 * 第二个*表示类中的任意的方法
 * 3。获取连接点的信息
 * joinpoint 表示切入点的方法名和参数
 * 再通知方法的参数位置，设置joinPoint的参数，就能获取连接点方法和信息
 * signature 方法的签名信息
 *
 *4。  Pointcut
 * 切入点表达式，固定一个切入点表达式
 *
 *    @Pointcut("execution(* com.czh.spring.aop.annotation.CalculatorImpl.*(..))")
 *     public void logPointCut(){
 *     @Before("logPointCut()") 写的是方法的方法名
 *     public void before(JoinPoint joinPoint){
 *  5 切面的优先级
 *  可以通过@Order注解的value属性值设置优先级，默认是最大值，1是最小值。值越小优先级越高
 */
@Component
@Aspect
public class LoggerAspect {
    @Pointcut("execution(* com.czh.spring.aop.annotation.CalculatorImpl.*(..))")
    public void logPointCut(){
        System.out.println("切入点表达式");
    }
    //@Before(value = "execution(public int com.czh.spring.aop.annotation.CalculatorImpl.add(int,int))")
    @Before("logPointCut()")
    public void before(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();
        System.out.println("前置通知 方法："+signature.getName()+"参数" + Arrays.toString(args));
    }
    @After("logPointCut()")
    public void after(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();
        System.out.println("后置通知 签名信息"+ signature.getName());
    }

    // 返回通知中，获取返回值，只需要通过AfterReturning的returning属性。且保证returning的值
    // 后参数名一致就行
    @AfterReturning(value = "logPointCut()",returning = "result")
    public void afterReturningAdviceMethod(JoinPoint joinPoint,Object result){
        Signature signature = joinPoint.getSignature();

        System.out.println("loggerAspect 返回通知 方法："+signature.getName()+"结果"+result);
    }
@AfterThrowing(value = "logPointCut()" ,throwing ="ex")
    public void afterThrowingAdviceMethod(JoinPoint joinPoint,Throwable ex){
    Signature signature = joinPoint.getSignature();
    System.out.println("loggeraspect,方法：" + signature.getName()+"  异常通知: "+ ex);
}

@Around("logPointCut()")
// 环绕通知类型动态代理的方法一定要和目标对象的返回值一致
public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint){
    Object result=null;
    try {
        System.out.println("环绕通知：前置通知");
        //  目标对象方法的执行
        result = joinPoint.proceed();
        System.out.println("环绕通知：返回通知");
    } catch (Throwable throwable) {
        throwable.printStackTrace();
        System.out.println("环绕通知：异常通知");
    }finally {
        System.out.println("环绕通知：后置通知");
    }
    return result;
}


}
