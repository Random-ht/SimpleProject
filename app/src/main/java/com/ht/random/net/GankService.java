package com.ht.random.net;

import com.ht.random.model.GankResults;
import com.ht.random.model.UserLoginReturn;

import io.reactivex.Flowable;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by wanglei on 2016/12/31.
 */

public interface GankService {

    @GET("data/{type}/{number}/{page}")
    Flowable<GankResults> getGankData(@Path("type") String type,
                                      @Path("number") int pageSize,
                                      @Path("page") int pageNum);

    @POST(Constant.userlogin)
    @FormUrlEncoded
    Flowable<UserLoginReturn> login(@Field("tel") String tel,
                                         @Field("loginCode") String loginCode,
                                         @Field("callseq") String callseq);
}
