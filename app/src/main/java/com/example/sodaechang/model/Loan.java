package com.example.sodaechang.model;

public class Loan {
    private int loan_id;
    private String loan_bank;
    private String loan_bank_logo;
    private String loan_name;
    private String loan_type;
    private String loan_target_customers;
    private String loan_credit_line;
    private String loan_period;
    private String loan_interest_rate;
    private String loan_desc;
    private String lowest_interest_rate;
    private boolean visibility;

    public Loan(String loan_name, String loan_type, String loan_target_customers,
                String loan_desc, String lowest_interest_rate) {
        this.loan_name = loan_name;
        this.loan_type = loan_type;
        this.loan_target_customers = loan_target_customers;
        this.loan_desc = loan_desc;
        this.lowest_interest_rate = lowest_interest_rate;
    }

    public Loan(int loan_id, String loan_bank, String loan_bank_logo, String loan_name,
                String loan_type, String loan_target_customers, String loan_credit_line,
                String loan_period, String loan_interest_rate, String loan_desc,
                String lowest_interest_rate) {
        this.loan_id = loan_id;
        this.loan_bank = loan_bank;
        this.loan_bank_logo = loan_bank_logo;
        this.loan_name = loan_name;
        this.loan_type = loan_type;
        this.loan_target_customers = loan_target_customers;
        this.loan_credit_line = loan_credit_line;
        this.loan_period = loan_period;
        this.loan_interest_rate = loan_interest_rate;
        this.loan_desc = loan_desc;
        this.lowest_interest_rate = lowest_interest_rate;
        this.visibility = false;
    }

    public int getLoan_id() {
        return loan_id;
    }

    public void setLoan_id(int loan_id) {
        this.loan_id = loan_id;
    }

    public String getLoan_bank() {
        return loan_bank;
    }

    public void setLoan_bank(String loan_bank) {
        this.loan_bank = loan_bank;
    }

    public String getLoan_bank_logo() {
        return loan_bank_logo;
    }

    public void setLoan_bank_logo(String loan_bank_logo) {
        this.loan_bank_logo = loan_bank_logo;
    }

    public String getLoan_name() {
        return loan_name;
    }

    public void setLoan_name(String loan_name) {
        this.loan_name = loan_name;
    }

    public String getLoan_type() {
        return loan_type;
    }

    public void setLoan_type(String loan_type) {
        this.loan_type = loan_type;
    }

    public String getLoan_target_customers() {
        return loan_target_customers;
    }

    public void setLoan_target_customers(String loan_target_customers) {
        this.loan_target_customers = loan_target_customers;
    }

    public String getLoan_credit_line() {
        return loan_credit_line;
    }

    public void setLoan_credit_line(String loan_credit_line) {
        this.loan_credit_line = loan_credit_line;
    }

    public String getLoan_period() {
        return loan_period;
    }

    public void setLoan_period(String loan_period) {
        this.loan_period = loan_period;
    }

    public String getLoan_interest_rate() {
        return loan_interest_rate;
    }

    public void setLoan_interest_rate(String loan_interest_rate) {
        this.loan_interest_rate = loan_interest_rate;
    }

    public String getLoan_desc() {
        return loan_desc;
    }

    public void setLoan_desc(String loan_desc) {
        this.loan_desc = loan_desc;
    }

    public String getLowest_interest_rate() {
        return lowest_interest_rate;
    }

    public void setLowest_interest_rate(String lowest_interest_rate) {
        this.lowest_interest_rate = lowest_interest_rate;
    }

    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }
}
