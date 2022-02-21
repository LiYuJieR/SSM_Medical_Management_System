package com.liyujie.controller;

import com.liyujie.entity.AdminUser;
import com.liyujie.entity.Department;
import com.liyujie.entity.DoctorGrade;
import com.liyujie.entity.DoctorUser;
import com.liyujie.service.AdminUserService;
import com.liyujie.service.DepartmentService;
import com.liyujie.service.DoctorGradeService;
import com.liyujie.service.DoctorUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/Admin")
public class AdminUserController {
    @Autowired
    @Qualifier("adminUserService")
    private AdminUserService adminUserService;
    @Autowired
    @Qualifier("doctorUserService")
    private DoctorUserService doctorUserService;
    @Autowired
    @Qualifier("departmentService")
    private DepartmentService departmentService;
    @Autowired
    @Qualifier("doctorGradeService")
    private DoctorGradeService doctorGradeService;

    @RequestMapping("/Login")
    public String login() {
        return "Admin/Login";
    }

    @RequestMapping("/LoginValid")
    public String loginValid(HttpSession session,AdminUser user) {
        try{
            adminUserService.validate(user);
            session.setAttribute("userLoginInfo",user.getId());
            return "redirect:/Admin/MainFrame";

        }
        catch (Exception e){
            return "redirect:/Admin/LoginFailed";
        }

    }
    @RequestMapping("/LoginFailed")
    public String loginFailed(Model model)
    {
        return "/Admin/LoginFailed";
    }

    public void loadResources(Model model) {
        List<DoctorUser> doctorUsers = doctorUserService.queryAllDoctors();
        List<String> departments = doctorUserService.queryAllDepartmentName();
        List<String> grades = doctorUserService.queryAllGradeName();
        model.addAttribute("doctorlist", doctorUsers);
        model.addAttribute("departmentlist", departments);
        model.addAttribute("gradelist", grades);

    }

    @RequestMapping("/MainFrame")
    public String mainFrame(Model model) {
        loadResources(model);
        return "Admin/MainFrame";
    }

    @RequestMapping("/ToAddDoctor")
    public String toAddDoctor(Model model) {
        List<Department> departments = departmentService.queryAllDepartments();
        model.addAttribute("departmentList", departments);
        List<DoctorGrade> grades = doctorGradeService.queryAllGrades();
        model.addAttribute("gradeList", grades);
        return "Admin/ToAddDoctor";
    }

    @RequestMapping("/AddDoctor")
    public String addDoctor(Model model,DoctorUser doctorUser) {
        int isSuccess = doctorUserService.addDoctorUser(doctorUser);
        if(isSuccess==-1){
            return "redirect:/Admin/AddDoctorFailed";
        }
        return "redirect:/Admin/MainFrame";
    }
    @RequestMapping("/AddDoctorFailed")
    public String addDoctorFailed()
    {
        return "Admin/AddDoctorFailed";
    }

    @RequestMapping("/DeleteDoctor/{id}")
    public String deleteDoctor(@PathVariable Integer id) {
        doctorUserService.removeDoctorUserById(id);
        return "redirect:/Admin/MainFrame";
    }

    @RequestMapping("/ToUpdateDoctor/{id}")
    public String toUpdateDoctor(Model model, @PathVariable Integer id) {
        model.addAttribute("updateid", id);
        DoctorUser doctorUser = doctorUserService.queryDoctorById(id);
        model.addAttribute("updateUser", doctorUser);
        List<Department> departments = departmentService.queryAllDepartments();
        model.addAttribute("departmentList", departments);
        List<DoctorGrade> grades = doctorGradeService.queryAllGrades();
        model.addAttribute("gradeList", grades);
        return "Admin/ToUpdateDoctor";
    }

    @RequestMapping("/UpdateDoctor/{id}")
    public String updateDoctor(DoctorUser doctorUser, @PathVariable Integer id) {
        doctorUser.setIddoctoruser(id);
        doctorUserService.updateDoctor(doctorUser);
        return "redirect:/Admin/MainFrame";
    }

    @RequestMapping("/Exit")
    public String exit(HttpSession session)
    {
        session.removeAttribute("userLoginInfo");
        return "redirect:/";
    }

}
