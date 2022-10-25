package com.example.sodaechang;

import static androidx.constraintlayout.widget.Constraints.TAG;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sodaechang.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    ImageButton imageButton1,imageButton2,imageButton3,imageButton4,imageButton5,imageButton6,imageButton7,imageButton8,imageButton9,imageButton12;
    ArrayAdapter<String> adapter;

//    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        binding = ActivityMainBinding.inflate(getLayoutInflater());     // inflate() : xml에 있는 뷰를 객체화해준다
        setContentView(R.layout.activity_main);      // 우리가 생성한 루트 뷰를 넘겨준다


        imageButton1 = (ImageButton) findViewById(R.id.imageButton1);
        imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        imageButton3 = (ImageButton) findViewById(R.id.imageButton3);
        imageButton4 = (ImageButton) findViewById(R.id.imageButton4);
        imageButton5 = (ImageButton) findViewById(R.id.imageButton5);
        imageButton6 = (ImageButton) findViewById(R.id.imageButton6);
        imageButton7 = (ImageButton) findViewById(R.id.imageButton7);
        imageButton8 = (ImageButton) findViewById(R.id.imageButton8);
        imageButton9 = (ImageButton) findViewById(R.id.imageButton9);
        imageButton12 = (ImageButton) findViewById(R.id.imageButton12);


        adapter = new ArrayAdapter<>(this,R.layout.req_01);
        adapter.addAll("부전동","가야동","개금동","당감동","부암동","연지동","양정동","전포동","범천동");

    }
    //버튼클릭
    public void mOnMenu(View v){
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

        ImageButton.OnClickListener onClickListener = new ImageButton.OnClickListener(){
                @Override
                public void onClick (View v){
                    Intent intent;
                    Log.d("mytag","message");

                    intent = new Intent(getApplicationContext(),Flow1Activity.class);
                    intent.putExtra("업종", "Q1");
                    startActivity(intent);
                    Log.v("tag",getApplicationContext().toString());
//                    switch (v.getId()) {
//                        case R.id.imageButton1:
//                            intent = new Intent(getApplicationContext(),Flow1Activity.class);
//                            intent.putExtra("업종", "Q1");
//                            startActivity(intent);
//                            Log.v("tag",getApplicationContext().toString());
//                            break;
//                        case R.id.imageButton2:
//                            intent = new Intent(getApplicationContext(),Flow1Activity.class);
//                            intent.putExtra("업종", "Q2");
//                            startActivity(intent);
//                            Log.v("tag","message");
//                            break;
//                        case R.id.imageButton3:
//                            intent = new Intent(getApplicationContext(),Flow1Activity.class);
//                            intent.putExtra("업종", "Q3");
//                            startActivity(intent);
//                            Log.d("tag","message");
//                            break;
//                        case R.id.imageButton4:
//                            intent = new Intent(getApplicationContext(),Flow1Activity.class);
//                            intent.putExtra("업종", "Q4");
//                            startActivity(intent);
//                            Log.d("tag","message");
//                            break;
//                        case R.id.imageButton5:
//                            intent = new Intent(getApplicationContext(),Flow1Activity.class);
//                            intent.putExtra("업종", "Q5");
//                            startActivity(intent);
//                            Log.d("tag","message");
//                            break;
//                        case R.id.imageButton6:
//                            intent = new Intent(getApplicationContext(),Flow1Activity.class);
//                            intent.putExtra("업종", "Q6");
//                            startActivity(intent);
//                            Log.d("tag","message");
//                            break;
//                        case R.id.imageButton7:
//                            intent = new Intent(getApplicationContext(),Flow1Activity.class);
//                            intent.putExtra("업종", "Q7");
//                            startActivity(intent);
//                            Log.d("tag","message");
//                            break;
//                        case R.id.imageButton8:
//                            intent = new Intent(getApplicationContext(),Flow1Activity.class);
//                            intent.putExtra("업종", "Q8");
//                            startActivity(intent);
//                            Log.d("tag","message");
//                            break;
//                        case R.id.imageButton9:
//                            intent = new Intent(getApplicationContext(),Flow1Activity.class);
//                            intent.putExtra("업종", "Q9");
//                            startActivity(intent);
//                            Log.d("tag","message");
//                            break;
//                        case R.id.imageButton12:
//                            intent = new Intent(getApplicationContext(),Flow1Activity.class);
//                            intent.putExtra("업종", "Q12");
//                            startActivity(intent);
//                            Log.d("tag","message");
//                            break;
                    }
                    /*imageButton1.setOnClickListener(onClickListener);
                    imageButton2.setOnClickListener(onClickListener);
                    imageButton3.setOnClickListener(onClickListener);
                    imageButton4.setOnClickListener(onClickListener);
                    imageButton5.setOnClickListener(onClickListener);
                    imageButton6.setOnClickListener(onClickListener);
                    imageButton7.setOnClickListener(onClickListener);
                    imageButton8.setOnClickListener(onClickListener);
                    imageButton9.setOnClickListener(onClickListener);
                    imageButton12.setOnClickListener(onClickListener);*/
                };

            };





//        intent.putExtra("업종",imageButton.toString());




//        // View
//        ImageButton Q12 = binding.imageButton_01;
////        TextView Q12_text = binding.cafeText;
//
//        // Intent
//        // Intent로 Activity 전환
//        /* 첫 번째에는 현재의 context 즉 'this', 두 번째에는 이동할 Activity.class 입력 */
//        Intent intent = new Intent(this, Flow1Activity.class);
//        // Intent로 값 전달 putExtra(Key, Value)
//        intent.putExtra("업종" , Q12.toString());  //Q12_text.getText()
//
//        Q12.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                // Intent로 값 전달
//                startActivity(intent);
//            }
//        });





