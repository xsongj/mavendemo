package com.example.test.aopdemo.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * description: 模拟切面1--拦截器
 * author ximu
 * email chris.lyt@alibaba-inc.com
 * date 2017/8/2
 */
public class SecurityInterceptor implements MethodInterceptor{

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.err.println("执行安全检验！");
        return methodInvocation.proceed();
    }
}