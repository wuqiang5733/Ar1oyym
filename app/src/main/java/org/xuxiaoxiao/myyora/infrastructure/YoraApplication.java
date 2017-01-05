package org.xuxiaoxiao.myyora.infrastructure;

/**
 * Created by WuQiang on 2017/1/5.
 * <p>
 * 这个类，是可以写成 Singleton 的形式的 。
 */

public class YoraApplication {
    private Auth _auth;
    private static YoraApplication application = null;

    public static YoraApplication getYoraApplication() {
        if (application == null) {
            application = new YoraApplication();
        }
        return application;
    }

    private YoraApplication() {
        this._auth = new Auth();
    }


    public Auth getAuth() {
        return _auth;
    }
}
