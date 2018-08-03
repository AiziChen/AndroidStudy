package com.cnsunrun.androidstudy.widgtet;

import com.flyco.tablayout.listener.CustomTabEntity;

/**
 * Created by：Z_B on 2018/8/3 10:12
 * Effect：
 */
public class TabTimeEntity implements CustomTabEntity {

    public String time;
    public String status;

    public TabTimeEntity(String time, String status) {
        this.time = time;
        this.status = status;
    }

    @Override
    public String getTabTitle() {
        return status;
    }

    @Override
    public int getTabSelectedIcon() {
        return 0;
    }

    @Override
    public int getTabUnselectedIcon() {
        return 0;
    }
}
