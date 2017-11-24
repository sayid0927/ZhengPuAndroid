package com.zhengpu.zhengpuandroid.iflytekutils;

/**
 * sayid ....
 * Created by wengmf on 2017/11/22.
 */

public interface IGetVoiceToWord {


    void getResult(String result);
    //声音太小10118错误
    void showLowVoice(String result);

    void appendResult(CharSequence sequence);

    void  SpeechOver();

<<<<<<< HEAD
    void  SpeechError(String error);

=======
>>>>>>> 4f3c256c28cac54e7b42712ab4673fd069090a5e
}
