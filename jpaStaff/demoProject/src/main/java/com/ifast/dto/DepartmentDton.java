package com.ifast.dto;

public class DepartmentDton {

    private int dept_id;
    private String name;
    private int comp_id;

    public DepartmentDton(int dept_id, String name, int comp_id) {
        this.dept_id = dept_id;
        this.name = name;
        this.comp_id = comp_id;
    }

    public DepartmentDton() {
    }

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
}
