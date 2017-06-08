package com.sunrun.toollibrary.bean;

/**
 * 发送消息模板
 * Created by RayYeung on 2016/8/12.
 */
public class Notice {

    public int type;
    public Object content;
    public Object content1;
    public Object content2;
    public Object content3;

    public Notice(int type, Object content) {
        this.type = type;
        this.content = content;
    }
    public Notice(int type, Object content, Object content1) {
        this.type = type;
        this.content = content;
        this.content1=content1;
    }
    public Notice(int type) {
        this.type = type;
    }

    public Notice(int type, Object content, Object content1, Object content2, Object content3) {
        this.type = type;
        this.content = content;
        this.content1 = content1;
        this.content2 = content2;
        this.content3 = content3;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "type=" + type +
                ", content=" + content +
                ", content1=" + content1 +
                '}';
    }
}
