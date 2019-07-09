package com.baiwei.lib_core.utlis;

import android.util.Log;

import com.baiwei.lib_core.common.Constants;

public class LogUtils {

    private static String TAG = LogUtils.class.getSimpleName();


    public static void d(String msg){
        if (!Constants.IS_RELEASE){//如果不是正式版环境
            Log.d(TAG,msg);
        }
    }
    public static void e(String msg){
        if (!Constants.IS_RELEASE){//如果不是正式版环境
            Log.e(TAG,msg);
        }
    }
}
