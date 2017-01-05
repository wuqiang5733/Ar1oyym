package org.xuxiaoxiao.myyora.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import org.xuxiaoxiao.myyora.R;

/*
E/YoraApplication: YoraApplication
E/Auth: Auth
E/BaseAuthenActivity: BaseAuthenticatedActivity
E/BaseActivity: BaseActivity

E/LoginActivity: LoginActivity
E/BaseActivity: BaseActivity

D/LoginActivity: 你登陆了 。。。
E/BaseAuthenActivity: BaseAuthenticatedActivity
E/BaseActivity: BaseActivity
E/MainActivity: MainActivity
 */


public class LoginActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.e("LoginActivity","LoginActivity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final Intent intent = new Intent(this,MainActivity.class);

        findViewById(R.id.activity_login_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("LoginActivity","你登陆了 。。。 ");
                application.getAuth().getUser().setLoggedIn(true);
                startActivity(intent);
                finish();
            }
        });
    }
}
