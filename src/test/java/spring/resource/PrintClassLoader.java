package spring.resource;

import com.sun.javafx.util.Logging;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;

public class PrintClassLoader {

    @Test
    public void name() {
        System.out.println("Classloader of this class:"
                + PrintClassLoader.class.getClassLoader());

        System.out.println("Classloader of Logging:"
                + Logging.class.getClassLoader());

        System.out.println("Classloader of ArrayList:"
                + ArrayList.class.getClassLoader());
    }

    @Test
    public void aa() {

        File x = new File("/Users/yan.zhang/Downloads/new新概念英语2");
        File[] files = x.listFiles();
        for (File file : files) {
            String name = file.getName();
//            2-L1-L2_1.lrc
            
        }
        System.out.println(x);
    }
}
