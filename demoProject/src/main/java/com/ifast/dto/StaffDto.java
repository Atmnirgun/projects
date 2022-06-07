package com.ifast.dto;

import java.util.Date;

public class StaffDto {

    private int Staff_id;
    private String name;
    private String nric;
    private String tel_hp;
    private String gender;
    private Date dob;
    private Date join_date;
    private String dept_name;
    private int comp_id;
    private String sup_name;

    public StaffDto(int staff_id, String name, String nric, String tel_hp, String gender, Date dob, Date join_date, String dept_name, int comp_id, String sup_name) {
        Staff_id = staff_id;
        this.name = name;
        this.nric = nric;
        this.tel_hp = tel_hp;
        this.gender = gender;
        this.dob = dob;
        this.join_date = join_date;
        this.dept_name = dept_name;
        this.comp_id = comp_id;
        this.sup_name = sup_name;
    }

    public int getComp_id(){
        return comp_id;
    }

    public void setComp_id(int comp_id){
        this.comp_id = comp_id;
    }
    public int getStaff_id() {
        return Staff_id;
    }

    public void setStaff_id(int staff_id) {
        Staff_id = staff_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNric() {
        return nric;
    }

    public void setNric(String nric) {
        this.nric = nric;
    }

    public String getTel_hp() {
        return tel_hp;
    }

    public void setTel_hp(String tel_hp) {
        this.tel_hp = tel_hp;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Date getJoin_date() {
        return join_date;
    }

    public void setJoin_date(Date join_date) {
        this.join_date = join_date;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public String getSup_name() {
        return sup_name;
    }

    public void setSup_name(String sup_name) {
        this.sup_name = sup_name;
    }
}
