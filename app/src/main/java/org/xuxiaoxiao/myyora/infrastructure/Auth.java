package org.xuxiaoxiao.myyora.infrastructure;

/**
 * Created by WuQiang on 2017/1/5.
 */

public class Auth {
//    private final Context _context;
    private User _usre;

    public Auth() {
//        this._context = context;
        this._usre = new User();
    }

    public User getUser(){
        return _usre;
    }
}
