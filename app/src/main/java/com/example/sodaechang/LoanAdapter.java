package com.example.sodaechang;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sodaechang.model.Loan;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class LoanAdapter extends RecyclerView.Adapter<LoanAdapter.MyLoanHolder> {

    private Context context;
    private ArrayList<Loan> loanArrayList;


    public LoanAdapter(Context context, ArrayList<Loan> loanArrayList) {
        this.context = context;
        this.loanArrayList = loanArrayList;
    }

    @NonNull
    @Override
    public MyLoanHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("mytag", " LoanAdapter : onCreateViewHolder에 들어옴");

        // 아이템 하나가 담기는 xml 파일과 View 연결
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View cardView = inflater.inflate(R.layout.loan_item, parent, false);

        // 각각의 아이템을 위한 뷰를 담고있는 뷰홀더 객체를 반환
        // (각 아이템을 위한 XML 레이아웃을 이용해 뷰 객체를 만들었고 이걸 뷰홀더에서 참조할 수 있도록 위에 만들어 놓음)
        return new MyLoanHolder(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull LoanAdapter.MyLoanHolder holder, int position) {

        Loan loan = loanArrayList.get(position);
        holder.loan_name.setText(loan.getLoan_name());
//        holder.loan_bank_logo.setImageResource(loan.getLoan_bank_logo());
        holder.loan_type.setText(loan.getLoan_type());
        holder.loan_target_customers.setText(loan.getLoan_target_customers());
        holder.loan_desc.setText(loan.getLoan_desc());
        holder.lowest_interest_rate.setText(loan.getLowest_interest_rate());

        boolean isVisible = loan.isVisibility();
        holder.linearLayout.setVisibility(isVisible ? View.VISIBLE : View.GONE);

    }

    @Override
    public int getItemCount() {
        return loanArrayList.size();
    }

    public class MyLoanHolder extends RecyclerView.ViewHolder {

        TextView loan_name, lowest_interest_rate, loan_type, loan_target_customers, loan_desc;
        ShapeableImageView loan_bank_logo;

        LinearLayout linearLayout;

        // 뷰홀더 생성자(뷰 홀더 초기 세팅)
        public MyLoanHolder(@NonNull View itemView) {
            super(itemView);
            loan_name = itemView.findViewById(R.id.tv_name);
            lowest_interest_rate = itemView.findViewById(R.id.tv_lowest);
            loan_type = itemView.findViewById(R.id.tv_type);
            loan_target_customers = itemView.findViewById(R.id.tv_target);
            loan_desc = itemView.findViewById(R.id.tv_desc);
            loan_bank_logo = itemView.findViewById(R.id.img_logo);
            linearLayout = itemView.findViewById(R.id.layout_expended);

            loan_name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Loan loan = loanArrayList.get(getAbsoluteAdapterPosition());
                    loan.setVisibility(!loan.isVisibility());
                    notifyItemChanged(getAbsoluteAdapterPosition());
                }
            });
        }
    }

}
