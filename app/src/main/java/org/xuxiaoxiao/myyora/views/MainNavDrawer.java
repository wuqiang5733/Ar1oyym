package org.xuxiaoxiao.myyora.views;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.xuxiaoxiao.myyora.R;
import org.xuxiaoxiao.myyora.activities.BaseActivity;
import org.xuxiaoxiao.myyora.activities.ContactsActivity;
import org.xuxiaoxiao.myyora.activities.MainActivity;
import org.xuxiaoxiao.myyora.activities.ProfileActivity;
import org.xuxiaoxiao.myyora.activities.SentMessagesActivity;
import org.xuxiaoxiao.myyora.infrastructure.User;

/**
 * Created by WuQiang on 2017/1/6.
 */

public class MainNavDrawer extends NavDrawer {

    private final TextView _displayNameText;//NavDrawer 上的头像与头像旁边的文字
    private final ImageView _avatarImage;

    public MainNavDrawer(final BaseActivity activity) {
        super(activity);
        addItem(new ActivityNavDrawerItem(MainActivity.class, "Inbox", null, R.drawable.ic_action_unread, R.id.include_main_nav_drawer_topItems));
        addItem(new ActivityNavDrawerItem(SentMessagesActivity.class, "Sent Messages", null, R.drawable.ic_action_send_now, R.id.include_main_nav_drawer_topItems));
        addItem(new ActivityNavDrawerItem(ContactsActivity.class, "Contacts", null, R.drawable.ic_action_group, R.id.include_main_nav_drawer_topItems));
        addItem(new ActivityNavDrawerItem(ProfileActivity.class, "Profile", null, R.drawable.ic_action_person, R.id.include_main_nav_drawer_topItems));
        addItem(new BasicNavDrawerItem("Logout", null, R.drawable.ic_action_backspace, R.id.include_main_nav_drawer_bottomItems) {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "You have logged out!", Toast.LENGTH_SHORT).show();
            }
        });

        _displayNameText = (TextView) navDrawerView.findViewById(R.id.include_main_nav_drawer_displayName);
        _avatarImage = (ImageView) navDrawerView.findViewById(R.id.include_main_nav_drawer_avatar);

        User loggedInUser = activity.getYoraApplication().getAuth().getUser();
        _displayNameText.setText(loggedInUser.getDisplayName());
        // 从 User 类当中提取文字，然后在 NavDrawer 上面显示
        // 这个文字可以在 LoginFragment 当中的 onClick 当中设置

        // TODO: change avatar image to avatarUrl from loggedInUser
    }
}
