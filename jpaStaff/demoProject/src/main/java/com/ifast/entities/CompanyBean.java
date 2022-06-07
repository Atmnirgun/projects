package com.ifast.entities;

import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "company")
public class CompanyBean implements Serializable {

    private static final long serialVersionUID = 281680511998811677L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int comp_id;

    private String name;

    private String country;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date foundation_date;


    public int getComp_id() {
        return comp_id;
    }

    public void setComp_id(int comp_id) {
        this.comp_id = comp_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getFoundation_date() {
        return foundation_date;
    }

    public void setFoundation_date(Date foundation_date) {
        this.foundation_date = foundation_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyBean that = (CompanyBean) o;
        return comp_id == that.comp_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(comp_id);
    }

    @Override
    public String toString() {
        return "CompanyBean{" +
                "comp_id=" + comp_id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", foundation_date=" + foundation_date +
                '}';
    }
}
