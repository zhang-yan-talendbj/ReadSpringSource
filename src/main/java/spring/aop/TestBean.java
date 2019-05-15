package spring.aop;

import java.util.Date;

public class TestBean implements ITest {
    private String testStr = "testStr";

    private Date createTime;

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
        System.out.println("test");
    }
}