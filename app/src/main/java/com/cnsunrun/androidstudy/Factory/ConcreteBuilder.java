package com.cnsunrun.androidstudy.Factory;

/**
 * Created by ZhouBin on 2017/9/4.
 * Effect: 建造者类
 */

public class ConcreteBuilder implements Builder {

    private String name;
    private boolean sex;
    private int age;
    private float height;
    private float weight;

    public Builder setName(String name) {
        this.name = name;
        return this;
    }

    public Builder setSex(boolean sex) {
        this.sex = sex;
        return this;
    }

    public Builder setAge(int age) {
        this.age = age;
        return this;
    }

    public Builder setHeight(float height) {
        this.height = height;
        return this;
    }

    public Builder setWeight(float weight) {
        this.weight = weight;
        return this;
    }

    public Perons create() {
        return new Perons(name, sex, age, height, weight);
    }
}
