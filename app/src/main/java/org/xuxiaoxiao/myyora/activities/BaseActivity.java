package org.xuxiaoxiao.myyora.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.xuxiaoxiao.myyora.infrastructure.YoraApplication;

/**
 * Created by WuQiang on 2017/1/5.
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected YoraApplication application;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.e("BaseActivity","BaseActivity");
        super.onCreate(savedInstanceState);
        this.application = (YoraApplication) getApplication();
    }
}
