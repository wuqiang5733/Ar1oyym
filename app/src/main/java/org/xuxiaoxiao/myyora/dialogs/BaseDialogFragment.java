package org.xuxiaoxiao.myyora.dialogs;

import android.app.DialogFragment;
import android.os.Bundle;

import com.squareup.otto.Bus;

import org.xuxiaoxiao.myyora.infrastructure.YoraApplication;


public abstract class BaseDialogFragment extends DialogFragment {
    protected YoraApplication application;
    protected Bus bus;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        application = (YoraApplication) getActivity().getApplication();

        bus = application.getBus();

        bus.register(this);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        bus.unregister(this);
    }
}
