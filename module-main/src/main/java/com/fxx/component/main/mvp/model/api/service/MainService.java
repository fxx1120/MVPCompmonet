package com.fxx.component.main.mvp.model.api.service;

import com.fxx.component.main.mvp.model.entity.FindNewsBean;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface MainService {

    //根据分类获取文章列表
    @GET("v1/law/category/articles")
    Observable<FindNewsBean> getInformationNew(@QueryMap HashMap<String,Object> map);
}
