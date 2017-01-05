package org.xuxiaoxiao.myyora.infrastructure;

import android.content.Context;
import android.util.Log;

/**
 * Created by WuQiang on 2017/1/5.
 */

public class Auth {
    private final Context _context;
    private User _usre;

    public Auth(Context context) {
        Log.e("Auth","Auth");
        // 给 Auth 传入的是 Application 级的 Context
        // 而不是 Activity 级的
        this._context = context;
        this._usre = new User();
    }

    public User getUser(){
        return _usre;
    }
}
