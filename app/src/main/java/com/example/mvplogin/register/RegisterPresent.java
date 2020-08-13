package com.example.mvplogin.register;

import com.example.mvplogin.bean.LoginAndRegisterBean;

/**
 * present 持有View和model
 */
public class RegisterPresent implements RegisterContract.RegisterPresent {

    private final RegisterModel mRegisterModel;
    RegisterContract.RegisterView mRegisterView;
    RegisterIpl mRegisterIpl;//回调接口,model中请求数据,回调此接口,将数据给present

    public  RegisterPresent(RegisterContract.RegisterView registerView){
        mRegisterModel = new RegisterModel();
        mRegisterView = registerView;
        //回调接口
        mRegisterIpl = new RegisterIpl() {
            @Override
            public void registerSuccess(LoginAndRegisterBean loginAndRegisterBean) {
                //调用view的registerSuccess
                mRegisterView.registerSuccess(loginAndRegisterBean);
            }

            @Override
            public void registerFail() {
                //调用view的fail
                mRegisterView.registerFail();
            }
        };
    }

    /**
     * @param username   账号
     * @param password   密码
     * @param rePassword 确认密码
     */
    @Override
    public void register(String username, String password, String rePassword) {
        //mRegisterIpl回调接口
        mRegisterModel.register(username,password,rePassword,mRegisterIpl);
    }

}
