package com.zhengpu.zhengpuandroid.bean.iflytekbean;

/**
 * Created by Howe on 2016/10/23.
 */

public class SemanticBean {
    /**
     * name : 张三
     */

    private SlotsBean slots;

    private String intent;



    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }

    public SlotsBean getSlots() {
        return slots;
    }

    public void setSlots(SlotsBean slots) {
        this.slots = slots;
    }


}