package org.xuxiaoxiao.myyora.activities;

import android.os.Bundle;

import org.xuxiaoxiao.myyora.R;
import org.xuxiaoxiao.myyora.fragments.LoginFragment;

public class LoginNarrowActivity extends BaseActivity implements LoginFragment.Callbacks {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activty_login_narrow);
    }

    @Override
    public void onLoggedIn() {
        setResult(RESULT_OK);
        finish();
    }
}
