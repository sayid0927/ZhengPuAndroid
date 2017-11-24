package com.zhengpu.zhengpuandroid.utils;

<<<<<<< HEAD
import android.content.ComponentName;
=======
>>>>>>> 4f3c256c28cac54e7b42712ab4673fd069090a5e
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
<<<<<<< HEAD
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;

import com.orhanobut.logger.Logger;
import com.zhengpu.zhengpuandroid.base.Constant;
import com.zhengpu.zhengpuandroid.service.MyAccessibilityService;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
=======

import com.zhengpu.zhengpuandroid.base.Constant;

import java.io.File;
import java.io.IOException;
>>>>>>> 4f3c256c28cac54e7b42712ab4673fd069090a5e

/**
 * Created by zs on 2016/7/7.
 */
public class DeviceUtils {
    /*
     * 获取应用名
     */
    public static String getVersionName(Context context) {
        String versionName = null;
        try {
            //获取包管理者
            PackageManager pm = context.getPackageManager();
            //获取packageInfo
            PackageInfo info = pm.getPackageInfo(context.getPackageName(), 0);
            //获取versionName
            versionName = info.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return versionName;
    }

    /*
     * 获取应用版本
     */
    public static int getVersionCode(Context context) {

        int versionCode = 0;
        try {
            //获取包管理者
            PackageManager pm = context.getPackageManager();
            //获取packageInfo
            PackageInfo info = pm.getPackageInfo(context.getPackageName(), 0);
            //获取versionCode
            versionCode = info.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return versionCode;
    }


    public static String getSDPath() {
        String sdDir = null;
        boolean sdCardExist = Environment.getExternalStorageState()
                .equals(android.os.Environment.MEDIA_MOUNTED); //判断sd卡是否存在
        if (sdCardExist) {
            sdDir = Environment.getExternalStorageDirectory().getAbsolutePath() + File
                    .separator + Constant.FILEPATH;
        } else {
            File file = new File("/mnt/sdcard/" + Constant.FILEPATH);//创建文件
            if (!file.exists()) {
                try {
                    file.createNewFile();
                    sdDir = file.getAbsolutePath();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return file.getAbsolutePath();
            } else {
                sdDir = file.getAbsolutePath();
            }
            return sdDir;
        }
        return sdDir;
    }
<<<<<<< HEAD

      //   判断是否开启AccessibilityService服务
    public static boolean isAccessibilitySettingsOn(Context mContext) {
        int accessibilityEnabled = 0;
        final String service = "com.zhengpu.zhengpuandroid" + "/" + MyAccessibilityService.class.getCanonicalName();
        try {
            accessibilityEnabled = Settings.Secure.getInt(
                    mContext.getApplicationContext().getContentResolver(),
                    android.provider.Settings.Secure.ACCESSIBILITY_ENABLED);
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }
        TextUtils.SimpleStringSplitter mStringColonSplitter = new TextUtils.SimpleStringSplitter(':');
        if (accessibilityEnabled == 1) {
            String settingValue = Settings.Secure.getString(
                    mContext.getApplicationContext().getContentResolver(),
                    Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES);
            if (settingValue != null) {
                mStringColonSplitter.setString(settingValue);
                while (mStringColonSplitter.hasNext()) {
                    String accessibilityService = mStringColonSplitter.next();
                    if (accessibilityService.equalsIgnoreCase(service)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }













=======
>>>>>>> 4f3c256c28cac54e7b42712ab4673fd069090a5e
}


