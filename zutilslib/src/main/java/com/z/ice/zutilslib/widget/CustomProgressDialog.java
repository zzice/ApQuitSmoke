package com.z.ice.zutilslib.widget;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import com.z.ice.zutilslib.R;


/**
 * desc: CustomProgressDialog
 * date: 2017/2/20
 * author: Zice
 */
public class CustomProgressDialog extends ProgressDialog {

    public CustomProgressDialog(Context context) {
        super(context);
    }

    public CustomProgressDialog(Context context, int theme) {
        super(context, theme);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        //设置不可取消，点击其他区域不能取消
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        setContentView(R.layout.custom_progress_dialog_layout);
    }

    @Override
    public void show() {
        super.show();
    }
}
