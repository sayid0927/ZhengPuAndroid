package com.zhengpu.zhengpuandroid.iflytekutils;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.iflytek.cloud.ErrorCode;
import com.iflytek.cloud.InitListener;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechSynthesizer;
import com.iflytek.cloud.SynthesizerListener;
import com.iflytek.sunflower.FlowerCollector;
import com.orhanobut.logger.Logger;
import com.zhengpu.zhengpuandroid.utils.ToastUtils;

/**
 * sayid ....
 * Created by wengmf on 2017/11/22.
 *
 * 语音合成，文字转语音
 */

public class WordsToVoice {

    private static String TAG = "WordsToVoice类";
    // 语音合成对象
    public static SpeechSynthesizer mTts;
    //private Toast mToast;
    private Context context;
    private static IGetWordToVoice iGetWordToVoice;
    // 函数调用返回值,表示返回结果，失败或成功
    public static   int ret = 0;


    /**
     * 构造方法。
     */
    public WordsToVoice(Context context,IGetWordToVoice iGetWordToVoice) {
        this.context = context;
        this.iGetWordToVoice=iGetWordToVoice;
        // 初始化合成对象
        mTts = SpeechSynthesizer.createSynthesizer(context, mTtsInitListener);
        //mToast = Toast.makeText(context, "", Toast.LENGTH_SHORT);
        //设置参数
        setParams();
    }

    /**
     * 开始语音合成
     */
    public static   void startSynthesizer(String words ) {
        ret = mTts.startSpeaking(words, mTtsListener);
        if (ret != ErrorCode.SUCCESS) {
            // showTip("合成失败,错误码：" + ret);
            Logger.e("合成失败,错误码："+ret);
        } else {
            Logger.e("听写成功");
        }

    }

    /**
     * 参数设置
     */
    private void setParams() {
        //SpeechConstant.SAMPLE_RATE, "16000" 默认的识别采样率支持16000Hz和8000Hz
        // 清空参数
        mTts.setParameter(SpeechConstant.PARAMS, null);
        // 引擎类型
        mTts.setParameter(SpeechConstant.ENGINE_TYPE, SpeechConstant.TYPE_CLOUD);
        // 设置在线合成发音人
        mTts.setParameter(SpeechConstant.VOICE_NAME, "nannan");
        //设置合成语速
        mTts.setParameter(SpeechConstant.SPEED, "58");
        //设置合成音调
        mTts.setParameter(SpeechConstant.PITCH, "62");
        //设置合成音量
        mTts.setParameter(SpeechConstant.VOLUME, "75");
        //设置播放器音频流类型,参考系统AudioManager.STREAM_MUSIC
        mTts.setParameter(SpeechConstant.STREAM_TYPE, "3");
        // 设置播放合成音频打断音乐播放，默认为true
        mTts.setParameter(SpeechConstant.KEY_REQUEST_FOCUS, "true");
        // 设置音频保存路径，保存音频格式支持pcm、wav，设置路径为sd卡请注意WRITE_EXTERNAL_STORAGE权限
        // 注：AUDIO_FORMAT参数语记需要更新版本才能生效
        mTts.setParameter(SpeechConstant.AUDIO_FORMAT, "wav");
        mTts.setParameter(SpeechConstant.TTS_AUDIO_PATH, context.getFilesDir().getAbsolutePath() + "/tts.wav");
    }

    //判断是否正在播放

    public boolean isTtsSpeaking() {
        return mTts.isSpeaking();
    }

    /**
     * 初始化监听。
     */
    private InitListener mTtsInitListener = new InitListener() {
        @Override
        public void onInit(int code) {
            Log.d(TAG, "InitListener init() code = " + code);
            if (code != ErrorCode.SUCCESS) {
                // showTip("初始化失败,错误码：" + code);
            } else {
                // 初始化成功，之后可以调用startSpeaking方法
                // 注：有的开发者在onCreate方法中创建完合成对象之后马上就调用startSpeaking进行合成，
                // 正确的做法是将onCreate中的startSpeaking调用移至这里
            }
        }
    };

//    private void showTip(final String str) {
//        //mToast.setText(str);
//       // mToast.show();
//    }


    public void mTtsStop() {
        if (mTts != null && mTts.isSpeaking()) {
            mTts.stopSpeaking();
        }
    }

    public void mTtsDestroy() {
        // 退出时释放连接
        if (mTts != null) {
            if (mTts.isSpeaking()) {
                mTts.stopSpeaking();
            }
            mTts.destroy();

        }
    }


    /**
     * 合成回调监听。
     */
    public static SynthesizerListener mTtsListener = new SynthesizerListener() {

        @Override
        public void onSpeakBegin() {
            //showTip("开始播放");
            Logger.e("语音合成回调监听-----------"+"开始播放");
        }

        @Override
        public void onSpeakPaused() {
            // showTip("暂停播放");
            Logger.e("语音合成回调监听-----------"+"暂停播放");
        }

        @Override
        public void onSpeakResumed() {
            //showTip("继续播放");
            Logger.e("语音合成回调监听-----------"+"继续播放");
        }

        @Override
        public void onBufferProgress(int percent, int beginPos, int endPos,String info) {
            // 合成进度
        }

        @Override
        public void onSpeakProgress(int percent, int beginPos, int endPos) {
            // 播放进度
        }

        @Override
        public void onCompleted(SpeechError error) {
            if (error == null) {
                Logger.e("语音合成回调监听-----------"+"播放完成");
                iGetWordToVoice.SpeechEnd();

            } else if (error != null) {
                //showTip(error.getPlainDescription(true));
                Logger.e("语音合成回调监听-------错误----"+error.getPlainDescription(true));
                iGetWordToVoice.SpeechError();
            }
        }

        @Override
        public void onEvent(int eventType, int arg1, int arg2, Bundle obj) {
            // 以下代码用于获取与云端的会话id，当业务出错时将会话id提供给技术支持人员，可用于查询会话日志，定位出错原因
            // 若使用本地能力，会话id为null
            //	if (SpeechEvent.EVENT_SESSION_ID == eventType) {
            //		String sid = obj.getString(SpeechEvent.KEY_EVENT_SESSION_ID);
            //		Log.d(TAG, "session id =" + sid);
            //	}
        }
    };








}
