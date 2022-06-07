package com.ifast.dto;

public class DepartmentDto {

    private int dept_id;
    private String name;
    private String comp_name;

    public DepartmentDto(int dept_id, String name, String comp_name) {
        this.dept_id = dept_id;
        this.name = name;
        this.comp_name = comp_name;
    }

    public DepartmentDto() {
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

    public String getComp_name() {
        return comp_name;
    }

    public void setComp_name(String comp_name) {
        this.comp_name = comp_name;
    }
}
