package com.ifast.services;

import com.ifast.entities.StaffBean;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StaffService {
    public void createStaff(StaffBean staff);
    public List<StaffBean> getstaffs();
    public void deleteStaff(int id);
    public StaffBean getStaff(int id);
    public List<StaffBean> getStaffByDeptId(int id);
}
