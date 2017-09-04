package com.cnsunrun.androidstudy.Factory;

/**
 * Created by ZhouBin on 2017/9/4.
 * Effect:
 */

public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct(String name, boolean sex, int age, float height, float weight) {
        builder.setName(name);
        builder.setSex(sex);
        builder.setAge(age);
        builder.setHeight(height);
        builder.setWeight(weight);
    }
}
