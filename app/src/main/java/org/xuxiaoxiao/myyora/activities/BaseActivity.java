package org.xuxiaoxiao.myyora.activities;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import org.xuxiaoxiao.myyora.R;
import org.xuxiaoxiao.myyora.infrastructure.YoraApplication;
import org.xuxiaoxiao.myyora.views.NavDrawer;

/**
 * Created by WuQiang on 2017/1/5.
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected YoraApplication application;
    protected Toolbar toolbar;
    protected NavDrawer navDrawer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        // @Nullable : Denotes that a parameter,
        // field or method return value can be null.
        Log.e("BaseActivity","BaseActivity");
        super.onCreate(savedInstanceState);
        this.application = (YoraApplication) getApplication();
    }
    @Override
    public void setContentView(@LayoutRes int layoutResID) {
//        @LayoutRes : Denotes that an integer parameter,
// field or method return value is expected to be a layout resource reference
// (e.g. android.R.layout.list_content).
        super.setContentView(layoutResID);
        Log.e("BaseActivity","setContentView");
        toolbar = (Toolbar) findViewById(R.id.include_toolbar);
        if (toolbar != null)
            setSupportActionBar(toolbar);
    }

    protected void setNavDrawer(NavDrawer navDrawer) {
        this.navDrawer = navDrawer;
        this.navDrawer.create();
    }
    public Toolbar getToolbar(){
// 为了能在 NavDrawer 当中访问
        return toolbar;
    }

    public YoraApplication getYoraApplication() {
        return application;
    }
}
// 我们想让Toobar在BaseActivity当中建立，可以在其它地方引用，我们只想在BaseActivity当中有一个
//findViewById，而不是到处都这么做，如何才做到？
// 那么：在那个Callback当中调用findViewById ？
//这是一个关于Android，关于Activity的需要思考的问题，
// 应该把代码放到那儿？应该放到Activity的那个LifeCycle当中？
//当然是不能放到 BaseActivity 的 onCreate 当中的，
// 因为 setContentView 方法还没有调用，setContentView 是由
// BaseActivity 的子类调用的，这些子类是先调用 BaseActivity 的 onCreate 方法的，然后才调用
// setContentView 的。要记住 MainActivity 是继承自 BaseAuthenticatedActivity 的，
// 它有一个 onCreate 方法 根据是否登陆来决定是否调用 onYoraCreate 方法，
// 所以我们不能把 findViewById（找ToolBar的代码） 放到 BaseActiviey 的 onCreate 当中，
//因为还没有 inflate ToolBar ，还没有 setContentView ，它是在 MainActivity 当中的
// onYoraCreate 当中发生的