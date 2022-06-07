package com.ifast.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "staff")
public class StaffBean implements Serializable {

    private static final long serialVersionUID = -536653779370341312L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int staff_id;

    private String name;

    private String nric;

    private String gender;

    private String tel_hp;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date join_date;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date dob;

    @Column(nullable = true)
    private int supervisor_id;

    private int dept_id;

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTel_hp() {
        return tel_hp;
    }

    public void setTel_hp(String tel_hp) {
        this.tel_hp = tel_hp;
    }

    public Date getJoin_date() {
        return join_date;
    }

    public void setJoin_date(Date join_date) {
        this.join_date = join_date;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getSupervisor_id() {
        return supervisor_id;
    }

    public void setSupervisor_id(int supervisor_id) {
        this.supervisor_id = supervisor_id;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaffBean staff = (StaffBean) o;
        return staff_id == staff.staff_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(staff_id);
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staff_id=" + staff_id +
                ", name='" + name + '\'' +
                ", nric='" + nric + '\'' +
                ", gender='" + gender + '\'' +
                ", tel_hp='" + tel_hp + '\'' +
                ", join_date=" + join_date +
                ", dob=" + dob +
                ", supervisor_id=" + supervisor_id +
                ", dept_id=" + dept_id +
                '}';
    }
}
