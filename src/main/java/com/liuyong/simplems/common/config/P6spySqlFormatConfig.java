package com.liuyong.simplems.common.config;

/**
 * p6spy自定义类
 *
 * @author liuyong
 * @date 2020/8/11 17:57
 */
import com.liuyong.simplems.common.core.utils.DateUtil;
import com.p6spy.engine.spy.appender.MessageFormattingStrategy;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;

/**
 * now + "|" + elapsed + "|" + category + "|connection " + connectionId + "|url " + url + "|" + P6Util.singleLine(prepared) + "|" + P6Util.singleLine(sql);
 * #01-07-20 14:37:38:871 | took 1ms | statement | connection 0| url jdbc:p6spy:mysql://localhost:3306/data?serverTimezone=CTT&useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true&useSSL=true
 */
public class P6spySqlFormatConfig implements MessageFormattingStrategy {

    /**
     * 过滤掉定时任务的 SQL
     */
    @Override
    public String formatMessage(int connectionId, String now, long elapsed, String category, String prepared, String sql, String url) {
        return StringUtils.isNotBlank(sql) ? DateUtil.formatFullTime(LocalDateTime.now(), DateUtil.FULL_TIME_SPLIT_PATTERN)
                + " | 耗时 " + elapsed + " ms | SQL 语句：" + StringUtils.LF + sql.replaceAll("[\\s]+", StringUtils.SPACE) + ";" : "";
    }
}
