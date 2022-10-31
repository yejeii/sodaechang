package com.example.sodaechang;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class FirstFragment extends Fragment {

    TextView tv_gugun, tv_dong, tv_ctgry, tv_cost;
    ImageView imageView01;

    // Fragment의 lifecycle 메소드 중에서 Fragment가 보여줄 View를 설정하는 메소드
    // MainActivity.java 에서 onCreate() 메소드 안에 setContentView()하듯이
    // Fragment에서는 이 메소드에서 Fragment가 보여줄 View 객체를 생성해서 return 시켜줘야 함.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Fragment가 보여줄 View 객체형 참조변수 생성
        // 매개변수로 전달된 LayoutInflater 객체를 통해 fragment_first.xml 레이아웃 파일을 View 객체로 생성
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        // View
        tv_gugun = view.findViewById(R.id.tv_gugun);
        tv_dong = view.findViewById(R.id.tv_dong);
        tv_ctgry = view.findViewById(R.id.tv_ctgry);
        tv_cost = view.findViewById(R.id.tv_cost);


        // Flow1Activity.java에서 넘어온 정보 변수에 저장
        String gugun = this.getArguments().getString("gugun");
        String dong = this.getArguments().getString("dong");
        String catgry = this.getArguments().getString("catgry");

        // 정보를 텍스트뷰에 담기
        tv_gugun.setText(gugun);
        tv_dong.setText(dong);
        tv_ctgry.setText(catgry);

        String text = tv_ctgry.getText().toString();
        Log.d("mytag", text + "\n");

        imageView01 = view.findViewById(R.id.imgView01);


        //drawable 폴더에 있는 이미지 로드
        if (text.equals("한식")) {
            imageView01.setImageResource(R.drawable.a_q01);
            tv_cost.setText("82614");



        }
        else if (text.equals("중식")) {
            imageView01.setImageResource(R.drawable.a_q02);
            tv_cost.setText("82457");

        }
        else if (text.equals("일식")) {
            imageView01.setImageResource(R.drawable.a_q03);
            tv_cost.setText("94032");


        }
        else if (text.equals("분식")) {
            imageView01.setImageResource(R.drawable.a_q04);
            tv_cost.setText("60213");


        }
        else if (text.equals("치킨/오리요리")) {
            imageView01.setImageResource(R.drawable.a_q05);
            tv_cost.setText("56810");


        }
        else if (text.equals("양식")) {
            imageView01.setImageResource(R.drawable.a_q06);
            tv_cost.setText("87080");


        }
        else if (text.equals("아이스크림/피자/패스트푸드")) {
            imageView01.setImageResource(R.drawable.a_q07);
            tv_cost.setText("72362");


        }
        else if (text.equals("제과제빵/떡/케이크")) {
            imageView01.setImageResource(R.drawable.a_q08);
            tv_cost.setText("118503");

        }
        else if (text.equals("주점")) {
            imageView01.setImageResource(R.drawable.a_q09);
            tv_cost.setText("101679");

        }
        else if (text.equals("카페/디저트")){
            imageView01.setImageResource(R.drawable.a_q12);
            tv_cost.setText("94193");

        }


        // 생성된 View 객체를 리턴
        return view;
    }

}