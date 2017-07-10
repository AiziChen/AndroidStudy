package com.cnsunrun.androidstudy.model;

/**
 * Created by ZhouBin on 2017/6/7.
 * Effect: 测试数据实体类
 */

public class ProductMes {

    private String imageUrl;
    private String productMes;

    public ProductMes(String imageUrl, String productMes) {
        this.imageUrl = imageUrl;
        this.productMes = productMes;
    }


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getProductMes() {
        return productMes;
    }

    public void setProductMes(String productMes) {
        this.productMes = productMes;
    }
}
