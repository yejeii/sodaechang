package com.example.sodaechang;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.sodaechang.databinding.ActivityLoanBinding;
import com.example.sodaechang.model.JsonLoanData;
import com.example.sodaechang.model.Loan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoanActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityLoanBinding binding;
    private RecyclerView recyclerView;
    private LoanAdapter loanAdapter;
    private Toolbar toolbar;
    private Intent intent;

    // Spring에서 디비정보 받아오기 위한 설정
    private String BASE_URL = "http://10.0.2.2:8090/sodaechang/loan/";
    private JsonApi jsonApi;

    private JsonLoanData jsonData;
    private ArrayList<Loan> loanArrayList;  // 대출 정보를 저장할 ArrayList

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoanBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Toolbar 생성
        toolbar = binding.loanToolbar;
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.app_name_ko);   // 툴바 제목 설정

        // RecyclerView init
        recyclerView = findViewById(R.id.loan_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        // 데이터 통신
        jsonApi = MyRetrofit.getClient().create(JsonApi.class);

        Call<JsonLoanData> call = jsonApi.getListAll();

        call.enqueue(new Callback<JsonLoanData>() {
            @Override
            public void onResponse(Call<JsonLoanData> call, Response<JsonLoanData> response) {
                jsonData = response.body();
                loanArrayList = jsonData.loanList;
                Log.d("mytag", "LoanActivity, loanArrayList에 데이터 저장 완료.");

                loanAdapter = new LoanAdapter(getApplicationContext(), loanArrayList);
                recyclerView.setAdapter(loanAdapter);
                loanAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<JsonLoanData> call, Throwable t) {
                Log.d("mytag", "LoanActivity, call Fail : "+t.getLocalizedMessage());
            }
        });

    }

    // Toolbar에 있는 버튼 클릭 시 발생하는 모든 이벤트 처리
    // MenuItem : 툴바에 있는 버튼을 눌렀을 때 발생하는 모든 이벤트 정보를 가지고 있는 객체
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:     // toobar의 back키 눌렀을 때 동작
                // todo

                // 액티비티 이동
                if (getIntent() != null) {
//                    getIntent().getExtras().remove("업종");
                    // Flow1Activity에서 넘어왔을 떄
                    if(getIntent().getStringExtra("액티비티").equals("flow1")) {
                        intent = new Intent(getApplicationContext(), Flow1Activity.class);
                        intent.putExtra("업종", getIntent().getExtras().getString("업종"));
                        intent.putExtra("행정구", getIntent().getExtras().getString("행정구"));
                        intent.putExtra("행정동", getIntent().getExtras().getString("행정동"));
//                    } else if(getIntent().getStringExtra("액티비티").equals("detail")) {
//                        intent = new Intent(getApplicationContext(), Flow1Activity.class);
                    }
                    Log.d("mytag", "getIntent() : "+getIntent().getExtras().getString("업종"));
                    Log.d("mytag", "getIntent() : "+getIntent().getExtras().getString("액티비티"));
                    Log.d("mytag", "getIntent() : "+getIntent().getExtras().getString("행정구"));
                    Log.d("mytag", "getIntent() : "+getIntent().getExtras().getString("행정동"));
                }
                setResult(Activity.RESULT_OK, intent);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }



}