package org.xuxiaoxiao.myyora.infrastructure;

import android.app.Application;

/**
 * Created by WuQiang on 2017/1/5.
 *
 *  这个类，是可以写成 Singleton 的形式的 。
 */

public class YoraApplication extends Application {
    private Auth _auth;

    @Override
    public void onCreate() {
        super.onCreate();
        this._auth = new Auth(this);
    }

    public Auth getAuth(){
        return _auth;
    }
}
