package com.example.localdbaccess;


import com.google.gson.JsonObject;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by hitasoft on 12/3/18.
 */

public interface ApiClient {

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

    // @FormUrlEncoded
    @GET("read.php")
    Call<GetAllDataResponse>getAllData();


    //with FormUrlEncoded --> View in postman
//    @FormUrlEncoded
//    @POST("create.php")
//    @Headers({"Content-Type: application/json", "Authorization: 12345"})
//    Call<CreateResponse>postMethodData(
//            @Field("name") String name,
//            @Field("email") String email,
//            @Field("age") String age,
//            @Field("designation") String designation,
//            @Field("created") String created
//    );


    //without FormUrlEncoded using body Data--> view in postman
    @POST("create.php")
    Call<CreateResponse>postMethodData(
            @Body PostCredentials credentials
    );


}
