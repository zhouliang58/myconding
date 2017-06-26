package com.zl.ood.srp.zhouliang;

import java.util.List;

/**
 * Created by zhouliang on 2017-06-26.
 */
public class UserService {
    //获取所有的关注了某促销产品的用户
    public List<User> getUserByProductID(String productID){
        String sendMailQuery = "Select name from subscriptions "
                + "where product_id= '" + productID +"' "
                + "and send_mail=1 ";

        List<User> userList = DBUtil.query(sendMailQuery);
        if(userList==null || userList.size()<=0){
            System.out.println("没有用户关注该产品");
        }
        return userList;
    }

    public static void main(String[] args) {
        UserService userService = new UserService();
        List<User> userList = userService.getUserByProductID("P8756");
        for (User user:userList
             ) {
            System.out.println(user.toString());
        }
    }
}
