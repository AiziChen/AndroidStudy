package com.cnsunrun.androidstudy.Factory;


/**
 * Created by ZhouBin on 2017/9/4.
 * Effect:
 */

public class ProductTwo implements ProductFactory {
    @Override
    public String ProductName(String name) {
        return "苹果手机";
    }

    @Override
    public String ProductMessage(String message) {
        return "128GB,土豪金";
    }

    @Override
    public void ProductColor(int color) {

    }

}
