package spring.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class String2DateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String arg0) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.parse(arg0);
        } catch (ParseException e) {
            return null;
        }
    }
}