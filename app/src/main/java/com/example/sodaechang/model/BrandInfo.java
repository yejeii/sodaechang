package com.example.sodaechang.model;

// 리사이클러뷰에 보여줄 데이터를 담을 객체
// 브랜드정보 Model
public class BrandInfo {

    private String brand_id;
    private String brand_name;
    private int brand_logo;
    private String brand_main_category_code;
    private String brand_middle_category_code;
    private String brand_gugun_code;
    private String brand_dong_code;
    private String brand_dong_name;
    private String brand_address;
    private String brand_longitude;
    private String brand_latitude;
    private int brand_count;

//    public BrandInfo(String brand_id, String brand_name, int brand_logo, String brand_main_category_code,
//                     String brand_middle_category_code, String brand_gugun_code, String brand_dong_code,
//                     String brand_dong_name, String brand_address, String brand_longitude, String brand_latitude, int brand_count) {
//        this.brand_id = brand_id;
//        this.brand_name = brand_name;
//        this.brand_logo = brand_logo;
//        this.brand_main_category_code = brand_main_category_code;
//        this.brand_middle_category_code = brand_middle_category_code;
//        this.brand_gugun_code = brand_gugun_code;
//        this.brand_dong_code = brand_dong_code;
//        this.brand_dong_name = brand_dong_name;
//        this.brand_address = brand_address;
//        this.brand_longitude = brand_longitude;
//        this.brand_latitude = brand_latitude;
//        this.brand_count = brand_count;
//    }


    public BrandInfo(String brand_name, int brand_logo, int brand_count) {
        this.brand_name = brand_name;
        this.brand_logo = brand_logo;
        this.brand_count = brand_count;
    }

    public String getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(String brand_id) {
        this.brand_id = brand_id;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public int getBrand_logo() {
        return brand_logo;
    }

    public void setBrand_logo(int brand_logo) {
        this.brand_logo = brand_logo;
    }

    public String getBrand_main_category_code() {
        return brand_main_category_code;
    }

    public void setBrand_main_category_code(String brand_main_category_code) {
        this.brand_main_category_code = brand_main_category_code;
    }

    public String getBrand_middle_category_code() {
        return brand_middle_category_code;
    }

    public void setBrand_middle_category_code(String brand_middle_category_code) {
        this.brand_middle_category_code = brand_middle_category_code;
    }

    public String getBrand_gugun_code() {
        return brand_gugun_code;
    }

    public void setBrand_gugun_code(String brand_gugun_code) {
        this.brand_gugun_code = brand_gugun_code;
    }

    public String getBrand_dong_code() {
        return brand_dong_code;
    }

    public void setBrand_dong_code(String brand_dong_code) {
        this.brand_dong_code = brand_dong_code;
    }

    public String getBrand_dong_name() {
        return brand_dong_name;
    }

    public void setBrand_dong_name(String brand_dong_name) {
        this.brand_dong_name = brand_dong_name;
    }

    public String getBrand_address() {
        return brand_address;
    }

    public void setBrand_address(String brand_address) {
        this.brand_address = brand_address;
    }

    public String getBrand_longitude() {
        return brand_longitude;
    }

    public void setBrand_longitude(String brand_longitude) {
        this.brand_longitude = brand_longitude;
    }

    public String getBrand_latitude() {
        return brand_latitude;
    }

    public void setBrand_latitude(String brand_latitude) {
        this.brand_latitude = brand_latitude;
    }

    public int getBrand_count() {
        return brand_count;
    }

    public void setBrand_count(int brand_count) {
        this.brand_count = brand_count;
    }
}
