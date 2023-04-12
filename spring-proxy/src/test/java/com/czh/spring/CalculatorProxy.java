package com.czh.spring;

import com.czh.spring.proxy.Calculator;
import com.czh.spring.proxy.Impl.CalculatorImpl;
import com.czh.spring.proxy.Impl.CalculatorStaticProxy;
import com.czh.spring.proxy.Impl.ProxyFactory;
import org.junit.Test;

public class CalculatorProxy {
    /**
     * jdk动态代理，必须有接口，最终生成的代理类实现形同的接口
     * 最终代理类在com.sun.proxy的包下，类名是$proxy2
     * cglib动态代理
     */

    @Test
    public void test(){
//        CalculatorImpl calculator = new CalculatorImpl();
//        CalculatorStaticProxy calculatorStaticProxy = new CalculatorStaticProxy(calculator);
//        calculatorStaticProxy.add(1,2);
        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator)proxyFactory.getProxy();
        proxy.add(1,2);

    }
}
