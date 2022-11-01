package com.example.sodaechang;

import android.content.Intent;
import android.os.Bundle;

import com.example.sodaechang.databinding.ActivityLoanBinding;
import com.example.sodaechang.model.BrandInfo;
import com.example.sodaechang.model.Loan;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class LoanActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityLoanBinding binding;
    private RecyclerView recyclerView;
    private LoanAdapter loanAdapter;
    private Toolbar toolbar;
    private Intent intent;

    private ArrayList<Loan> loanArrayList;    // 대출 정보를 저장할 ArrayList
    private String[] loanName;
    private String[] loanType;
    private String[] loanTargetCustomers;
    private String[] loanCreditLine;
    private String[] loanPeriod;
    private String[] loanInterestRate;
    private String[] loanDesc;
    private String[] lowestInterestRate;


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

        loanArrayList = new ArrayList<Loan>();

        loanName = new String[] {
                getString(R.string.l_1),
                getString(R.string.l_2),
                getString(R.string.l_3),
                getString(R.string.l_4),
                getString(R.string.l_5),
                getString(R.string.l_6),
                getString(R.string.l_7),
                getString(R.string.l_8),
                getString(R.string.l_9),
                getString(R.string.l_10),
                getString(R.string.l_11),
                getString(R.string.l_12),
        };

        loanType = new String[] {
                "소액담보대출1",
                "소액담보대출2",
                "소액담보대출3",
                "소액담보대출4",
                "소액담보대출5",
                "소액담보대출6",
                "소액담보대출7",
                "소액담보대출8",
                "소액담보대출9",
                "소액담보대출10",
                "소액담보대출11",
                "소액담보대출12",
        };

        loanTargetCustomers = new String[] {
                "기업1",
                "기업2",
                "기업3",
                "기업4",
                "자영업자5",
                "자영업자6",
                "기업7",
                "자영업자8",
                "기업9",
                "자영업자10",
                "자영업자11",
                "자영업자12",
        };

        loanDesc = new String[] {
                getString(R.string.rv_1),
                getString(R.string.rv_2),
                getString(R.string.rv_3),
                getString(R.string.rv_4),
                getString(R.string.rv_5),
                getString(R.string.rv_6),
                getString(R.string.rv_7),
                getString(R.string.rv_8),
                getString(R.string.rv_9),
                getString(R.string.rv_10),
                getString(R.string.rv_3),
                getString(R.string.rv_6),
        };

        lowestInterestRate = new String[] {
                "0.15",
                "0.41",
                "0.24",
                "0.26",
                "0.45",
                "0.35",
                "0.15",
                "0.41",
                "0.24",
                "0.26",
                "0.45",
                "0.35",
        };
        
        getData();

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
//                    } else if(getIntent().getStringExtra("액티비티").equals("detail")) {
//                        intent = new Intent(getApplicationContext(), Flow1Activity.class);
                    }
                    Log.d("mytag", "getIntent() : "+getIntent().getExtras().getString("업종"));
                    Log.d("mytag", "getIntent() : "+getIntent().getExtras().getString("액티비티"));
                }
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void getData() {
        for (int i=0; i<loanName.length; i++) {
            Loan loan = new Loan(loanName[i], loanType[i], loanTargetCustomers[i], loanDesc[i], lowestInterestRate[i]);
            loanArrayList.add(loan);
        }

        loanAdapter = new LoanAdapter(this, loanArrayList);
        recyclerView.setAdapter(loanAdapter);
        loanAdapter.notifyDataSetChanged();

    }


}