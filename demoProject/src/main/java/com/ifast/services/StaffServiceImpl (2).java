package com.ifast.services;

import com.ifast.dao.StaffDao;
import com.ifast.dto.StaffDto;
import com.ifast.entities.StaffBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffDao staffDao;

    @Override
    public void addStaff(StaffBean staff) {
        staffDao.add(staff);
    }

    @Override
    public List<StaffBean> findStaffAll() {
        return staffDao.findAll();
    }

    @Override
    public void deleteStaff(int id) {
        staffDao.deleteById(id);
    }

    @Override
    public StaffBean getStaff(int id) {
        return staffDao.getById(id);
    }

    @Override
    public List<StaffBean> findStaffByDeptId(int id) {
        return staffDao.findAllByDept_id(id);
    }

    @Override
    public List<StaffDto> findStaffByName() {
        List<Object[]> staffList = staffDao.findAllByDepNameAndSupName();
        List<StaffDto> staffDtos = new ArrayList<>();
        for (Object[] o: staffList) {
            int staff_id = ((BigDecimal)o[0]).intValue();
            String name = (String)o[1];
            String gender = (String)o[2];
            String nric = (String)o[3];
            String tel_hp = (String)o[4];
            Date dob = (Date)o[5];
            Date join_date = (Date)o[6];
            String dept_name = (String)o[7];
            int comp_id = ((BigDecimal)o[8]).intValue();
            String sup_name = (String)o[9];
            StaffDto staffDto = new StaffDto(staff_id,name,nric,tel_hp,gender,dob,join_date,dept_name,comp_id,sup_name);
            staffDtos.add(staffDto);
        }
        return staffDtos;
    }

    @Override
    public List<StaffBean> findStaffBySupId(int id) {
        return staffDao.findAllStaffBySupervisor_id(id);
    }
}
