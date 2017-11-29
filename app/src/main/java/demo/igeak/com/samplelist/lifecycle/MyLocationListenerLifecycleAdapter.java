package demo.igeak.com.samplelist.lifecycle;

import android.arch.lifecycle.GenericLifecycleObserver;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;

/**
 * Created by igeak on 2017/11/24.
 */

public class MyLocationListenerLifecycleAdapter implements GenericLifecycleObserver{

    final MyLocationListener mReceiver;

    public MyLocationListenerLifecycleAdapter(MyLocationListener recevier) {
        this.mReceiver = recevier;
    }

    @Override
    public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_CREATE) {
            //mReceiver.start(source,event);
        }else if(event == Lifecycle.Event.ON_RESUME) {
            //mReceiver.resume(source,event);
        }else if(event == Lifecycle.Event.ON_PAUSE) {
            //mReceiver.stop(source);
        }

    }
}
