package com.example.sodaechang.model;

import com.google.gson.annotations.SerializedName;

// JSON 데이터를 class로 받아오기 위한 작업
// JSON의 key값을 그대로 변수화(JSON 데이터값과 정확하게 일치해야 할 것)
// @SerializedName()으로 JSON 객체 매칭
public class Loan {
    @SerializedName("loanId")
    private int loanId;
    @SerializedName("loanBank")
    private String loanBank;
    @SerializedName("loanBankLogo")
    private String loanBankLogo;
    @SerializedName("loanName")
    private String loanName;
    @SerializedName("loanType")
    private String loanType;
    @SerializedName("loanTarget")
    private String loanTarget;
    @SerializedName("loanCreditLine")
    private String loanCreditLine;
    @SerializedName("loanPeriod")
    private String loanPeriod;
    @SerializedName("loanInterestRate")
    private String loanInterestRate;
    @SerializedName("loanDesc")
    private String loanDesc;
    @SerializedName("lowestInterestRate")
    private String lowestInterestRate;
    @SerializedName("visibility")
    private boolean visibility;

    public Loan() {
    }

    public Loan(String loanName, String loanBank, String loanBankLogo, String loanType,
                String loanTarget, String loanDesc, String lowestInterestRate) {
        this.loanBank = loanBank;
        this.loanBankLogo = loanBankLogo;
        this.loanName = loanName;
        this.loanType = loanType;
        this.loanTarget = loanTarget;
        this.loanDesc = loanDesc;
        this.lowestInterestRate = lowestInterestRate;
    }

    public Loan(int loanId, String loanBank, String loanBankLogo, String loanName,
                String loanType, String loanTarget, String loanCreditLine, String loanPeriod,
                String loanInterestRate, String loanDesc, String lowestInterestRate,
                boolean visibility) {
        this.loanId = loanId;
        this.loanBank = loanBank;
        this.loanBankLogo = loanBankLogo;
        this.loanName = loanName;
        this.loanType = loanType;
        this.loanTarget = loanTarget;
        this.loanCreditLine = loanCreditLine;
        this.loanPeriod = loanPeriod;
        this.loanInterestRate = loanInterestRate;
        this.loanDesc = loanDesc;
        this.lowestInterestRate = lowestInterestRate;
        this.visibility = visibility;
    }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public String getLoanBank() {
        return loanBank;
    }

    public void setLoanBank(String loanBank) {
        this.loanBank = loanBank;
    }

    public String getLoanBankLogo() {
        return loanBankLogo;
    }

    public void setLoanBankLogo(String loanBankLogo) {
        this.loanBankLogo = loanBankLogo;
    }

    public String getLoanName() {
        return loanName;
    }

    public void setLoanName(String loanName) {
        this.loanName = loanName;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public String getLoanTarget() {
        return loanTarget;
    }

    public void setLoanTarget(String loanTarget) {
        this.loanTarget = loanTarget;
    }

    public String getLoanCreditLine() {
        return loanCreditLine;
    }

    public void setLoanCreditLine(String loanCreditLine) {
        this.loanCreditLine = loanCreditLine;
    }

    public String getLoanPeriod() {
        return loanPeriod;
    }

    public void setLoanPeriod(String loanPeriod) {
        this.loanPeriod = loanPeriod;
    }

    public String getLoanInterestRate() {
        return loanInterestRate;
    }

    public void setLoanInterestRate(String loanInterestRate) {
        this.loanInterestRate = loanInterestRate;
    }

    public String getLoanDesc() {
        return loanDesc;
    }

    public void setLoanDesc(String loanDesc) {
        this.loanDesc = loanDesc;
    }

    public String getLowestInterestRate() {
        return lowestInterestRate;
    }

    public void setLowestInterestRate(String lowestInterestRate) {
        this.lowestInterestRate = lowestInterestRate;
    }

    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }
}
