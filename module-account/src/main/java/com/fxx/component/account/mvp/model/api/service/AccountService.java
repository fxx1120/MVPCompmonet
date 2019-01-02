package com.fxx.component.account.mvp.model.api.service;

import com.fxx.component.account.mvp.model.entity.LoginToken;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by fxx028 on 2018/11/29.
 */

public interface AccountService {
    //登录
    @POST("v1/client/login")
    @FormUrlEncoded
    Observable<LoginToken> getLogin(@Field("username") String username, @Field("password") String password, @Field("source") String source);


}
