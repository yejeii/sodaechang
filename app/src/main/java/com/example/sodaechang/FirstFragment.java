package com.example.sodaechang;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FirstFragment extends Fragment {


    // Fragment의 lifecycle 메소드 중에서 Fragment가 보여줄 View를 설정하는 메소드
    // MainActivity.java 에서 onCreate() 메소드 안에 setContentView()하듯이
    // Fragment에서는 이 메소드에서 Fragment가 보여줄 View 객체를 생성해서 return 시켜줘야 함.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Fragment가 보여줄 View 객체를 참조할 참조변수 생성
        View view = null;

        // View
        TextView tv_gugun = view.findViewById(R.id.tv_gugun);
        TextView tv_dong = view.findViewById(R.id.tv_dong);
        TextView tv_ctgry = view.findViewById(R.id.tv_ctgry);

        // 매개변수로 전달된 LayoutInflater 객체를 통해 fragment_first.xml 레이아웃 파일을 View 객체로 생성
        view = inflater.inflate(R.layout.fragment_first, container, false);

        // Flow1Activity.java에서 넘어온 정보 변수에 저장
        String gugun = this.getArguments().getString("gugun");
        String dong = this.getArguments().getString("dong");
        String catgry = this.getArguments().getString("catgry");

        // 정보를 텍스트뷰에 담기
        tv_gugun.setText(gugun);
        tv_dong.setText(dong);
        tv_ctgry.setText(catgry);

        // 생성된 View 객체를 리턴
        return view;
    }

}