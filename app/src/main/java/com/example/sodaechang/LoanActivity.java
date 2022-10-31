package com.example.sodaechang;

import android.os.Bundle;

import com.example.sodaechang.model.BrandInfo;
import com.example.sodaechang.model.Loan;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.constraintlayout.widget.ConstraintSet;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sodaechang.databinding.ActivityLoanBinding;

import java.util.ArrayList;

public class LoanActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityLoanBinding binding;
    private RecyclerView recyclerView;
    private LoanAdapter loanAdapter;

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

        setSupportActionBar(binding.toolbar);

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
    

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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