package com.zl.ood.srp.zhouliang;

/**
 * Created by zhouliang on 2017-06-26.
 */
public class MailService {
    private String fromAddress ;
    private String smtpHost;
    private String altSmtpHost;
    public MailService(Configuration config){
        this.fromAddress = config.getProperty(ConfigurationKeys.EMAIL_ADMIN);
        this.smtpHost = config.getProperty(ConfigurationKeys.SMTP_SERVER);
        this.altSmtpHost = config.getProperty(ConfigurationKeys.ALT_SMTP_SERVER);
    }
    public void sendMail(Mail mail){
        try{
            sendEmail(mail,this.smtpHost);
        }catch(Exception e){
            try{
                sendEmail(mail,this.altSmtpHost);
            }catch (Exception ex){
                System.out.println("通过备用 SMTP服务器发送邮件失败: " + ex.getMessage());
            }

        }
    }

    private void sendEmail(Mail mail, String smtpHost){
        //假装发了一封邮件
        String buffer = "From:" + mail.getFromAddress() + "\n" +
                "To:" + mail.getToAddress() + "\n" +
                "Subject:" + mail.getSubject() + "\n" +
                "Content:" + mail.getMessage() + "\n";
        System.out.println(buffer);
    }
}
