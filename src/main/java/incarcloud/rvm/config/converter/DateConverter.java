package incarcloud.rvm.config.converter;

import com.incarcloud.rvm.util.DateUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by bzheng on 2019/11/13.
 */
@Configuration
public class DateConverter implements Converter<String, Date> {

    private static Logger logger = LoggerFactory.getLogger(DateConverter.class);

    @Override
    public Date convert(String source) {
        if (StringUtils.isBlank(source)) {
            return null;
        }

        // 解析时间
        try {
            return org.apache.commons.lang.time.DateUtils.parseDate(source, new String[]{DateUtils.DATE_FORMAT_SECOND, DateUtils.DATE_FORMAT_DAY});
        } catch (ParseException e) {
            logger.error("日期转化失败：" + e.getMessage(), e);
        }

        // 前端一般传毫秒数
        try {
            long t = Long.parseLong(source);
            return new Date(t);
        }catch (NumberFormatException e){
            logger.error("日期转化失败：" + e.getMessage(), e);
        }

        return null;
    }

}
