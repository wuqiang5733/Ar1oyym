package org.xuxiaoxiao.myyora.views;

import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.xuxiaoxiao.myyora.activities.BaseActivity;

import java.util.ArrayList;

/**
 * Created by WuQiang on 2017/1/6.
 */

public class NavDrawer {
    private ArrayList<NavDrawerItem> items;
    private NavDrawerItem selectedItem;

    protected BaseActivity activity;
    protected DrawerLayout drawerLayout;
    protected ViewGroup navDrawerView;

    public NavDrawer(BaseActivity activity) {

    }

    public void addItem(NavDrawerItem item) {

    }

    public boolean isOpen() {
        return false;
    }

    public void setOpen(boolean isOpen) {

    }

    public void setSelectedItem(NavDrawerItem item) {

    }

    public void create() {

    }

    public static abstract class NavDrawerItem {
        //   在 ViewGroup container 的某个地方Inflate自己，并且根据自己是还被选中，改变 Appearance
        protected NavDrawer navDrawer;

        public abstract void inflate(LayoutInflater inflater, ViewGroup container);

        public abstract void setSelected(boolean isSelected);
    }

    public static class BasicNavDrawerItem extends NavDrawerItem implements View.OnClickListener {

        //        显示 text 或者 badge (如果有的话) ,还有 icon

        private String text;
        private String badge;
        private int iconDrawabel;
        private int containerId; //DrawerLayout当中的位置，像是列表位置，比如：Logout 是在最后一个

        private ImageView icon;
        private TextView textView;
        private TextView badgeTextView;
        private View view;
        private int defaultTextColor;

        public BasicNavDrawerItem(String text, String badge, int iconDrawabel, int containerId) {

        }

        public void setText(String text) {
            // 下面这三个方法是用来 改变或者更新 元素的

        }

        public void setBadge(String badge) {

        }

        public void setIcon(int iconDrawabel) {

        }

        @Override
        public void onClick(View v) {

        }

        @Override
        public void inflate(LayoutInflater inflater, ViewGroup container) {

        }

        @Override
        public void setSelected(boolean isSelected) {

        }
    }

    public static class ActivityNavDrawerItem extends BasicNavDrawerItem {
        private final Class targetActivity;

        public ActivityNavDrawerItem(Class targetActivity, String text, String badge, int iconDrawabel, int containerId) {
            super(text, badge, iconDrawabel, containerId);
            this.targetActivity = targetActivity;
        }
    }
}
