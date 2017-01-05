package org.xuxiaoxiao.myyora.infrastructure;

import android.content.Context;

/**
 * Created by WuQiang on 2017/1/5.
 */

public class Auth {
    private final Context _context;
    private User _usre;

    public Auth(Context context) {
        this._context = context;
        this._usre = new User();
    }

    public User getUser(){
        return _usre;
    }
}
