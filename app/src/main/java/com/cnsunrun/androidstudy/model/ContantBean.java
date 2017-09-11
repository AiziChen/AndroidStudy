package com.cnsunrun.androidstudy.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ZhouBin on 2017/9/11.
 * Effect:   联系人的数据
 */

public class ContantBean implements Parcelable {

    private String personName;
    private String firstChair;

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getFirstChair() {
        return firstChair;
    }

    public void setFirstChair(String firstChair) {
        this.firstChair = firstChair;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.personName);
        dest.writeString(this.firstChair);
    }

    public ContantBean() {
    }

    protected ContantBean(Parcel in) {
        this.personName = in.readString();
        this.firstChair = in.readString();
    }

    public static final Parcelable.Creator<ContantBean> CREATOR = new Parcelable.Creator<ContantBean>() {
        @Override
        public ContantBean createFromParcel(Parcel source) {
            return new ContantBean(source);
        }

        @Override
        public ContantBean[] newArray(int size) {
            return new ContantBean[size];
        }
    };
}
