package com.igeak.common;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

/**
 * Created by igeak on 2017/11/27.
 */

public class PermissionUtil {
    public static final String[] PERMISSIONS_LOCATION = {
            android.Manifest.permission.ACCESS_COARSE_LOCATION,
            android.Manifest.permission.ACCESS_FINE_LOCATION,
    };

    public static final String[] PERMISSIONS_STORAGE = {
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
            android.Manifest.permission.READ_EXTERNAL_STORAGE,
    };

    public static final String[] PERMISSIONS_CALENDAR = {
            android.Manifest.permission.READ_CALENDAR
    };

    public static final String[] PERMISSIONS_PHONE = {
            android.Manifest.permission.READ_PHONE_STATE,
            android.Manifest.permission.PROCESS_OUTGOING_CALLS,
            android.Manifest.permission.CALL_PHONE
    };

    public static final String[] PERMISSIONS_CAMERA = {
            android.Manifest.permission.CAMERA
    };

    public static final String[] PERMISSIONS_SMS = {
            android.Manifest.permission.SEND_SMS,
            android.Manifest.permission.READ_SMS,
            android.Manifest.permission.RECEIVE_SMS
    };

    public static final String[] PERMISSIONS_CONTACTS = {
            android.Manifest.permission.READ_CONTACTS,
            android.Manifest.permission.GET_ACCOUNTS
    };

    private static final String[] PERMISSIONS_ALL = {
            android.Manifest.permission.ACCESS_COARSE_LOCATION,
            android.Manifest.permission.ACCESS_FINE_LOCATION,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
            android.Manifest.permission.READ_EXTERNAL_STORAGE,
            android.Manifest.permission.READ_CALENDAR,
            android.Manifest.permission.READ_PHONE_STATE,
            android.Manifest.permission.PROCESS_OUTGOING_CALLS,
            android.Manifest.permission.CALL_PHONE,
            android.Manifest.permission.CAMERA,
            android.Manifest.permission.SEND_SMS,
            android.Manifest.permission.READ_SMS,
            android.Manifest.permission.RECEIVE_SMS,
            android.Manifest.permission.READ_CONTACTS,
            android.Manifest.permission.GET_ACCOUNTS
    };


    public static boolean isPermission(Activity activity,String [] permissions) {
        boolean needPermissions = false;
        for (int i=0; i<permissions.length; i++) {
            if (ActivityCompat.checkSelfPermission(activity,permissions[i]) != PackageManager.PERMISSION_GRANTED){
                needPermissions = true;
            }
        }

       return needPermissions;
    }


    public static void verifyPermissions(Activity activity,String [] permissions) {

        if (!isPermission(activity,permissions)) {
            ActivityCompat.requestPermissions(activity,permissions,0);
        }
    }


    public static void verifyAllPermissions(Activity activity) {
        boolean needPermissions = false;
        for (int i = 0; i < PERMISSIONS_ALL.length; i++) {
            if (ActivityCompat.checkSelfPermission(activity, PERMISSIONS_ALL[i])
                    != PackageManager.PERMISSION_GRANTED) {
                needPermissions = true;
                break;
            }
        }

        if (needPermissions) {
            ActivityCompat.requestPermissions(activity, PERMISSIONS_ALL, 0);
        }

    }

    public static void handleVerifyPermissions(final Activity activity, int requestCode, String[] permissions, int[] grantResults) {
        boolean granted = true;
        if (requestCode == 0) {
            for (int i = 0; i < grantResults.length; i++) {
                if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                    granted = false;
                    break;
                }
            }
        }
        if (!granted) {
            // Toast.makeText(activity, R.string.no_permissions,Toast.LENGTH_SHORT).show();
            new AlertDialog.Builder(activity, R.style.MyDialogStyle).setTitle(R.string.tips_title).setMessage(R.string.no_permissions).setPositiveButton(R.string.tips_positive_sure, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    activity.startActivity(getAppDetailSettingIntent(activity));
                    activity.finish();
                }
            }).setCancelable(false).show();
        }
    }

    /**
     * @param activity
     */
    private static void startManagePermissionsActivity(Activity activity) {
        // start new activity to manage app permissions
        Intent intent = new Intent("android.intent.action.MANAGE_APP_PERMISSIONS");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("android.intent.extra.PACKAGE_NAME", activity.getApplicationInfo().packageName);
        intent.putExtra("hideInfoButton", true);
        try {
            activity.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Log.w("PermissionUtil", "No app can handle android.intent.action.MANAGE_APP_PERMISSIONS");
        }
    }

    /**
     * 获取应用详情页面intent
     *
     * @return
     */
    private static Intent getAppDetailSettingIntent(Context context) {
        Intent localIntent = new Intent();
        localIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (Build.VERSION.SDK_INT >= 9) {
            localIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            localIntent.setData(Uri.fromParts("package", context.getPackageName(), null));
        } else if (Build.VERSION.SDK_INT <= 8) {
            localIntent.setAction(Intent.ACTION_VIEW);
            localIntent.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails");
            localIntent.putExtra("com.android.settings.ApplicationPkgName", context.getPackageName());
        }
        return localIntent;
    }

    /**
     * Check that all given permissions have been granted by verifying that each entry in the
     * given array is of the value {@link PackageManager#PERMISSION_GRANTED}.
     *
     * @see Activity#onRequestPermissionsResult(int, String[], int[])
     */
    public static boolean verifyPermissions(int[] grantResults) {
        // At least one result must be checked.
        if (grantResults.length < 1) {
            return false;
        }

        // Verify that each required permission has been granted, otherwise return false.
        for (int result : grantResults) {
            if (result != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

}
