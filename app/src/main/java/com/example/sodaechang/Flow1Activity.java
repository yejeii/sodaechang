package com.example.sodaechang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.sodaechang.databinding.ActivityFlow1Binding;

public class Flow1Activity extends AppCompatActivity {

    private ActivityFlow1Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFlow1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // view
        TextView tv = binding.textView2;

        // MainActivity에서 건너온 intent 값 받아오기
        Intent intent = getIntent();
        String category = intent.getStringExtra("업종");
//        intent.getIntExtra("key값", 0);   int의 경우 value에 default 값을 적어준다

        tv.setText(category);

    }
}