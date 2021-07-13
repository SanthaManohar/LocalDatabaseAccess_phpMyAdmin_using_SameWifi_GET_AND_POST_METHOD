package com.example.localdbaccess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ApiInterface apiInterface;
    Button registerbutton,postmethodbutton;

    private  ApiClient mApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerbutton = (Button)findViewById(R.id.getmethod);
        postmethodbutton = (Button)findViewById(R.id.postmethod);
        registerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getMethodAllData();
            }
        });

        postmethodbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postMethodConcept();
            }
        });

    }



    private void getMethodAllData() {


        getApiClient().getAllData().enqueue(new Callback<GetAllDataResponse>() {
            @Override
            public void onResponse(Call<GetAllDataResponse> call, Response<GetAllDataResponse> response) {

                Log.d("responseone23:","responeone23:"+new Gson().toJson(response.body()));


                try {





                }catch (Exception e){

                }

            }

            @Override
            public void onFailure(Call<GetAllDataResponse> call, Throwable t) {
                Log.d("responseone23:","responeone23: Failure");
            }
        });

    }


    private void postMethodConcept() {

        PostCredentials loginCredentials = new PostCredentials();
        loginCredentials.name = "Anitha";
        loginCredentials.email = "Anitha@gmail.com";
        loginCredentials.age = "45";
        loginCredentials.designation = "Teacher";
        loginCredentials.created = "2022";

            getApiClient().postMethodData(loginCredentials).enqueue(new Callback<CreateResponse>() {
                @Override
                public void onResponse(Call<CreateResponse> call, Response<CreateResponse> response) {
                    Log.d("responseone234:","responeone234:"+new Gson().toJson(response.body()));
                    try {





                    }catch (Exception e){


                    }
                }

                @Override
                public void onFailure(Call<CreateResponse> call, Throwable t) {
                    Log.d("responseone234:","responeone234: Failure");
                }
            });






    }

    private ApiClient getApiClient(){
        if (mApi==null){
            mApi= RetrofitClient.getClient().create(ApiClient.class);
        }
        return mApi;
    }


}