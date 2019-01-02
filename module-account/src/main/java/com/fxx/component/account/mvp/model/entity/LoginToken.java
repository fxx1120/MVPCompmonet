package com.fxx.component.account.mvp.model.entity;

import java.io.Serializable;

/**
 * Created by fxx028 on 2018/11/29.
 */

public class LoginToken implements Serializable{
    /**
     * token_type : Bearer
     * expires_in : 315360000
     * access_token : eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6IjEwOTY4MDRkYzIyOTBkNTA2NGU3ODUwOGYwNDg0ZjJhMTA5MjZjZDVjNTYxNjlhYjgyMTllOWMzNzE2MzEyZWI5MzJlNjI2MGUyMzdmMDYwIn0.eyJhdWQiOiIyIiwianRpIjoiMTA5NjgwNGRjMjI5MGQ1MDY0ZTc4NTA4ZjA0ODRmMmExMDkyNmNkNWM1NjE2OWFiODIxOWU5YzM3MTYzMTJlYjkzMmU2MjYwZTIzN2YwNjAiLCJpYXQiOjE1MDQxNjYwMjAsIm5iZiI6MTUwNDE2NjAyMCwiZXhwIjoxODE5NTI2MDIwLCJzdWIiOiIxNSIsInNjb3BlcyI6W119.JZXxbLecnHgJcp64ryg4ebwQN0sj-Zqflx1Pdr4Gmj06NQKFmgoZz1BLrJxAqnAzOxej0ePCSSITV5M9GoNC_o_k6-OrmufkpjNxkJ4xgWncZdR1vSCUMiDOPMbomOuLHh4ghXJSssWpKpQHdZgBrFndd5xx_DvsmORlz1SmSNDgzwuBU-4c44CMuGrokj0nhmnrPofscvoql1p-NWngY37k8UbI7MSZ8x0H3FbFXD3_tr03VHFxrF53silVz_YqYRPVsZW-2azUfGJGy5IKzd-lHn2xtVoEjVO-cmz6m6S-XLOwMLIn3envK4ikj5RxwOan337O_ZDAcgMsA6tTRQtywbpNhqHX4k0xEMCHt8QLdlQdtpY1WCMlysQAfKO7VKf4EvjzVr9k_5qrCNROr0ZJs5xo_OOv4F7uxmLseD1U8XvHrCMdwLjFAJHtq5Zexuxcj1CC6WLaX5wz_eIuvVi9eX684wZY7TTshl6vmLczU4zLUW7c9rBaY_9358eRhlTzYJ0MIO8qglGlgSKu4cGEKr8q3sTqNdjrBwweZjvtN5ZMaubwlECOhm6THcrkFaIpQ7s4BP_uvZGWV26zZOtrlGTgmDRl8angc4zCxMqxSSQHBUnVN83v3yLXYMYRArXKCBVSRce66_x4uOvUqXVxMNl3nOoSd-daH7qDKKM
     */

    private String token_type;
    private int expires_in;
    private String access_token;

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

}
