package org.xuxiaoxiao.myyora.views;

import android.view.View;
import android.widget.Toast;

import org.xuxiaoxiao.myyora.R;
import org.xuxiaoxiao.myyora.activities.BaseActivity;
import org.xuxiaoxiao.myyora.activities.MainActivity;

/**
 * Created by WuQiang on 2017/1/6.
 */

public class MainNavDrawer extends NavDrawer {
    public MainNavDrawer(final BaseActivity activity) {
        super(activity);
        addItem(new ActivityNavDrawerItem(MainActivity.class, "Inbox", null, R.drawable.ic_action_unread, 0));
        addItem(new BasicNavDrawerItem("Logout", null, R.drawable.ic_action_backspace, 0) {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "You have logged out!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
