package com.cnsunrun.androidstudy.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 数据库操作的帮助类
 */
public class RestaurantHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "lunchlist.db";//数据库名称
    private static final int SCHEMA_VERSION = 2;//版本号,则是升级之后的,升级方法请看onUpgrade方法里面的判断

    /**
     * 构造函数,接收上下文作为参数,直接调用的父类的构造函数
     *
     * @param context
     */
    public RestaurantHelper(Context context) {
        super(context, DATABASE_NAME, null, SCHEMA_VERSION);
    }

    /**
     * 创建的是一个午餐订餐的列表,id,菜名,地址等等
     *
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE restaurants (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, address TEXT, type TEXT, notes TEXT, phone TEXT);");
    }

    /**
     * 升级判断,如果再升级就要再加两个判断,从1到3,从2到3
     *
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion == 1 && newVersion == 2) {
            db.execSQL("ALTER TABLE restaurants ADD phone TEXT;");
        }
    }

    /**
     * 返回表中的数据,where是调用时候传进来的搜索内容,orderby是设置中传进来的列表排序类型
     *
     * @param where
     * @param orderBy
     * @return
     */
    public Cursor getAll(String where, String orderBy) {

        StringBuilder buf = new StringBuilder("SELECT _id, name, address, type, notes, phone FROM restaurants");

        if (where != null) {
            buf.append(" WHERE ");
            buf.append(where);
        }

        if (orderBy != null) {
            buf.append(" ORDER BY ");
            buf.append(orderBy);
        }

        return (getReadableDatabase().rawQuery(buf.toString(), null));
    }

    /**
     * 根据点击事件获取id,查询数据库
     *
     * @param id
     * @return
     */
    public Cursor getById(String id) {
        String[] args = {id};

        return (getReadableDatabase()
                .rawQuery("SELECT _id, name, address, type, notes, phone FROM restaurants WHERE _ID=?",
                        args));
    }

    /**
     * 插入
     *
     * @param name
     * @param address
     * @param type
     * @param notes
     * @param phone
     */
    public void insert(String name, String address, String type, String notes, String phone) {
        ContentValues cv = new ContentValues();

        cv.put("name", name);
        cv.put("address", address);
        cv.put("type", type);
        cv.put("notes", notes);
        cv.put("phone", phone);

        getWritableDatabase().insert("restaurants", "name", cv);
    }

    /**
     * 增加
     *
     * @param id
     * @param name
     * @param address
     * @param type
     * @param notes
     * @param phone
     */
    public void update(String id, String name, String address,
                       String type, String notes, String phone) {
        ContentValues cv = new ContentValues();
        String[] args = {id};

        cv.put("name", name);
        cv.put("address", address);
        cv.put("type", type);
        cv.put("notes", notes);
        cv.put("phone", phone);

        getWritableDatabase().update("restaurants", cv, "_ID=?",
                args);
    }

    public String getName(Cursor c) {
        return (c.getString(1));
    }

    public String getAddress(Cursor c) {
        return (c.getString(2));
    }

    public String getType(Cursor c) {
        return (c.getString(3));
    }

    public String getNotes(Cursor c) {
        return (c.getString(4));
    }

    public String getPhone(Cursor c) {
        return (c.getString(5));
    }
}
