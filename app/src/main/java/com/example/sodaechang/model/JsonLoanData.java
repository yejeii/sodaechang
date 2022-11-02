package com.example.sodaechang.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class JsonLoanData {

    @SerializedName("loanList")
    public ArrayList<Loan> loanList;

    @Override
    public String toString() {
        return "JsonLoanData{" +
                "loanList=" + loanList +
                '}';
    }
}
