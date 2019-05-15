package spring.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by thinkdeeply on 3-23.
 */
@Service
public class ValuesBean {

    @Value("${name}")
    private String name;


    @Value("${IS_DEBUG_MODE}")
    private boolean debug;

    @Override
    public String toString() {
        return "ValuesBean{" +
                "name='" + name + '\'' +
                ", debug=" + debug +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
