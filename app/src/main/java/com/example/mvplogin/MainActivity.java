package com.example.mvplogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvplogin.bean.LoginAndRegisterBean;

import com.example.mvplogin.login.LoginContract;
import com.example.mvplogin.login.LoginPresent;
import com.example.mvplogin.network.ApiClient;
import com.example.mvplogin.register.RegisterContract;
import com.example.mvplogin.register.RegisterPresent;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, LoginContract.LoginView, RegisterContract.RegisterView {
   String TAG="MainActivity";
    private EditText mEtUsername;
    private EditText mEtPassword;
    private LoginPresent mLoginPresent;
    private RegisterPresent mRegisterPresent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bt_login).setOnClickListener(this);
        findViewById(R.id.register).setOnClickListener(this);

        mEtUsername = (EditText) findViewById(R.id.et_username);
        mEtPassword = (EditText) findViewById(R.id.et_password);
        //初始化present
        mLoginPresent = new LoginPresent(this);
        mRegisterPresent = new RegisterPresent(this);

    }

    @Override
    public void onClick(View v) {
        String userName = mEtUsername.getText().toString().trim();
        String password = mEtPassword.getText().toString().trim();
        switch (v.getId()){
            case R.id.bt_login:
            mLoginPresent.login(userName,password);
                break;
            case R.id.register:
                mRegisterPresent.register(userName,password,password);
                break;
            default:
                break;
        }
    }


    @Override
    public void LoginSuccess(LoginAndRegisterBean loginAndRegisterBean) {
        Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void LoginFail() {
        Toast.makeText(MainActivity.this,"登录失败",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void registerSuccess(LoginAndRegisterBean loginAndRegisterBean) {
        Toast.makeText(MainActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void registerFail() {
        Toast.makeText(MainActivity.this,"注册失败",Toast.LENGTH_SHORT).show();
    }
}
