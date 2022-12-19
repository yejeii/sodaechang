package com.example.sodaechang;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// 1. Retrofit을 이용한 REST API 통신을 위한 클래스 생성
public class MyRetrofit {

    private static String BASE_URL = "http://10.0.2.2:8090/sodaechang/loan/";
    private static Retrofit retrofit;
    private JsonApi jsonApi;

    // 1-1. Retrofit 객체 생성
    // addConverterFactory() : GsonConverter 생성. GSON은 JSON을 자바 클래스로 바꾸는 데 사용
    public static Retrofit getClient() {

        if(retrofit == null) {
            retrofit =
                    new Retrofit.Builder().baseUrl(BASE_URL)
                    .client(new OkHttpClient.Builder().build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;

    }



}
