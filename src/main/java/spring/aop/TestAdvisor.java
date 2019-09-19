package spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class TestAdvisor implements MethodInterceptor {

    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("Roundadvice方法执行前");
//        System.out.println(methodInvocation.getArguments()[0]);//可以获取目标方法的参数值
        Object result=methodInvocation.proceed();//调用目标对象的方法
        System.out.println("RoundAdvice方法执行完成了");
        return result;
    }
}
