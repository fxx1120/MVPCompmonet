package com.fxx.component.commonres.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;

import com.fxx.component.commonres.R;

/**
 * Created by fxx028 on 2018/11/14.
 */

public class ProgresDialog extends Dialog {
    public ProgresDialog(@NonNull Context context) {
        super(context, R.style.public_dialog_progress);
        setContentView(R.layout.public_dialog_porgress);
        setCanceledOnTouchOutside(false);
    }
}
