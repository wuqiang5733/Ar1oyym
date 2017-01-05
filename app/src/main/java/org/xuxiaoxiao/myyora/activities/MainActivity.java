package org.xuxiaoxiao.myyora.activities;

import android.os.Bundle;
import android.util.Log;

import org.xuxiaoxiao.myyora.R;

public class MainActivity extends BaseAuthenticatedActivity {


    @Override
    protected void onYoraCreate(Bundle savedInstanceState) {
        Log.e("MainActivity","MainActivity");
        setContentView(R.layout.activity_main);
    }
}
