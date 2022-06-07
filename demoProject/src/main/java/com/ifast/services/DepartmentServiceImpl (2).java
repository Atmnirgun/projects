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
    public void addDepartment(DepartmentBean department) {
        departmentDao.add(department);
    }

    @Override
    public List<DepartmentBean> findDepartmentAll() {
        return departmentDao.findAll();
    }

    @Override
    public void deleteDepartment(int id) {
        departmentDao.deleteById(id);
    }

    @Override
    public DepartmentBean getDepartment(int id) {
        return departmentDao.getById(id);
    }

    @Override
    public List<DepartmentBean> findDepartmentByCompId(int comp_id) {
        return departmentDao.findAllByComp_id(comp_id);
    }

    @Override
    public List<DepartmentDto> findDepWithCompName() {
        List<Object[]> depList = departmentDao.findAllDepartments();
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
