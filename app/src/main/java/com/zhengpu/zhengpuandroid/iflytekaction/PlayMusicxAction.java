package com.zhengpu.zhengpuandroid.iflytekaction;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.provider.Settings;

import com.zhengpu.zhengpuandroid.iflytekutils.WordsToVoice;
import com.zhengpu.zhengpuandroid.service.PlayMusicService;
import com.zhengpu.zhengpuandroid.service.SpeechRecognizerService;
import com.zhengpu.zhengpuandroid.ui.activity.MainActivity;
import com.zhengpu.zhengpuandroid.utils.PreferUtil;

import java.util.List;

/**
 * sayid ....
 * Created by wengmf on 2017/11/24.
 */

public class PlayMusicxAction {


    private Context context;
    private String songName;
    private String appName;
    private String text;



    public PlayMusicxAction(String songName, String appName, String text, Context context) {
        this.text = text;
        this.songName = songName;
        this.appName = appName;
        this.context = context;
    }

    public void start() {

        if (appName != null && songName != null && text != null && context != null) {

            PreferUtil.getInstance().setPlayMusicName(songName);
            WordsToVoice.startSynthesizer(text);
            startAppName();

            Intent intent = new Intent("auto.click");
            intent.putExtra("flag",1);
            intent.putExtra("id","bt_accessibility");
            context.sendBroadcast(intent);
        }
    }

    private void startAppName() {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        PackageManager pm = context.getPackageManager();
        List<ResolveInfo> installAppList = pm.queryIntentActivities(intent, 0);
        for (ResolveInfo info : installAppList) {
            String name = info.loadLabel(pm).toString();
            if (name.equalsIgnoreCase(appName)) {
                String pkgname = info.activityInfo.packageName;
                if ("com.android.contacts".equalsIgnoreCase(pkgname)) {
                    Uri uri = Uri.parse("content://contacts/people");
                    Intent i = new Intent("android.intent.action.VIEW", uri);
                    context.startActivity(i);
                } else {
                    intent = pm.getLaunchIntentForPackage(pkgname);
                    intent.addCategory("android.intent.category.LAUNCHER");
                    context.startActivity(intent);
                }
                return;
            }
        }
    }
}
