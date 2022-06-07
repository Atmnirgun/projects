package com.ifast.services;

import com.ifast.dao.DepartmentDao;
import com.ifast.dto.DepartmentDto;
import com.ifast.entities.DepartmentBean;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public void createDepartment(DepartmentBean department) {
        departmentDao.save(department);
    }

    @Override
    public List<DepartmentBean> getDepartments() {
        return (List<DepartmentBean>) departmentDao.findAll();
    }

    @Override
    public void deleteDepartments(int id) {
        departmentDao.deleteById(id);
    }

    @Override
    public DepartmentBean getDepartment(int id) {
        return departmentDao.findById(id).get();
    }

    @Override
    public List<DepartmentBean> getDepartmetByCompId(int comp_id) {
        return departmentDao.findByComp_id(comp_id);
    }

    @Override
    public List<DepartmentDto> getDepWithCompName() {
        List<Object[]> depList = departmentDao.getDepartments();
        List<DepartmentDto> departmentDtos = new ArrayList<>();
        for (Object[] o: depList) {
            int dept_id = ((BigDecimal)o[0]).intValue();
            String name = (String)o[1];
            String comp_name = (String)o[2];
            DepartmentDto departmentDto = new DepartmentDto(dept_id,name,comp_name);
            departmentDtos.add(departmentDto);
        }
        return departmentDtos;
    }


}
