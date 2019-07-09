package com.baiwei.lib_core.base.mvp;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V , M> {

    public V view ;
    public M model ;

    public abstract M getModel();

    private WeakReference<V> weakReference;
    public  void attach(V view , M model){

        weakReference = new WeakReference<>(view);
        this.view = weakReference.get();//得到view
    }
    public void dettach(){

        if (weakReference!=null){
            weakReference.clear();//清空对象
            weakReference =null;
            this.view = null;
        }
    }

}
