package com.example.sodaechang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.adapter.FragmentViewHolder;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sodaechang.databinding.ActivityFlow1Binding;

import org.w3c.dom.Text;

public class Flow1Activity extends AppCompatActivity {

    private final int Fragment_1 = 1;
    private final int Fragment_2 = 2;

    private ActivityFlow1Binding binding;
    private Button refresh_btn;
    private TextView ctgry_tv;
    private ImageButton frag1_btn, frag2_btn;

    private Fragment firstFragment, secondFragment;   // Fragment 참조변수
    private FragmentManager manager;       // FragmentTrasaction 객체를 얻기 위해 필요한 참조 객체
    private FragmentTransaction tran;      // 프래그먼트의 트랜젝션을 수행(프래그먼트를 추가/삭제/교체)을 수행하기 위한 객체

    // Spinner를 위한 어댑터 선언. adtr_spnr1(행정구) adtr_spnr2(행정동)
    private ArrayAdapter<CharSequence> adtr_spnr1, adtr_spnr2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFlow1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Init View(xml과 class에 변수 연결)
        // gugun_spr, dong_spr가 함수 안에서 사용되기 때문에 코딩전체로 선언
        final Spinner gugun_spr = binding.sprGugun;
        final Spinner dong_spr = binding.sprDong;
//        final String gugun_text;    // 프래그먼트로 전달할 변수라 final로 지정
        final String[] dong_text = new String[1];
//        final TextView gugun_tv = R.id.tv_gugun;
//        final TextView dong_tv = binding.tvDong;
        frag1_btn = binding.btnFrag1;
        frag2_btn = binding.btnFrag2;
        refresh_btn = binding.btnRefresh;
//        ctgry_tv = binding.tvCtgry;

        // MainActivity에서 건너온 업종명(intent 값) 받아오기
        Intent intent = getIntent();
//        ctgry_tv.setText(intent.getStringExtra("업종"));
        Log.d("mytag", "업종 명 : "+intent.getStringExtra("업종"));
//        intent.getIntExtra("key값", 0);   int의 경우 value에 default 값을 적어준다

        // 사용자가 Flow1Activity에 있는 spinner에서 선택한 값이 FirstFragment에 전달되어 표현될 예정.
        // 첫번째 spinner에 값 넣기
        // ArrayAdapter.createFromResource의 인자
        // 1. Flow1Activity.this : 현재 class를 의미(그냥 this는 메인엑티비티인 경우만 가능)
        // 2. R.array.spnr_gugun : values->spinner_array.xml에 따로 String값들을 선언
        // 3. R.layout.simple_~~~ : 안드로이드에서 기본제공하는 spinner 모양
        adtr_spnr1 = ArrayAdapter.createFromResource(Flow1Activity.this, R.array.spnr_gugun, android.R.layout.simple_spinner_dropdown_item);
        adtr_spnr1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gugun_spr.setAdapter(adtr_spnr1);   // 어댑터에 값들(R.array.spnr_gugun)을 spinner에 장착

        // 첫번째 spinner(gugun_spr) 클릭시 이벤트 발생
        gugun_spr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // int i : 포지션이라 하여 사용자가 spinner에 선택한 값이 들어간다
                Log.d("mytag", "position is"+adapterView.getItemAtPosition(i).toString());

                if (adtr_spnr1.getItem(i).equals("부산진구")) { // spinner에 선택한 값이 "부산진구"이면
//                    gugun_tv.setText(adtr_spnr1.getItem(i));    // 확인

                    // "부산진구"일 경우 두번째 spinner에 값을 넣는 작업
                    adtr_spnr2 = ArrayAdapter.createFromResource(Flow1Activity.this, R.array.spnr_busanjin, android.R.layout.simple_spinner_dropdown_item);
                    adtr_spnr2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    dong_spr.setAdapter(adtr_spnr2);    // 두번째 어댑터값(R.array.spnr_busanjin)을 두번째 spinner에 장착

                    dong_spr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            Log.d("mytag", "position is"+adapterView.getItemAtPosition(i).toString());

//                            dong_tv.setText(adtr_spnr2.getItem(i));    // 확인
//                            dong_text[0] = adtr_spnr2.getItem(i).toString();
                            dong_text[0] = adapterView.getItemAtPosition(i).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                            // 아무것도 선택안될시 부분

                        }
                    });

                    // FirstFragment.java로 값 전달
                    manager = getSupportFragmentManager();  // Fragment를 제어하기 위한 매니저 객체 GET
                    tran = manager.beginTransaction();

                    Bundle bundle = new Bundle();

                    // 1. 입력 메세지
                    String gugun_text = adtr_spnr1.getItem(i).toString();
//                    String dong_text = adtr_spnr2.getItem(i).toString();

                    // 2. 데이터 담기
                    bundle.putString("gugun", gugun_text);
                    bundle.putString("dong", dong_text[0]);
                    bundle.putString("catgry", intent.getStringExtra("업종"));

                    // 3. 프래그먼트 선언
                    firstFragment = new FirstFragment();

                    // 4. 프래그먼트에 데이터 넘기기
                    firstFragment.setArguments(bundle);

                    // 5. 프래그먼트 화면 보여주기
                    tran.replace(R.id.fragment_container, firstFragment).commit();
                }
                else if(adtr_spnr1.getItem(i).equals("강서구")) {
//                    gugun_tv.setText(adtr_spnr1.getItem(i));    // 확인

                    // "강서구"일 경우 두번째 spinner에 값을 넣는 작업
                    adtr_spnr2 = ArrayAdapter.createFromResource(Flow1Activity.this, R.array.spnr_gangseo, android.R.layout.simple_spinner_dropdown_item);
                    adtr_spnr2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    dong_spr.setAdapter(adtr_spnr2);    // 두번째 어댑터값(R.array.spnr_gangseo)을 두번째 spinner에 장착

                    dong_spr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            Log.d("mytag", "position is"+adapterView.getItemAtPosition(i).toString());

//                            dong_tv.setText(adtr_spnr2.getItem(i));    // 확인
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                            // 아무것도 선택안될시 부분

                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // 검색 버튼 클릭 이벤트
        refresh_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(Flow1Activity.this, gugun_tv.getText().toString()+" "+dong_tv.getText().toString()+"을 선택하셨습니다!", Toast.LENGTH_SHORT).show();
            }
        });

        // 프래그먼트 버튼 클릭 이벤트
        frag1_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentView(Fragment_1);
            }
        });

        frag2_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentView(Fragment_2);
            }
        });


    }

    private void FragmentView(int fragment) {
        // FragmentTransactiom를 이용해 프래그먼트를 사용
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        switch (fragment) {
            case 1:     // 첫번째 프래그먼트 호출
                FirstFragment fragment1 = new FirstFragment();
                transaction.replace(R.id.fragment_container, fragment1);
                transaction.commit();
                break;
            case 2:     // 두번째 프래그먼트 호출
                SecondFragment fragment2 = new SecondFragment();
                transaction.replace(R.id.fragment_container, fragment2);
                transaction.commit();
                break;
        }
    }
}