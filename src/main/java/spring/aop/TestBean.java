package spring.aop;

import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class TestBean implements ITest {
    private String testStr = "testStr";

    private Date createTime;

    public void setTestBean(TestBean testBean) {
        this.testBean = testBean;
    }

    @Autowired
    private ITest testBean;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTestStr() throws RuntimeException {
        return testStr;
    }

    public void setTestStr(String testStr) {
        this.testStr = testStr;
    }

    @Override
    public void test() {
        String testStr = getTestStr();
        System.out.println(testStr);

        ITest proxy=(ITest) AopContext.currentProxy();

        proxy.testB();
    }

    @Override
    public void testB() {
        System.out.println("testB");
    }

    @Override
    public void setTestBean(ITest bean) {
        testBean = bean;
    }
}