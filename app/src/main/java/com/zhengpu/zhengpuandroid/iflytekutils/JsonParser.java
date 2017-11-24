package com.zhengpu.zhengpuandroid.iflytekutils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
<<<<<<< HEAD
import com.zhengpu.zhengpuandroid.bean.iflytekbean.BaikeBean;
import com.zhengpu.zhengpuandroid.bean.iflytekbean.CalcBean;
import com.zhengpu.zhengpuandroid.bean.iflytekbean.DatetimeBean;
import com.zhengpu.zhengpuandroid.bean.iflytekbean.MusicXBean;
import com.zhengpu.zhengpuandroid.bean.iflytekbean.NewsBean;
import com.zhengpu.zhengpuandroid.bean.iflytekbean.OpenAppBean;
import com.zhengpu.zhengpuandroid.bean.iflytekbean.OpenQABean;
import com.zhengpu.zhengpuandroid.bean.iflytekbean.WeatherBean;
=======
import com.zhengpu.zhengpuandroid.bean.iflytekbean.MainBean;

>>>>>>> 4f3c256c28cac54e7b42712ab4673fd069090a5e

import java.lang.reflect.Type;

public class JsonParser {


<<<<<<< HEAD
    public static CalcBean parseResultCalc(String json) {

        CalcBean calcBean = new CalcBean();
        try {
            Type type = new TypeToken<CalcBean>() {
            }.getType();
            calcBean = new Gson().fromJson(json, type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return calcBean;
    }


    public static BaikeBean parseResultBaikeBean(String json) {
        BaikeBean baikeBean = new BaikeBean();
        try {
            Type type = new TypeToken<BaikeBean>() {
            }.getType();
            baikeBean = new Gson().fromJson(json, type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return baikeBean;
    }


    public static DatetimeBean parseResultDatetimeBean(String json) {
        DatetimeBean datetimeBean = new DatetimeBean();
        try {
            Type type = new TypeToken<DatetimeBean>() {
            }.getType();
            datetimeBean = new Gson().fromJson(json, type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datetimeBean;
    }


    public static WeatherBean parseResultWeatherBean(String json) {
        WeatherBean weatherBean = new WeatherBean();
        try {
            Type type = new TypeToken<WeatherBean>() {
            }.getType();
            weatherBean = new Gson().fromJson(json, type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return weatherBean;
    }



    public static OpenAppBean parseResultOpenAppBean(String json) {
        OpenAppBean openAppBean = new OpenAppBean();
        try {
            Type type = new TypeToken<OpenAppBean>() {
            }.getType();
            openAppBean = new Gson().fromJson(json, type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return openAppBean;
    }


    public static MusicXBean parseResultMusicXBean(String json) {
        MusicXBean musicXBean = new MusicXBean();
        try {
            Type type = new TypeToken<MusicXBean>() { }.getType();
            musicXBean = new Gson().fromJson(json, type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return musicXBean;
    }


    public static OpenQABean parseResultOpenQABean(String json) {
        OpenQABean openQABean = new OpenQABean();
        try {
            Type type = new TypeToken<OpenQABean>() { }.getType();
            openQABean = new Gson().fromJson(json, type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return openQABean;
    }

    public static NewsBean parseResultNewsBean(String json) {
        NewsBean newsBean = new NewsBean();
        try {
            Type type = new TypeToken<NewsBean>() { }.getType();
            newsBean = new Gson().fromJson(json, type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newsBean;
    }










=======
    private static MainBean mBean;

    /**
     * 返回当前说话的内容
     *
     * @param json
     * @return
     */
    public static MainBean parseIatResult(String json) {
        mBean = new MainBean();
        try {
            Type type = new TypeToken<MainBean>() {
            }.getType();

            mBean = new Gson().fromJson(json, type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mBean;
    }
>>>>>>> 4f3c256c28cac54e7b42712ab4673fd069090a5e
}
