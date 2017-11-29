package demo.igeak.com.samplelist.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.util.Log;

import com.igeak.common.LogUtil;

/**
 * Created by igeak on 2017/11/24.
 */

public class MyLocationListener implements LifecycleObserver{


    public Lifecycle lifecycle;

    public MyLocationListener(Lifecycle lifecycle){
        this.lifecycle = lifecycle;
        this.lifecycle.addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void create(){
        LogUtil.d("create: the currentState is:"+lifecycle.getCurrentState());
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void start(){

        Lifecycle.State currentState = this.lifecycle.getCurrentState();

        LogUtil.d("start: the currentState is:"+currentState);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void resume(){
        Lifecycle.State currentState = this.lifecycle.getCurrentState();
        LogUtil.d("resume: the currentState is:"+currentState);
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void stop(){
        LogUtil.d("stop: the current state:"+this.lifecycle.getCurrentState());
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void destory(){
        LogUtil.d("destory: the current state:"+this.lifecycle.getCurrentState());
    }

}
