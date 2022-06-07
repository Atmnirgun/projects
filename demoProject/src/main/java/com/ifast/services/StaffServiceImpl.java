package com.ifast.services;

import com.ifast.dao.StaffDao;
import com.ifast.entities.StaffBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffDao staffDao;

    @Override
    public void createStaff(StaffBean staff) {
        staffDao.save(staff);
    }

    @Override
    public List<StaffBean> getstaffs() {
        return (List<StaffBean>) staffDao.findAll();
    }

    @Override
    public void deleteStaff(int id) {
         StaffBean savedStaff = getStaff(id);
        staffDao.delete(savedStaff);
    }

    @Override
    public StaffBean getStaff(int id) {
        return staffDao.findById(id).get();
    }

    @Override
    public List<StaffBean> getStaffByDeptId(int id) {
        return staffDao.findAllByDept_id(id);
    }
}
