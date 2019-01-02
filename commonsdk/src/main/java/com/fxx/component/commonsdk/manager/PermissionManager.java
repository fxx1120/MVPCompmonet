package com.fxx.component.commonsdk.manager;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;

import com.fxx.component.commonsdk.utils.PalmUtils;
import com.tbruyelle.rxpermissions2.RxPermissions;
/**
 * Created by fxx on 2017/10/30.
 */

public class PermissionManager {
    public static void initPermission(Activity activity) {
        RxPermissions rxPermissions = new RxPermissions(activity);
        rxPermissions.setLogging(true);
        rxPermissions
                .request(Manifest.permission.CAMERA,
                        Manifest.permission.READ_PHONE_STATE,
                        Manifest.permission.WRITE_SETTINGS,
                        Manifest.permission.CALL_PHONE,
                        Manifest.permission.RECORD_AUDIO,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION)
                .subscribe(granted -> {
                    if (granted) {
                        // All requested permissions are granted
                    } else {
                        // At least one permission is denied
                    }
                });
    }


    public static Intent pickFiles() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        if (PalmUtils.isJellyBeanMR2()) intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.putExtra(Intent.EXTRA_LOCAL_ONLY, true);
        intent.setType("*/*");
        return intent;
    }
}
