package com.zl.ood.srp.zhouliang;

import java.util.List;

/**
 * Created by zhouliang on 2017-06-26.
 */
public class PromotionMail {
    private ProductService productService = new ProductService();
    private UserService userService = new UserService();
    private static Configuration configuration = new Configuration();
    private MailService mailService = new MailService(configuration);

    public void sendPromotionMail(){
        //获取所有促销产品信息
        List<Product> productList = productService.getAllProduct();

        for (Product product:productList) {
            //获取关注了某个促销产品的所有用户
            List<User> userList = userService.getUserByProductID(product.getProductID());
            for (User user:userList) {
                //生成对应的邮件信息
                Mail mail = createMail(user,product);
                //发送邮件
                mailService.sendMail(mail);
            }
        }
    }

    private Mail createMail(User user,Product product){
        String subject = "您关注的产品降价了";
        String message = "尊敬的 "+user.getName()+", 您关注的产品 " + product.getProductDesc() + " 降价了，欢迎购买!" ;

        Mail mail = new Mail();
        mail.setFromAddress(ConfigurationKeys.EMAIL_ADMIN);
        mail.setMessage(message);
        mail.setSubject(subject);
        mail.setToAddress(user.getEmail());
        return mail;
    }

    public static void main(String[] args) {
        PromotionMail promotionMail = new PromotionMail();
        promotionMail.sendPromotionMail();
    }
}
