package com.example.test.entity;

public class User {


    /**
     * user_id : 1
     * user_account : 111
     * user_password : 111
     * user_name : 张三
     * unit_name : 其他
     * sex : 1
     * education : 小学
     * email : 123456789@qq.com
     * user_icon : null
     * num_id : 1
     * identity_id : 1
     * district_id : 1
     */

    private int user_id;
    private String user_account;
    private String user_password;
    private String user_name;
    private String unit_name;
    private int sex;
    private String education;
    private String email;
    private Object user_icon;
    private int num_id;
    private int identity_id;
    private String district_id;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_account() {
        return user_account;
    }

    public void setUser_account(String user_account) {
        this.user_account = user_account;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUnit_name() {
        return unit_name;
    }

    public void setUnit_name(String unit_name) {
        this.unit_name = unit_name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Object getUser_icon() {
        return user_icon;
    }

    public void setUser_icon(Object user_icon) {
        this.user_icon = user_icon;
    }

    public int getNum_id() {
        return num_id;
    }

    public void setNum_id(int num_id) {
        this.num_id = num_id;
    }

    public int getIdentity_id() {
        return identity_id;
    }

    public void setIdentity_id(int identity_id) {
        this.identity_id = identity_id;
    }

    public String getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(String district_id) {
        this.district_id = district_id;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_account='" + user_account + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_name='" + user_name + '\'' +
                ", unit_name='" + unit_name + '\'' +
                ", sex=" + sex +
                ", education='" + education + '\'' +
                ", email='" + email + '\'' +
                ", user_icon=" + user_icon +
                ", num_id=" + num_id +
                ", identity_id=" + identity_id +
                ", district_id='" + district_id + '\'' +
                '}';
    }
}
