package com.ifast.dao;

import com.ifast.entities.StaffBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffDao extends JpaRepository<StaffBean,Integer> {

    @Query(value = "SELECT * from staff s where s.dept_id=?1",nativeQuery = true)
    public List<StaffBean> findAllByDept_id(int id);

    @Query(value = "select s.staff_id,s.name,s.gender,s.nric,s.tel_hp,s.dob,s.join_date,d.name as dept_name,d.comp_id as comp_id,sd.name as sup_name from staff s inner join department d on s.dept_id=d.dept_id inner join staff sd on s.supervisor_id=sd.staff_id",nativeQuery = true)
    public List<Object[]> getAllByDepNameAndSupName();

    @Query(value = "SELECT * from staff where supervisor_id=?1",nativeQuery = true)
    public List<StaffBean> getStaffBeanBySupervisor_id(int id);
}
