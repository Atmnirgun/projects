package com.ifast.controller;

import com.ifast.dto.*;
import com.ifast.entities.CompanyBean;
import com.ifast.entities.DepartmentBean;
import com.ifast.entities.StaffBean;
import com.ifast.services.CompanyService;
import com.ifast.services.DepartmentService;
import com.ifast.services.StaffService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.valueOf;

@Controller
public class MainController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private StaffService staffService;


    @RequestMapping(value = "/handle-company", method= RequestMethod.POST)
    public RedirectView addCompany(@ModelAttribute CompanyBean company, HttpServletRequest request ){
        companyService.addCompany(company);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath() + "/");
        return redirectView;
    }


    @RequestMapping(value = "/handle-department",method = RequestMethod.POST)
    public RedirectView addDepartment(@ModelAttribute DepartmentBean department, HttpServletRequest request){
        departmentService.addDepartment(department);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath()+"/department");
        return redirectView;
    }

    @RequestMapping(value = "/delete/{id}")
    public RedirectView deleteCompany(@PathVariable(name = "id")int id, HttpServletRequest request){

        companyService.deleteCompany(id);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath() + "/");
        return redirectView;
    }


    @RequestMapping(value = "/edit-company/{id}")
    public RedirectView updateCompany(@ModelAttribute CompanyBean company,@PathVariable(name = "id") int id,HttpServletRequest request){
        CompanyBean savedCompany = companyService.getCompany(id);
        savedCompany.setName(company.getName());
        savedCompany.setCountry(company.getCountry());
        savedCompany.setFoundation_date(company.getFoundation_date());
        companyService.addCompany(savedCompany);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath()+"/");
        return redirectView;
    }

    @RequestMapping(value = "/edit-department/{id}")
    public RedirectView updateDepartment(@ModelAttribute DepartmentBean department,@PathVariable(name = "id") int deptId,HttpServletRequest request){
        DepartmentBean savedDepartment = departmentService.getDepartment(deptId);
        savedDepartment.setName(department.getName());
        savedDepartment.setComp_id(department.getComp_id());
        departmentService.addDepartment(savedDepartment);

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath()+"/department");
        return redirectView;
    }

    @RequestMapping(value = "/handle-staff", method = RequestMethod.POST)
    public RedirectView addStaff(@ModelAttribute StaffBean staff, HttpServletRequest request){

        staffService.addStaff(staff);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath()+"/search");
        return redirectView;
    }

    @RequestMapping(value = "/edit-staff/{id}",method = RequestMethod.POST)
    public RedirectView updateStaff(@PathVariable(name = "id") int id,@ModelAttribute StaffBean staff, HttpServletRequest request){
        StaffBean savedStaff = staffService.getStaff(id);
        savedStaff.setName(staff.getName());
        savedStaff.setNric(staff.getNric());
        savedStaff.setDob(staff.getDob());
        savedStaff.setJoin_date(staff.getJoin_date());
        savedStaff.setSupervisor_id(staff.getSupervisor_id());
        savedStaff.setDept_id(staff.getDept_id());
        savedStaff.setTel_hp(staff.getTel_hp());
        staffService.addStaff(savedStaff);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath()+"/search");
        return redirectView;
    }

    @RequestMapping(value = "/staff-delete/{id}")
    public RedirectView deleteStaff(@PathVariable(name = "id") int id,HttpServletRequest request){
        staffService.deleteStaff(id);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath()+"/search");
        return redirectView;
    }

    @RequestMapping(value = "/dep-delete/{id}")
    public RedirectView deleteDepartment(@PathVariable(name = "id") int dep_id,HttpServletRequest request){
        departmentService.deleteDepartment(dep_id);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath() + "/department");
        return redirectView;
    }

    @RequestMapping(value = "/")
    public String company(Model model){
        List<CompanyBean> companies = companyService.findCompanyAll();
        model.addAttribute("companies",companies);
        return "company";
    }

    @RequestMapping(value = "/department")
    public String department(Model model){
        List<DepartmentDto> departments = departmentService.findDepWithCompName();
        List<CompanyBean> companies = companyService.findCompanyAll();
        model.addAttribute("companies",companies);
        model.addAttribute("departments",departments);
        return "departments";
    }

    @RequestMapping(value = "/search")
    public String staff(Model model){
        List<StaffDto> staffs =  staffService.findStaffByName();
        List<CompanyBean> companies = companyService.findCompanyAll();
        List<DepartmentBean> departments = departmentService.findDepartmentAll();
        model.addAttribute("staffs",staffs);
        model.addAttribute("companies",companies);
        model.addAttribute("departments",departments);
        return "staff";
    }

    @RequestMapping(value = "/api/department/{id}")
    public ResponseEntity getDepartment(@PathVariable(name = "id") int id){
        DepartmentBean savedDepartment = departmentService.getDepartment(id);
        ModelMapper modelMapper = new ModelMapper();
        DepartmentBeanDto departmentDto = modelMapper.map(savedDepartment, DepartmentBeanDto.class);
        return new ResponseEntity(departmentDto, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/company/{id}")
    public ResponseEntity getCompany(@PathVariable(name = "id") int id){
        CompanyBean savedCompany = companyService.getCompany(id);
        ModelMapper modelMapper = new ModelMapper();
        CompanyBeanDto companyBeanDto = modelMapper.map(savedCompany, CompanyBeanDto.class);
        return new ResponseEntity(companyBeanDto,HttpStatus.OK);
    }

    @RequestMapping(value = "/api/staff/{id}")
    public ResponseEntity getStaff(@PathVariable(name = "id") int id){
        StaffBean savedStaff = staffService.getStaff(id);
        ModelMapper modelMapper = new ModelMapper();
        StaffBeanDto staffBeanDto = modelMapper.map(savedStaff,StaffBeanDto.class);
        return new ResponseEntity(staffBeanDto,HttpStatus.OK);
    }

    @RequestMapping(value = "/api/company/department-list/{id}")
    public ResponseEntity findDepartmentByComapany(@PathVariable(name = "id") int id){
        List<DepartmentBean> departments = departmentService.findDepartmentByCompId(id);
        return new ResponseEntity(departments.size(),HttpStatus.OK);
    }

    @RequestMapping(value = "/api/company/department/staff-List/{id}")
    public ResponseEntity findStaffByDepartment(@PathVariable(name = "id") int id){
        System.out.println(id);
        List<StaffBean> staffs = staffService.findStaffByDeptId(id);
        return new ResponseEntity(staffs.size(),HttpStatus.OK);
    }

    @RequestMapping(value = "api/company/department/supervisor/{id}")
    public ResponseEntity findStaffBySupervisor(@PathVariable(name = "id") int id){
        List<StaffBean> staffList = staffService.findStaffBySupId(id);
        return new ResponseEntity(staffList.size(),HttpStatus.OK);
    }

    @RequestMapping(value = "api/department-by-company/{id}")
    public ResponseEntity findDepartmentByCompId(@PathVariable(name = "id")int id){
        List<DepartmentBean> departments = departmentService.findDepartmentByCompId(id);
        List<DepartmentBeanDto> departmentDtos = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for (DepartmentBean d: departments
             ) {
            DepartmentBeanDto dto = modelMapper.map(d, DepartmentBeanDto.class);
            departmentDtos.add(dto);
        }
        return new ResponseEntity(departmentDtos,HttpStatus.OK);
    }
}
