package com.zhengpu.zhengpuandroid.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.orhanobut.logger.Logger;
import com.zhengpu.zhengpuandroid.iflytekutils.IGetVoiceToWord;
import com.zhengpu.zhengpuandroid.iflytekutils.IGetWordToVoice;
import com.zhengpu.zhengpuandroid.iflytekutils.IflytekWakeUp;
import com.zhengpu.zhengpuandroid.iflytekutils.MyWakeuperListener;
import com.zhengpu.zhengpuandroid.iflytekutils.VoiceToWords;
import com.zhengpu.zhengpuandroid.iflytekutils.WakeUpListener;
import com.zhengpu.zhengpuandroid.iflytekutils.WordsToVoice;
<<<<<<< HEAD
=======
import com.zhengpu.zhengpuandroid.utils.ToastUtils;
>>>>>>> 4f3c256c28cac54e7b42712ab4673fd069090a5e

/**
 * ....
 * Created by wengmf on 2017/11/21.
 */

public class SpeechRecognizerService extends Service implements IGetVoiceToWord, WakeUpListener, IGetWordToVoice {

    private IflytekWakeUp iflytekWakeUp;
    private VoiceToWords voiceToWords;
    private WordsToVoice wordsToVoice;


    @Override
    public void onCreate() {
        super.onCreate();

        //初始化讯飞语音识别
        voiceToWords = new VoiceToWords(this,this);
        wordsToVoice = new WordsToVoice(this,this);
        iflytekWakeUp = new IflytekWakeUp(this, new MyWakeuperListener(this,this));

<<<<<<< HEAD
        wordsToVoice.startSynthesizer("正谱教育小机器人");
        iflytekWakeUp.startWakeuper();

//        new Thread(){
//            @Override
//            public void run() {
//                super.run();
//                while (true){
//                    iflytekWakeUp.startWakeuper();
//                    try {
//                        sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }.start();
=======
        wordsToVoice.startSynthesizer("正谱教育");

        new Thread(){
            @Override
            public void run() {
                super.run();
                while (true){
                    iflytekWakeUp.startWakeuper();
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
>>>>>>> 4f3c256c28cac54e7b42712ab4673fd069090a5e
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        return super.onStartCommand(intent, flags, startId);

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }



    /**
     *    语音转文本回调
     */
    @Override
    public void getResult(String result) {

        Logger.e(result);
    }

    /**
     *    说话声音太小回调
     */
    @Override
    public void showLowVoice(String result) {
<<<<<<< HEAD
//        wordsToVoice.startSynthesizer(result);
=======
        wordsToVoice.startSynthesizer(result);
>>>>>>> 4f3c256c28cac54e7b42712ab4673fd069090a5e
        voiceToWords.startRecognizer();
    }

    /**
     *     语音转文本回调
     */
    @Override
    public void appendResult(CharSequence sequence) {

    }

    /**
     *    结束说话回调
     */
    @Override
    public void SpeechOver() {

    }

<<<<<<< HEAD
    @Override
    public void SpeechError(String error) {
        wordsToVoice.startSynthesizer(error);
    }

=======
>>>>>>> 4f3c256c28cac54e7b42712ab4673fd069090a5e
    /**
     *   唤醒成功
     */
    @Override
    public void OnWakeUpSuccess() {
        wordsToVoice.startSynthesizer("是的主人");
<<<<<<< HEAD
        voiceToWords.startRecognizer();
=======
>>>>>>> 4f3c256c28cac54e7b42712ab4673fd069090a5e
    }

    /**
     *   唤醒失败
     */
    @Override
    public void OnWakeUpError() {

    }

    /**
     *    语音播放结束
     */
    @Override
    public void SpeechEnd() {
        voiceToWords.startRecognizer();
    }

    /**
     *    语音播放失败
     */
    @Override
    public void SpeechError() {

    }

}
