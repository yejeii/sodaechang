package com.example.sodaechang;

import com.example.sodaechang.model.JsonLoanData;

import retrofit2.Call;
import retrofit2.http.GET;

// 2. API 인터페이스 생성
public interface JsonApi {

    @GET("list")
    Call<JsonLoanData> getListAll();

}
