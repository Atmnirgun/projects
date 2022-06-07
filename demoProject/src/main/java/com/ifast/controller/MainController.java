package com.ifast.controller;

import com.ifast.entities.CompanyBean;
import com.ifast.entities.DepartmentBean;
import com.ifast.entities.StaffBean;
import com.ifast.services.CompanyService;
import com.ifast.services.DepartmentService;
import com.ifast.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private StaffService staffService;

    @RequestMapping("/")
    public String home(Model model){
        List<CompanyBean> companies = companyService.getCompanies();
        model.addAttribute("companies",companies);
        model.addAttribute("company",null);
        return "home";
    }

    @RequestMapping("/add-company")
    public String addCompany(Model model){
        model.addAttribute("title","Add-product");
        return "add-company";
    }

    @RequestMapping("company/staff")
    public String addStaff(@RequestParam(name = "comp_id") int comp_id,@RequestParam(name = "deptId") int deptId, Model model){
        model.addAttribute("title","Add-staff");
        model.addAttribute("deptId",deptId);
        model.addAttribute("comp_id",comp_id);
        return "add-staff";
    }


    @RequestMapping("/company/add-department")
    public String addDepartment(@RequestParam(value = "comp_id") String comp_id, Model model){
        System.out.println(comp_id);
        model.addAttribute("title","Add-department");
        model.addAttribute("comp_id",comp_id);
        return "add-department";
    }


    @RequestMapping(value = "/handle-company", method= RequestMethod.POST)
    public RedirectView handleCompany(@ModelAttribute CompanyBean company, HttpServletRequest request ){
        System.out.println("post called");
        System.out.println(company.getFoundation_date());
        companyService.createCompany(company);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath() + "/");
        return redirectView;
    }


    @RequestMapping(value = "/company/{id}")
    public String openCompany(@PathVariable(name = "id") int id,Model model){
        CompanyBean savedCompany = companyService.getCompany(id);
        List<DepartmentBean> departments = departmentService.getDepartmetByCompId(id);
        Map<Integer,List<StaffBean>> staffMap = new HashMap<>();
        for (DepartmentBean d : departments
             ) {
            List<StaffBean> staff = staffService.getStaffByDeptId(d.getDept_id());
            staffMap.put(d.getDept_id(),staff);
        }
        System.out.println(staffMap);
        model.addAttribute("company",savedCompany);
        model.addAttribute("departments",departments);
        model.addAttribute("staffMap",staffMap);
        return "home";
    }

    @RequestMapping(value = "/company/handle-department",method = RequestMethod.POST)
    public RedirectView handleDepartment(@RequestParam(value = "comp_id") String comp_id,@ModelAttribute DepartmentBean department, HttpServletRequest request){
        department.setComp_id(Integer.parseInt(comp_id));
        departmentService.createDepartment(department);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath()+"/");
        return redirectView;
    }

    @RequestMapping(value = "/company/delete/{id}")
    public RedirectView deleteCompany(@PathVariable(name = "id")int id, HttpServletRequest request){
        companyService.deleteCompany(id);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath() + "/");
        return redirectView;
    }

    @RequestMapping(value = "/company/edit/{id}")
    public String editCompany(@PathVariable(name = "id") int id,Model model){
        CompanyBean savedCompany = companyService.getCompany(id);
        model.addAttribute("company",savedCompany);
        return "edit-company";
    }

    @RequestMapping(value = "company/edit/edit-company")
    public RedirectView editCompanyDetails(@ModelAttribute CompanyBean company,@RequestParam(name = "comp_id") int comp_id,HttpServletRequest request){
        CompanyBean savedCompany = companyService.getCompany(comp_id);
        savedCompany.setName(company.getName());
        savedCompany.setCountry(company.getCountry());
        companyService.createCompany(savedCompany);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath()+"/company/"+comp_id);
        return redirectView;
    }
    @RequestMapping(value = "/company/edit-department/{id}")
    public String editDepartment(@PathVariable(name = "id") int id,Model model) {
        DepartmentBean department = departmentService.getDepartment(id);
        model.addAttribute("department",department);
        return "edit-department";
    }

    @RequestMapping(value = "/company/edit-department/edit-department")
    public RedirectView handleEditDepartment(@ModelAttribute DepartmentBean department,@RequestParam(name = "deptId") int deptId,HttpServletRequest request){
        DepartmentBean savedDepartment = departmentService.getDepartment(deptId);
        savedDepartment.setName(department.getName());
        departmentService.createDepartment(savedDepartment);

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath()+"/company/"+savedDepartment.getComp_id());
        return redirectView;
    }

    @RequestMapping(value = "/company/handle-staff", method = RequestMethod.POST)
    public RedirectView handleStaff(@ModelAttribute StaffBean staff,@RequestParam(name = "deptId") int deptId,@RequestParam(name="comp_id") int comp_id, HttpServletRequest request){
        staff.setDept_id(deptId);
        //System.out.println(staff.getName());
        staffService.createStaff(staff);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath()+"/company/"+comp_id);
        return redirectView;
    }

    @RequestMapping(value = "/company/edit-staff/{id}")
    public String editStaff(@PathVariable(value = "id")int id,@RequestParam(name = "comp_id") int comp_id, Model model){
        StaffBean staff = staffService.getStaff(id);
        model.addAttribute("staff",staff);
        model.addAttribute("comp_id",comp_id);
        return "edit-staff";
    }
    @RequestMapping(value = "/company/edit-staff/edit",method = RequestMethod.POST)
    public RedirectView handaleEditStaff(@RequestParam(name = "comp_id") int comp_id, @RequestParam(name = "staff_id") int staff_id,@ModelAttribute StaffBean staff, HttpServletRequest request){
        StaffBean savedStaff = staffService.getStaff(staff_id);
        savedStaff.setName(staff.getName());
        savedStaff.setNric(staff.getNric());
        savedStaff.setDob(staff.getDob());
        savedStaff.setJoin_date(staff.getJoin_date());
        savedStaff.setSupervisor_id(staff.getSupervisor_id());
        staffService.createStaff(savedStaff);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath()+"/company/" + comp_id);
        return redirectView;
    }

    @RequestMapping(value = "/company/delete-staff/{id}")
    public RedirectView deleteStaff(@PathVariable(name = "id") int id,@RequestParam(name = "comp_id")int comp_id,HttpServletRequest request){

        staffService.deleteStaff(id);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath()+"/company/"+comp_id);
        return redirectView;
    }

    @RequestMapping(value = "/company/delete-department/{id}")
    public RedirectView deleteDepartment(@PathVariable(name = "id") int dep_id,@RequestParam(name = "comp_id") int comp_id,HttpServletRequest request){
        departmentService.deleteDepartments(dep_id);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath() + "/company/" + comp_id);
        return redirectView;
    }

    @RequestMapping(value = "/index")
    public String index(Model model){
        List<CompanyBean> companies = companyService.getCompanies();
        model.addAttribute("companies",companies);
        return "index";
    }

    @RequestMapping(value = "/department")
    public String department(Model model){
        List<DepartmentBean> departments = departmentService.getDepartments();
        model.addAttribute("departments",departments);
        return "departments";
    }

    @RequestMapping(value = "/search")
    public String search(Model model){
        List<StaffBean> staffs =  staffService.getstaffs();
        model.addAttribute("staffs",staffs);
        return "search";
    }
}
