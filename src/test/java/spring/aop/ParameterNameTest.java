package spring.aop;

import org.junit.Test;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;

/**
 * Created by thinkdeeply on 3-17.
 */
public class ParameterNameTest {
    @Test
    public void testName() throws Exception {
        LocalVariableTableParameterNameDiscoverer nameDiscoverer = new LocalVariableTableParameterNameDiscoverer();
        String[] tests = nameDiscoverer.getParameterNames(ParameterClass.class.getMethod("test", String.class, String.class, int.class));

        for (String test : tests) {
            System.out.println(test);
        }
    }

    class ParameterClass {

        public void test(String name, String firstName, int age) {

        }
    }
}
