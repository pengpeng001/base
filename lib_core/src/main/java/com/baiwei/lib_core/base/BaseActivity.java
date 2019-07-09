package com.baiwei.lib_core.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {

    private boolean isStatus;//沉浸式代码

    private boolean isFullScreen ;//全屏

    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindLayoutId());
        unbinder = ButterKnife.bind(this);

        initView();
        initData();
    }

    protected abstract int bindLayoutId();

    protected abstract void initView();

    protected abstract void initData();

    /**
     * 吐司
     * @param msg
     */
    public void showTost(String msg){
        Toast.makeText(this , msg , Toast.LENGTH_SHORT).show();
    }

    /**
     * 无参跳转
     * @param zsc
     */
    public void startActivity(Class<?> zsc){
        startActivity(new Intent(this , zsc));
    }
    /**
     * 有参跳转
     * @param zsc
     */
    public void startActivity(Bundle bundle , Class<?> zsc){
        Intent intent = new Intent(this, zsc);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    /**
     * 沉浸式代码
     * @param status
     */
    public void isStatus (boolean status){
        if (status){
            //沉浸式代码
        }
    }

    /**
     * 全屏
     * @param fullscreenn
     */
    public void isFullScreen(boolean fullscreenn){
        if (fullscreenn){

        }

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null){
            unbinder = null;
        }

    }
}
