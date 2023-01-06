package top.it6666.config;

import com.p6spy.engine.spy.appender.MessageFormattingStrategy;
import org.apache.commons.lang3.StringUtils;
import top.it6666.DateUtil;

import java.time.LocalDateTime;

/**
 * @author BNTang
 * @version 1.0
 * @description
 * @since 2023-11-06
 **/
public class P6spySqlFormatConfigure implements MessageFormattingStrategy {
    @Override
    public String formatMessage(int connectionId, String now, long elapsed, String category, String prepared, String sql, String url) {
        String currentTime = DateUtil.formatFullTime(LocalDateTime.now(), DateUtil.FULL_TIME_SPLIT_PATTERN);
        String lineSeparator = System.lineSeparator();
        String space = " ";
        if (StringUtils.isNotBlank(sql)) {
            return currentTime + " | 耗时 " + elapsed + " ms | SQL 语句：" + lineSeparator + sql.replaceAll("[\\s]+", space) + ";";
        }
        return "";
    }
}