package demo.igeak.com.samplelist.lifecycle;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.MainThread;

import com.igeak.common.LogUtil;
import com.igeak.common.PermissionUtil;

/**
 * Created by igeak on 2017/11/27.
 */

public class LocationLiveData extends LiveData<Location>{

    private LocationManager locationManager;

    private static LocationLiveData mInstance;

    private Activity activity;

    @MainThread
    public static LocationLiveData get(Context context) {
        if (mInstance == null) {
            mInstance = new LocationLiveData(context.getApplicationContext());
        }
        return mInstance;
    }

    private LocationLiveData(Context context) {
        locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
    }



    private LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            setValue(location);
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    };

    @SuppressLint("MissingPermission")
    @Override
    protected void onActive() {
        super.onActive();
        try {
            //if(PermissionUtil.isPermission(activity,PermissionUtil.PERMISSIONS_LOCATION)) {
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
            //}
            LogUtil.d("onActive");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void onInactive() {
        LogUtil.d("onInactive");
        super.onInactive();
    }


}
