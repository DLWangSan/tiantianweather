package com.tiantian.dalaowangsan.tiantianweather.util;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.tiantian.dalaowangsan.tiantianweather.db.City;
import com.tiantian.dalaowangsan.tiantianweather.db.County;
import com.tiantian.dalaowangsan.tiantianweather.db.Province;
import com.tiantian.dalaowangsan.tiantianweather.gson.Weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by HASEE on 2018/8/2.
 */

public class Utility {

    //解析省级数据
    public static boolean handleProvinceResponce(String responce){
        if(!TextUtils.isEmpty(responce)){
            try{
                JSONArray allProvinces = new JSONArray(responce);
                for(int i=0;i<allProvinces.length();i++){
                    JSONObject provinceObject =allProvinces.getJSONObject(i);
                    Province province = new Province();
                    province.setProvideCode(provinceObject.getInt("id"));
                    province.setProvinceName(provinceObject.getString("name"));
                    province.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean handleCityResponce(String responce,int provinceID){
        if(!TextUtils.isEmpty(responce)){
            try{
                JSONArray allProvinces = new JSONArray(responce);
                for(int i=0;i<allProvinces.length();i++){
                    JSONObject cityObject =allProvinces.getJSONObject(i);
                    City city = new City();
                    city.setCityCode(cityObject.getInt("id"));
                    city.setCityName(cityObject.getString("name"));
                    city.setProvinceID(provinceID);
                    city.save();
                }
                return  true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean handleCountyReaponce(String responce,int cityID){
        if(!TextUtils.isEmpty(responce)){
            try{
                JSONArray allProvinces = new JSONArray(responce);
                for(int i=0;i<allProvinces.length();i++){
                    JSONObject countyObject =allProvinces.getJSONObject(i);
                    County county = new County();
                    county.setCountyName(countyObject.getString("name"));
                    county.setWeatherID(countyObject.getString("weather_id"));
                    county.setCityID(cityID);
                    county.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }


    //将返回的JSON解析成Weather类

    public static Weather handleWeatherResponse(String response){
        try{
            JSONObject jsonObject=new JSONObject(response);
            JSONArray jsonArray=jsonObject.getJSONArray("HeWeather");
            String weatherContent=jsonArray.getJSONObject(0).toString();
            return new Gson().fromJson(weatherContent,Weather.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
