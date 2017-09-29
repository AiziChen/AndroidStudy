package com.cnsunrun.androidstudy.dao;

import android.content.Context;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


/**
 * Created by RayYeung on 2016/10/11.
 */

public class DBManager {
    private static final String DB_NAME = "shop.db";
    private static DBManager instance;
    public static String DB_PATH;


    public static DBManager getInstance() {
        if (instance == null) {
            synchronized (DBManager.class) {
                if (instance == null) {
                    instance = new DBManager();
                }
            }
        }
        return instance;
    }

    /**
     * 导入地区数据库
     *
     * @param context
     */
    public static void copyDB(Context context) {
        DB_PATH = "/data/data/" + context.getPackageName() + "/databases/region.db";
        File file = new File(DB_PATH);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            // 保证只加载一次
            if (file.exists() && file.length() > 0) {

            } else {
                InputStream is = context.getAssets().open("region.db");
                FileOutputStream fos = new FileOutputStream(file);
                byte[] buffer = new byte[1024];
                int len = 0;
                while ((len = is.read(buffer)) != -1) {
                    fos.write(buffer, 0, len);
                }
                is.close();
                fos.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
