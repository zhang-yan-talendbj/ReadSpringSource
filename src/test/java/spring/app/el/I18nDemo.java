package spring.app.el;

import java.text.MessageFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by thinkdeeply on 3-15.
 */
public class I18nDemo {

    @Test
    public void demo() {
        // ① 带有语言和国家/地区信息的本地化对象
        Locale locale1 = new Locale("zh", "CN");
        // ② 只有语言信息的本地化对象
        Locale locale2 = new Locale("zh");
        // ③ 等同于Locale("zh","CN")
        Locale locale3 = Locale.CHINA;
        // ④ 等同于Locale("zh")
        Locale locale4 = Locale.CHINESE;
        // ⑤ 获取本地系统默认的本地化对象
        Locale locale5 = Locale.getDefault();
        // JDK 的 java.util 包中提供了几个支持本地化的格式化操作工具类：NumberFormat、DateFormat、MessageFormat，而在 Spring
        // 中的国际化资源操作也无非是对于这些类的封装操作，我们仅仅介绍下MessageFormat的用法以帮助大家回顾：
        // ①信息格式化串
        String pattern1 = "{0}，你好！你于{1}在工商银行存入{2} 元。";
        String pattern2 = "At {1,time,short} On{1,date,long}，{0} paid {2,number, currency}.";
        // ②用于动态替换占位符的参数
        Object[] params = { "John", new GregorianCalendar().getTime(), 1.0E3 };
        // ③使用默认本地化对象格式化信息
        String msg1 = MessageFormat.format(pattern1, params);
        // ④使用指定的本地化对象格式化信息
        MessageFormat mf = new MessageFormat(pattern2, Locale.US);
        String msg2 = mf.format(params);
        System.out.println(msg1);
        System.out.println(msg2);
    }

    @Test
    public void testI18n() throws Exception {
        String[] configs = { "i18n.xml" };
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configs);
        // ①直接通过容器访问国际化信息
        Object[] params = { "John", new GregorianCalendar().getTime() };
        String str1 = ctx.getMessage("test", params, Locale.US);
        String str2 = ctx.getMessage("test", params, Locale.CHINA);
        System.out.println(str1);
        System.out.println(str2);

    }
}
