package com.zl.ood.srp.zhouliang;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhouliang on 2017-06-26.
 */
public class ProductService {
    //获取所有的促销产品信息
    public List<Product> getAllProduct(){
        File file = new File("src\\main\\java\\com\\zl\\ood\\srp\\product_promotion.txt");
        BufferedReader br = null;
        List<Product> productList = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader(file));
            String temp = null;
            while((temp = br.readLine())!=null && !temp.trim().equals("")){
                String[] data = temp.split(" ");
                Product product = new Product();
                product.setProductID(data[0]);
                product.setProductDesc(data[1]);
                productList.add(product);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        if(productList.size()<=0){
            System.out.println("没有促销产品");
        }
        return productList;
    }

    public static void main(String[] args) {
        ProductService productService = new ProductService();
        List<Product> productList = productService.getAllProduct();
        System.out.println(productList.size());
        for (Product p :productList
             ) {
            System.out.println(p.toString());
        }
    }
}
