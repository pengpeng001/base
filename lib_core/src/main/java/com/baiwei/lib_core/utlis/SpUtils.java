package com.baiwei.lib_core.utlis;

import android.content.Context;
import android.content.SharedPreferences;

import com.baiwei.lib_core.app.BaseApp;

public class SpUtils {

    private final String SP_NAMA = "wd_sp";

    private static volatile SpUtils spUtils;

    private SpUtils(){
    }

    public static SpUtils getInstance(){
        if (spUtils == null){
            synchronized (SpUtils.class){
                if (spUtils == null){
                    spUtils = new SpUtils();
                }
            }
        }
        return spUtils;
    }

    /**
     * sp的实例
     * @return
     */

    private SharedPreferences getSp(){
        SharedPreferences sharedPreferences = BaseApp.getContext().getSharedPreferences(SP_NAMA,Context.MODE_PRIVATE);
        if (sharedPreferences!=null){
            return sharedPreferences;
        }
        return null;
    }
    /**
     * 存储数据
     * @param key
     * @param value
     */
    public void putSp(String key , String value){
        getSp().edit().putString(key  , value) .commit();
    }
    /**
     * 取出数据
     * @param key
     * @param value
     */
    public String getSp(String key){
        return getSp().getString(key,"");
    }


}
