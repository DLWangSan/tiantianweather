package com.tiantian.dalaowangsan.tiantianweather.db;

import org.litepal.crud.DataSupport;

/**
 * Created by HASEE on 2018/8/2.
 */

public class County extends DataSupport {
    private int id;
    private String countyName;
    private String weatherID;
    private int cityID;

    public int getId() {
        return id;
    }

    public int getCityID() {
        return cityID;
    }

    public String getCountyName() {
        return countyName;
    }

    public String getWeatherID() {
        return weatherID;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public void setWeatherID(String weatherID) {
        this.weatherID = weatherID;
    }
}
