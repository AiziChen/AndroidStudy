package com.cnsunrun.androidstudy.model;

/**
 * Created by ZhouBin on 2017/6/9.
 * Effect: 星级评分的model
 */

public class RatingBarModel {

    private String projectName;
    private float StoreScore;

    public RatingBarModel(String projectName, float storeScore) {
        this.projectName = projectName;
        StoreScore = storeScore;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public float getStoreScore() {
        return StoreScore;
    }

    public void setStoreScore(float storeScore) {
        StoreScore = storeScore;
    }
}
