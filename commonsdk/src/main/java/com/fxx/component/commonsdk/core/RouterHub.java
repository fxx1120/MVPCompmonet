package com.fxx.component.commonsdk.core;

/**
 * Created by fxx028 on 2018/11/14.
 */

public interface RouterHub {
    /**
     * 组名
     */
    String APP = "/app";//宿主 App 组件
    String MAIN = "/main";//首页模块
    String ACCOUNT = "/account";//登录注册模块
    String USER = "/user";//用户模块
    String FIND = "/find";//发现模块

    /**
     * 服务组件, 用于给每个组件暴露特有的服务
     */
    String SERVICE = "/service";


    /**
     * 宿主 App 分组
     */
    String APP_SPLASHACTIVITY = APP + "/SplashActivity";


    /**
     * main module 分组
     */
    String MAIN_MAINHOMEACTIVITY = MAIN + "/MainHomeActivity";


    /**
     * account module 分组
     */
    String ACCOUNT_LOGINACTIVITY = ACCOUNT + "/AccountLoginActivity";
    String ACCOUNT_ACCOUNTROLECONSOLEACTIVITY = ACCOUNT + "/AccountRoleConsoleActivity";
    String ACCOUNT_CHANGEPASSWORDACTIVITY = ACCOUNT + "/ChangePasswordActivity";

    /**
     * find  module分组
     */
    String FIND_NEWDETAILACTIVITY = FIND + "/FindNewDetailActivity";
    String FIND_NEWMANAGEACTIVITY = FIND + "/FindNewManageActivity";
    String FIND_MYCOLLECTIONNEWSACTIVITY = FIND + "/FindMyCollectionNewsActivity";
}
