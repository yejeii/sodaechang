package com.example.sodaechang;

import static androidx.constraintlayout.widget.Constraints.TAG;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sodaechang.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    ImageButton imageButton1, imageButton2, imageButton3, imageButton4, imageButton5, imageButton6,
            imageButton7, imageButton8, imageButton9, imageButton12;

    Toolbar toolbar;
    RelativeLayout relativeLayout;
    ImageButton.OnClickListener clickListener;
    ArrayAdapter<String> adapter;

    Intent intent;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());     // inflate() : xml에 있는 뷰를 객체화해준다
        setContentView(binding.getRoot());      // 우리가 생성한 루트 뷰를 넘겨준다

        // Toolbar 생성
        toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);  // 뒤로가기
        getSupportActionBar().setTitle(R.string.app_name_ko);   // 툴바 제목 설정

        // Init View
        init();

        // 버튼 클릭 리스너
        clickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.imageButton1:
                    case R.id.imageButton2:
                    case R.id.imageButton3:
                    case R.id.imageButton4:
                    case R.id.imageButton5:
                    case R.id.imageButton6:
                    case R.id.imageButton7:
                    case R.id.imageButton8:
                    case R.id.imageButton9:
                    case R.id.imageButton12:
                        finish();
//                        Log.d("mytag", String.valueOf(R.id.imageButton1));

                        /* 첫 번째에는 현재의 context 즉 'this', 두 번째에는 이동할 Activity.class 입력 */
                        // Intent로 값 전달 putExtra(Key, Value)
                        intent = new Intent(getApplicationContext(), Flow1Activity.class);
                        intent.putExtra("업종", String.valueOf(view.getContentDescription()));
                        startActivity(intent);
                        Log.d("mytag", MainActivity.this.getClass() + " // " + String.valueOf(view.getContentDescription()));
                        break;
                }
            }
        };

        imageButton1.setOnClickListener(clickListener);
        imageButton2.setOnClickListener(clickListener);
        imageButton3.setOnClickListener(clickListener);
        imageButton4.setOnClickListener(clickListener);
        imageButton5.setOnClickListener(clickListener);
        imageButton6.setOnClickListener(clickListener);
        imageButton7.setOnClickListener(clickListener);
        imageButton8.setOnClickListener(clickListener);
        imageButton9.setOnClickListener(clickListener);
        imageButton12.setOnClickListener(clickListener);

        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("mytag", "Flow2 시작");
            }
        });


//        adapter = new ArrayAdapter<>(this, R.layout.req_01);
//        adapter.addAll("부전동", "가야동", "개금동", "당감동", "부암동", "연지동", "양정동", "전포동", "범천동");

    }

    private void init() {
        // xml에서 생성한 id 매치
        imageButton1 = binding.imageButton1;
        imageButton2 = binding.imageButton2;
        imageButton3 = binding.imageButton3;
        imageButton4 = binding.imageButton4;
        imageButton5 = binding.imageButton5;
        imageButton6 = binding.imageButton6;
        imageButton7 = binding.imageButton7;
        imageButton8 = binding.imageButton8;
        imageButton9 = binding.imageButton9;
        imageButton12 = binding.imageButton12;

        relativeLayout = binding.relativeFlow2;
    }

    //버튼클릭
    public void mOnMenu(View v) {
        CreateListDialog();
    }

    public void CreateListDialog() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("행정동 선택");
        alert.setIcon(R.drawable.info);

        //어댑터, 클릭이벤트 설정
        alert.setAdapter(adapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String menu = adapter.getItem(which);
                Toast.makeText(MainActivity.this, "선택한 행정동 :" + menu, Toast.LENGTH_SHORT).show();
            }
        });
        alert.show();
    }

}






