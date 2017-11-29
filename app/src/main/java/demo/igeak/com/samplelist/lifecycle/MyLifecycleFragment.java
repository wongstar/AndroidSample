package demo.igeak.com.samplelist.lifecycle;

import android.app.Fragment;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.LifecycleRegistryOwner;
import android.support.annotation.NonNull;

/**
 * Created by igeak on 2017/11/24.
 */

public class MyLifecycleFragment extends Fragment implements LifecycleRegistryOwner{
    LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);

    @NonNull
    @Override
    public LifecycleRegistry getLifecycle() {
        return lifecycleRegistry;
    }
}
