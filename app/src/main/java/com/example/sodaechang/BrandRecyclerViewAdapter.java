package com.example.sodaechang;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sodaechang.model.BrandInfo;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

// Adapter : 리사이클러 뷰에 데이터를 넣고 가져오는 기능을 담당
public class BrandRecyclerViewAdapter extends RecyclerView.Adapter<BrandRecyclerViewAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<BrandInfo> brandArrayList;
//    private OnPostListener onPostListener;
//    String getContentsNum;
    int position;

    // 작업 2. BrandRecyclerViewAdapter 클래스에 대한 생성자 생성
    // 이 클래스 호출 시 생성자자 먼저 불리면서 데이터 리스트 객체ㅇ & Context를 저장한다.
    // 어댑터에서 액티비티 액션을 가져올 때  context가 필요한데 어댑터에는 context가 없음.
    // 선택한 액티비티에 대한 context를 가져올 때 필요.
    public BrandRecyclerViewAdapter(Context context, ArrayList<BrandInfo> brandArrayList) {
        this.context = context;
        this.brandArrayList = brandArrayList;
    }

    // 작업 4. 뷰를 담고 있는 뷰 홀더 생성
    // onCreateViewHolder(){} : 리스트 뷰가 어댑터에 연결된 다음 이쪽에서 뷰 홀더를 최초로 만들어 냄.
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("mytag", " onCreateViewHolder에 들어옴");

        // 아이템 하나가 담기는 xml 파일과 View 연결
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View cardView = inflater.inflate(R.layout.fragment_second_list_item, parent, false);

        // 각각의 아이템을 위한 뷰를 담고있는 뷰홀더 객체를 반환
        // (각 아이템을 위한 XML 레이아웃을 이용해 뷰 객체를 만들었고 이걸 뷰홀더에서 참조할 수 있도록 위에 만들어 놓음)
        MyViewHolder holder = new MyViewHolder(cardView);
        return holder;

//        return new ViewHolder(FragmentSecondBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    // 작업 5. 각 아이템들에 대해 실제적으로 매칭
    // onBindViewHolder() - position 서로 결합되는 경우 해당하는 데이터를 뷰홀더의 아이템뷰에 표시.
    // View 의 내용을 해당 포지션의 데이터로 바꿉니다.
    // 각각의 아이템을 위한 뷰의 xml 레이아웃 호출(즉, 뷰홀더가 각각의 아이템을 위한 뷰를 담아주기 위한 용도인데, 뷰와 아이템이 합쳐질 때 호출)
    // 적절한 데이터를 가져와서 뷰 소유자의 레이아웃을 채우기 위해서 사용(뷰홀더에 각 아이템의 데이터를 설정해 놓았음.)
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        // 각 위치에 문자열 세팅
        // 리스트에서 News 인스턴스 하나(정보)를 가져온다(newsArrayList.get(position)) 어댑터 쪽으로 쏜다.
        BrandInfo brand = brandArrayList.get(position);  // 데이터 리스트 객체에서 어떤거 가져올지 위치로 추출

        // 뷰홀더에 가져온 인스턴스 정보를 장착
//        holder.store_number.setText(brand.getBrand_id());
        holder.store_name.setText(brand.getBrand_name());
//        holder.store_catgry.setText(brand.getBrand_main_category_code());
        holder.store_logo.setImageResource(brand.getBrand_logo());
//        holder.store_count.setText(brand.getBrand_count());

//        context = holder.itemView.getContext();
//        holder.setItem(brand);
    }

    // 작업 1.
    // 몇개의 데이터를 리스트로 뿌려줘야하는지 반드시 정의해줘야한다
    @Override
    public int getItemCount() {

        // 삼항연산자 arrayList 가 null이면 왼쪽꺼 실행 아니면 오른쪽거 실행
        return (brandArrayList != null ? brandArrayList.size() : 0);
    }


    // 작업 3. ViewHolder 생성
    // 이 RecyclerView 에 뷰홀더에서 상속을 받아서 거기에 아이템 값을 찾아와야 한다.
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView store_number;
        ShapeableImageView store_logo;
        TextView store_name;
        TextView store_catgry;
        TextView store_count;

        // 뷰홀더 생성자(뷰 홀더 초기 세팅)
        public MyViewHolder(@NonNull View view) {
            super(view);
            store_number = view.findViewById(R.id.store_number);
            store_logo = view.findViewById(R.id.store_logo);
            store_name = view.findViewById(R.id.store_name);
            store_catgry = view.findViewById(R.id.store_catgry);
            store_count = view.findViewById(R.id.store_count);

            // 리사이클러 뷰의 각 아이템을 재사용하는 MyViewHolder에서 각 아이템에 대한 클릭 리스너를 단다
            // MyViewHolder가 리사이클러 뷰의 각 뷰 항목을 만드는 역할을 하기 때문에 여기서 작업을 수행!
//            view.setClickable(true);
//            view.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    position = getAbsoluteAdapterPosition();
//
//                    if(position != RecyclerView.NO_POSITION) {
//
//                        // brandList로부터 데이터 참조
//                        BrandInfo brand = brandArrayList.get(position);
//
//                        String getName = brand.getBrand_name();
//                        String getLogo = brand.getBrand_logo();
//                        String getCatgry = brand.getBrand_middle_category_code();
////                        String getCount =
//
//                        // 클릭한 리사이클러 뷰의 내용을 인텐트에 담아서 액티비티로 이동
//                        Intent intent = new Intent(context, ContentsActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                        intent.putExtra("brand_name", getName);
//                        intent.putExtra("brand_logo", getLogo);
//                        intent.putExtra("brand_catgry", getCatgry);
//                        context.startActivity(intent);
//                    }
//                }
//            });
        }
    }
}