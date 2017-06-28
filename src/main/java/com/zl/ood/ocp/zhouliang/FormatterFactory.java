package com.zl.ood.ocp.zhouliang;

/**
 * Created by zhouliang on 2017-06-28.
 */
public class FormatterFactory {
    public static final int RAW_LOG = 1;
    public static final int RAW_LOG_WITH_DATE = 2;

    public static int EMAIL_LOG = 1;
    public static final int SMS_LOG = 2;
    public static final int PRINT_LOG = 3;

    public static Formatter createFormatter(int logType){
        if(logType == 1){
            return new DateFormatter();
        } else if(logType == 2){
            return new HtmlFormatter();
        }
        return null;
    }
}
