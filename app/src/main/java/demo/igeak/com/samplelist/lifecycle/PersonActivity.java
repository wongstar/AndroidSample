package demo.igeak.com.samplelist.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.LifecycleRegistryOwner;

/**
 * Created by igeak on 2017/11/24.
 */

public class PersonActivity extends LifecycleActivity implements LifecycleRegistryOwner{

    private LifecycleRegistry mRegistery = new LifecycleRegistry(this);

    public LifecycleRegistry getmRegistery() {
        return mRegistery;
    }

    @Override
    public LifecycleRegistry getLifecycle() {
        return mRegistery;
    }
}
