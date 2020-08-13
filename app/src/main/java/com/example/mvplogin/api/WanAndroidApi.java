package com.example.mvplogin.api;

import com.example.mvplogin.bean.LoginAndRegisterBean;


import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;




public interface WanAndroidApi {

   /* @POST("/user/login")
    public Observable<LoginAndRegisterBean> login(@Body LoginBean loginBean);
    */

   /*和后台沟通的时候记得问一下是不是表单提交
   * OkHttp====Message:username=sjl&password=123456 这个是表单提交
   *OkHttp====Message:{"username":"sjl","password":"123456"}   这个是body提交
   * */
    @FormUrlEncoded
    @POST("/user/login")
    public Observable<LoginAndRegisterBean> login(@Field("username") String username, @Field("password") String password);

    @FormUrlEncoded
    @POST("/user/register")
    public Observable<LoginAndRegisterBean> register(@Field("username") String username,@Field("password") String password,@Field("repassword") String repassword);

/*    {
        "data": {
        "admin": false,
                "chapterTops": [],
        "coinCount": 0,
                "collectIds": [],
        "email": "",
                "icon": "",
                "id": 73372,
                "nickname": "sjl",
                "password": "",
                "publicName": "sjl",
                "token": "",
                "type": 0,
                "username": "sjl"
    },
        "errorCode": 0,
            "errorMsg": ""
    }*/

}
