package com.gaofei.dto;

/**
 * Created by GaoQingming on 2018/3/1 0001.
 */
public class PersonDetailDTO {
    private long id;
    private String name;
    private String ctfId;
    private String gender;
    private String birthday;
    private String address;
    private String mobile;
    private String tel;
    private String eMail;
    private String company;
    private int provinceId;
    private int districtId;

    public int getProvinceId() {
        return provinceId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setProvinceId(int provinceId) {
        if (provinceId > 99) {
            this.provinceId = 0;
            return;
        }
        this.provinceId = provinceId;
    }

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        if (districtId > 999999) {
            this.districtId = 0;
            return;
        }
        this.districtId = districtId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCtfId() {
        return ctfId;
    }

    public void setCtfId(String ctfId) {
        this.ctfId = ctfId;
    }

    @Override
    public String toString() {
        return "PersonDetailDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ctfId='" + ctfId + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday='" + birthday + '\'' +
                ", address='" + address + '\'' +
                ", mobile='" + mobile + '\'' +
                ", tel='" + tel + '\'' +
                ", eMail='" + eMail + '\'' +
                ", company='" + company + '\'' +
                ", provinceId=" + provinceId +
                ", districtId=" + districtId +
                '}';
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (gender != null && gender.length() > 1) {
            this.gender = "";
            return;
        }
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
