package com.zl.ood.ocp.zhouliang;

/**
 * Created by zhouliang on 2017-06-28.
 */
public class Logger {
    private Formatter formatter;
    private Sender sender;

    public Logger(Formatter formatter,Sender sender){
        this.formatter = formatter;
        this.sender = sender;
    }
    public void log(String msg){
        sender.send(formatter.format(msg))	;
    }


    public static void main(String[] args) {
        Formatter formatter = new DateFormatter();
        Sender sender = new SmsSender();
        Logger logger =  new Logger(formatter,sender);
        logger.log("test");
//        DateFormatter format msg
//        SmsSender send msg
    }
}
