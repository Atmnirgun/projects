package com.ifast.services;

import com.ifast.dto.StaffDto;
import com.ifast.entities.StaffBean;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StaffService {
    public void addStaff(StaffBean staff);
    public List<StaffBean> findStaffAll();
    public void deleteStaff(int id);
    public StaffBean getStaff(int id);
    public List<StaffBean> findStaffByDeptId(int id);
    public List<StaffDto> findStaffByName();
    public List<StaffBean> findStaffBySupId(int id);
}
