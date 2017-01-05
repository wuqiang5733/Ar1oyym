package org.xuxiaoxiao.myyora.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.xuxiaoxiao.myyora.R;

public class LoginFragment extends BaseFragment implements View.OnClickListener {
    private View _loginButton;
    private Callbacks _callbacks;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // 第三个参数：false 是 attachToRoot ，好像已经自动 attach 了，如果你再 attach 一次就会报错
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        _loginButton = view.findViewById(R.id.fragment_login_loginButton);
        _loginButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        if (view == _loginButton) {
            application.getAuth().getUser().setLoggedIn(true);
            _callbacks.onLoggedIn();
        }
    }

    @Override
    //import android.app.Fragment;  // 调用这个版本 onAttach 不执行
    public void onAttach(Context context) {
        Log.e("LoginFragment","onAttach");
        super.onAttach(context);
        _callbacks = (Callbacks) getActivity();
        Log.e("Test","_callbacks.toString()");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        _callbacks = null;
    }

    // Observer Pattern
    public interface Callbacks {
        void onLoggedIn();
    }
}
