package com.example.localdbaccess;

import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("create.php")
    Call<CreateResponse> getCreateData(@FieldMap Map<String, String> fieldMap);

    @FormUrlEncoded
    @POST("create.php")
    Call<CreateResponse> getCreateDataOne(
            @Field("name") String name,
            @Field("email") String email,
            @Field("age") String age,
            @Field("designation") String designation,
            @Field("created") String created
    );



}