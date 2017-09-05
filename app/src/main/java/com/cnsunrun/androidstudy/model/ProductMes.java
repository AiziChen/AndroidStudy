package com.cnsunrun.androidstudy.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ZhouBin on 2017/6/7.
 * Effect: 测试数据实体类
 */

public class ProductMes implements Parcelable {

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.imageUrl);
        dest.writeString(this.productMes);
    }

    protected ProductMes(Parcel in) {
        this.imageUrl = in.readString();
        this.productMes = in.readString();
    }

    public static final Parcelable.Creator<ProductMes> CREATOR = new Parcelable.Creator<ProductMes>() {
        @Override
        public ProductMes createFromParcel(Parcel source) {
            return new ProductMes(source);
        }

        @Override
        public ProductMes[] newArray(int size) {
            return new ProductMes[size];
        }
    };
}
