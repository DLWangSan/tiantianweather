package com.tiantian.dalaowangsan.tiantianweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by HASEE on 2018/8/3.
 */

public class Basic {
    @SerializedName("city")
    public String cityName;

    @SerializedName("id")
    public String weatherID;

    public Update update;

    public class Update{
        @SerializedName("loc")
        public String updateTime;
    }
}
