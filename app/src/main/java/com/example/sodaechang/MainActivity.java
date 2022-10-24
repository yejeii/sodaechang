package com.example.sodaechang;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.sodaechang.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());     // inflate() : xml에 있는 뷰를 객체화해준다
        setContentView(binding.getRoot());      // 우리가 생성한 루트 뷰를 넘겨준다

        // View
        ImageButton Q12 = binding.cafe;
        TextView Q12_text = binding.cafeText;

        // Intent
        // Intent로 Activity 전환
        /* 첫 번째에는 현재의 context 즉 'this', 두 번째에는 이동할 Activity.class 입력 */
        Intent intent = new Intent(this, Flow1Activity.class);
        // Intent로 값 전달 putExtra(Key, Value)
        intent.putExtra("업종" , Q12_text.getText().toString());

        Q12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Intent로 값 전달
                startActivity(intent);
            }
        });


    }


}