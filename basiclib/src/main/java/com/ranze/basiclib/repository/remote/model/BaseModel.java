package com.ranze.basiclib.repository.remote.model;

/**
 * Created by luyong01 on 2018/2/12.
 */

public class BaseModel {
    private int itemType;

    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }
}
