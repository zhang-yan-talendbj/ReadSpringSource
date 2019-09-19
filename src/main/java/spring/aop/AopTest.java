package spring.aop;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {
    public static void main(String[] args) {
//        createProxyProgram();
//        createProxyWithAnnotation();
//        introductionAdvice();
        advisorAutoProxyCreator();
//        beanNameAutoProxyCreator();
    }

    private static void createProxyWithAnnotation() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:read-aop.xml");
        ITest service=applicationContext.getBean("testAOP",ITest.class);

        service.test();
    }
    private static void introductionAdvice() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:introduction-advice.xml");
        Intelligent service=applicationContext.getBean("myCar",Intelligent.class);
        service.selfDriving();
    }
    private static void advisorAutoProxyCreator() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:advisorAutoProxyCreator.xml");
        ITest service=applicationContext.getBean("testBean",ITest.class);
        service.test();
    }

    private static void beanNameAutoProxyCreator() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:beanNameAutoProxyCreator.xml");
        ITest service = applicationContext.getBean("testBean", ITest.class);
        service.test();
    }

    private static void createProxyProgram() {
        ITest service=new TestBean();//
        //使用代理工厂为目标对象创建代理，并织入我们自己的advice逻辑
        ProxyFactory proxyFactoryBean=new ProxyFactory();
        proxyFactoryBean.setTarget(service);//设置目标对象
        proxyFactoryBean.addAdvice(new TestAdvisor());
        ITest proxy=(ITest)proxyFactoryBean.getProxy();
        proxy.test();
    }


}
