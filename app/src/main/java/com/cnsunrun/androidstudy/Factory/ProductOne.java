package com.cnsunrun.androidstudy.Factory;

/**
 * Created by ZhouBin on 2017/9/4.
 * Effect:
 */

public class ProductOne extends ProductFactory {

    @Override
    public String ProductName(String name) {
        return "华为P10";
    }


    @Override
    public void ProductColor(int color) {

        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        director.construct("张三", true, 23, 178, 138);
        Perons perons = builder.create();

    }


}
