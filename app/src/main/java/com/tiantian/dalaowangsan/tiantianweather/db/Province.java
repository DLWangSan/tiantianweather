package com.tiantian.dalaowangsan.tiantianweather.db;

import org.litepal.crud.DataSupport;

/**
 * Created by HASEE on 2018/8/2.
 */

public class Province extends DataSupport {
    private int id;
    private String provinceName;
    private int provideCode;

    public int getId() {
        return id;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public int getProvideCode() {
        return provideCode;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public void setProvideCode(int provideCode) {
        this.provideCode = provideCode;
    }
}
