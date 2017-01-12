package org.xuxiaoxiao.myyora.fragments;

//import android.app.Fragment;  // 调用这个版本 onAttach 不执行

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.squareup.otto.Bus;

import org.xuxiaoxiao.myyora.infrastructure.ActionScheduler;
import org.xuxiaoxiao.myyora.infrastructure.YoraApplication;

public abstract class BaseFragment extends Fragment {
    protected YoraApplication application;
    protected Bus bus;
    public String tag ;

    protected ActionScheduler scheduler;

    @Override
    //  Fragment 的 onCreate 是 public 的
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tag = getClass().getSimpleName();
        Log.i(tag,"-- onCreate");
        application = (YoraApplication) getActivity().getApplication();
        scheduler = new ActionScheduler(application);

        bus = application.getBus();
        bus.register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        bus.unregister(this);
    }
    @Override
    public void onResume() {
        super.onResume();
        scheduler.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        scheduler.onPause();
    }
}
