package com.zhengpu.zhengpuandroid.service;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.annotation.TargetApi;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.KeyEvent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Toast;

import com.orhanobut.logger.Logger;
import com.zhengpu.zhengpuandroid.MyApplication;
import com.zhengpu.zhengpuandroid.utils.PreferUtil;

import java.util.Iterator;
import java.util.List;

/**
 * sayid ....
 * Created by wengmf on 2017/11/24.
 */

public class MyAccessibilityService extends AccessibilityService {


    private  String nowPackageName;
    private ClickReceiver receiver;
    private static MyAccessibilityService service;

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {

        //接收事件,如触发了通知栏变化、界面变化等

        nowPackageName = event.getPackageName().toString();
        Logger.e(nowPackageName);

        if(nowPackageName.equals("com.tencent.qqmusic") ){
            if(event.getEventType()==AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED){
                AccessibilityNodeInfo rootNode = this.getRootInActiveWindow();
//                iterateNodesAndHandle(rootNode);
            }
        }
    }

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        Log.i("mService", "service授权成功");
        service = this;
        //连接服务后,一般是在授权成功后会接收到
        if (receiver == null) {
            receiver = new ClickReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("auto.click");
            registerReceiver(receiver, intentFilter);
        }
    }

    @Override
    protected boolean onKeyEvent(KeyEvent event) {
        //接收按键事件
        Logger.e("mService", "按钮点击变化");
        return super.onKeyEvent(event);
    }


    public class ClickReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {

            int i = intent.getIntExtra("flag", 0);
            Logger.e("mService","广播flag="+i);
            if (i == 1) {
                String resourceid = intent.getStringExtra("id");
                performClick(resourceid);
            }
        }
    }

    //执行点击
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    private void performClick(String resourceId) {

        Logger.e("mService","点击执行");

        AccessibilityNodeInfo nodeInfo = this.getRootInActiveWindow();
        AccessibilityNodeInfo targetNode = null;
        targetNode = findNodeInfosById(nodeInfo,"com.youmi.android.addemo:id/"+resourceId);
        if (targetNode.isClickable()) {
            targetNode.performAction(AccessibilityNodeInfo.ACTION_CLICK);
        }
    }

    //通过id查找
    public static AccessibilityNodeInfo findNodeInfosById(AccessibilityNodeInfo nodeInfo, String resId) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            List<AccessibilityNodeInfo> list = nodeInfo.findAccessibilityNodeInfosByViewId(resId);
            if(list != null && !list.isEmpty()) {
                return list.get(0);
            }
        }
        return null;
    }

    @Override
    public void onInterrupt() {
        //服务中断，如授权关闭或者将服务杀死
        Logger.e("mService", "授权中断");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }

    /**
     * 判断当前服务是否正在运行
     * */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public static boolean isRunning() {
        if(service == null) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) service.getSystemService(Context.ACCESSIBILITY_SERVICE);
        AccessibilityServiceInfo info = service.getServiceInfo();
        if(info == null) {
            return false;
        }

        List<AccessibilityServiceInfo> list = accessibilityManager.getEnabledAccessibilityServiceList(AccessibilityServiceInfo.FEEDBACK_GENERIC);
        Iterator<AccessibilityServiceInfo> iterator = list.iterator();

        boolean isConnect = false;
        while (iterator.hasNext()) {
            AccessibilityServiceInfo i = iterator.next();
            if(i.getId().equals(info.getId())) {
                isConnect = true;
                break;
            }
        }
        if(!isConnect) {
            return false;
        }
        return true;
    }
}
