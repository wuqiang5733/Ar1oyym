package org.xuxiaoxiao.myyora.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import org.xuxiaoxiao.myyora.R;

public class LoginActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final Intent intent = new Intent(this,MainActivity.class);

        findViewById(R.id.activity_login_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                application.getAuth().getUser().setLoggedIn(true);
                startActivity(intent);
                finish();
            }
        });
    }
}
