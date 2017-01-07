package org.xuxiaoxiao.myyora.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;


import org.xuxiaoxiao.myyora.R;
import org.xuxiaoxiao.myyora.views.MainNavDrawer;

public class ProfileActivity extends BaseAuthenticatedActivity {
    @Override
    protected void onYoraCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_profile);
        getSupportActionBar().setTitle("Profile");
        setNavDrawer(new MainNavDrawer(this));

        if (!isTablet) { // Video37_22min
            View textFields = findViewById(R.id.activity_profile_textFields);
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) textFields.getLayoutParams();
            params.setMargins(0, params.getMarginStart(), 0, 0);//left,top,right,bottom
            params.setMarginStart(0); //Without it the margin start won't be removed!
            params.removeRule(RelativeLayout.END_OF);
            params.addRule(RelativeLayout.BELOW, R.id.activity_profile_changeAvatar);// 放到头像下面
            textFields.setLayoutParams(params);
        }
    }
}
