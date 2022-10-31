package com.example.sodaechang;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.loader.content.AsyncTaskLoader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sodaechang.model.BrandInfo;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

/**
 * A fragment representing a list of Items.
 */
public class SecondFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    private ArrayList<BrandInfo> brandArrayList;    // 브랜드 정보를 저장할 ArrayList
    private String[] names;
    private int[] logos;
    private int[] counts;
    private RecyclerView recyclerView;

    private static String IP_ADDRESS = "10.0.2.2";
    private static String TAG = "PHPTEST";


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public SecondFragment() {
        // Required empty public constructor
    }

    // TODO: Customize parameter initialization
    // Use this factory method to create a new instance of this fragment using the provided parameters.
    // Return a new instance of fragment Home.
    @SuppressWarnings("unused")
    public static SecondFragment newInstance(int columnCount) {
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    // 정상적인 Fragment View 객체를 제공
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_second, container, false);

        // 데이터 초기화
//        dataInitialize();

//        recyclerView = view.findViewById(R.id.list);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        recyclerView.setHasFixedSize(true);
//        BrandRecyclerViewAdapter brandAdapter = new BrandRecyclerViewAdapter(getContext(), brandArrayList);
//        recyclerView.setAdapter(brandAdapter);
//        brandAdapter.notifyDataSetChanged();

        return view;
    }

    // 작업 6. View 초기값 설정 & Recyclerview에 사용할 Adapter 세팅 코드 작성
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // 데이터 초기화
        dataInitialize();

        // RecyclerView init
        recyclerView = view.findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        BrandRecyclerViewAdapter brandAdapter = new BrandRecyclerViewAdapter(getContext(), brandArrayList);
        recyclerView.setAdapter(brandAdapter);
        brandAdapter.notifyDataSetChanged();


    }

    // BrandInfo 클래스의 객체 생성, 1차원 배열 변수에 strings.xml에 저장된 제목과 drawable에 저장된
    // 이미지 파일을 BrandInfo 클래스 객체로 추가하여 데이터 초기화한다
    private void dataInitialize() {

        brandArrayList = new ArrayList<>();

        names = new String[] {
                getString(R.string.bd_1),
                getString(R.string.bd_2),
                getString(R.string.bd_3),
                getString(R.string.bd_4),
                getString(R.string.bd_5),
                getString(R.string.bd_6),
                getString(R.string.bd_7),
                getString(R.string.bd_8),
                getString(R.string.bd_9),
                getString(R.string.bd_10),
        };

        logos = new int[]{
                R.drawable.a,
                R.drawable.b,
                R.drawable.c,
                R.drawable.d,
                R.drawable.e,
                R.drawable.f,
                R.drawable.g,
                R.drawable.h,
                R.drawable.i,
                R.drawable.j,
        };

        counts = new int[] {
                4,
                15,
                34,
                3,
                97,
                3,
                31,
                0,
                6,
                15,
        };

        for (int i=0; i<names.length; i++) {
            BrandInfo brand = new BrandInfo(names[i], logos[i], counts[i]);
            brandArrayList.add(brand);
        }
    }

}