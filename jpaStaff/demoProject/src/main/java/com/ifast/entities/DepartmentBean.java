package com.ifast.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "department")
public class DepartmentBean implements Serializable {

    private static final long serialVersionUID = -6565675220385551249L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int dept_id;

    private String name;

    private int comp_id;

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getComp_id() {
        return comp_id;
    }

    public void setComp_id(int comp_id) {
        this.comp_id = comp_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentBean that = (DepartmentBean) o;
        return dept_id == that.dept_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dept_id);
    }

    @Override
    public String toString() {
        return "DepartmentBean{" +
                "dept_id=" + dept_id +
                ", name='" + name + '\'' +
                ", comp_id=" + comp_id +
                '}';
    }
}
