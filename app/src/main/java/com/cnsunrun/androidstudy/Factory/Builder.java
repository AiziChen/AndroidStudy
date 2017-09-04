package com.cnsunrun.androidstudy.Factory;

/**
 * Created by ZhouBin on 2017/9/4.
 * Effect: 定义接口
 */

public interface Builder {
    Builder setName(String name);

    Builder setSex(boolean sex);

    Builder setAge(int age);

    Builder setHeight(float height);

    Builder setWeight(float weight);

    Perons create();


}
