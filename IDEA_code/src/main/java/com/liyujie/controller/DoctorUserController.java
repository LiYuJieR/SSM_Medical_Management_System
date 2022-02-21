package com.liyujie.controller;

import com.liyujie.entity.*;
import com.liyujie.service.*;
import com.liyujie.utils.VerifyCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@Controller
@RequestMapping("/Doctor")
public class DoctorUserController {
    @Autowired
    @Qualifier("doctorUserService")
    private DoctorUserService doctorUserService;
    @Autowired
    @Qualifier("departmentService")
    private DepartmentService departmentService;
    @Autowired
    @Qualifier("doctorGradeService")
    private DoctorGradeService doctorGradeService;
    @Autowired
    @Qualifier("registrationService")
    private RegistrationService registrationService;
    @Autowired
    @Qualifier("patientUserService")
    private PatientUserService patientUserService;
    @Autowired
    @Qualifier("medicalExaminationService")
    private MedicalExaminationService medicalExaminationService;
    @Autowired
    @Qualifier("examinationOrderService")
    private ExaminationOrderService examinationOrderService;
    @Autowired
    @Qualifier("messageService")
    private MessageService messageService;


    @RequestMapping("/Login")
    public String login() {
        return "/Doctor/Login";
    }


    @RequestMapping("/LoginValid")
    public String loginValid(HttpSession session, String account, String password, String verifyCode, HttpServletRequest request) {
        String trueCode = (String) request.getSession().getAttribute("TrueCode");
        if (!verifyCode.equalsIgnoreCase(trueCode)) {
            return "Doctor/status/VerifyCodeError";
        }
        try {
            int index = doctorUserService.valid(account, password);
            session.setAttribute("userLoginInfo", index);
            return "redirect:/Doctor/MainFrame/" + index;
        } catch (Exception e) {
            return "Doctor/Status/LoginFailed";
        }


    }

    @RequestMapping("/MainFrame/{id}")
    public String mainFrame(Model model, @PathVariable Integer id) {
        DoctorUser doctorUser = doctorUserService.queryDoctorById(id);
        String department = departmentService.queryDepartmentNameById(doctorUser.getDepartmentid());
        String grade = doctorGradeService.queryGradeNameById(doctorUser.getGradeid());
        model.addAttribute("DocUser", doctorUser);
        model.addAttribute("department", department);
        model.addAttribute("grade", grade);
        return "/Doctor/MainFrame";
    }

    @RequestMapping("/Registration/{Docid}")
    public String regisInfor(Model model, @PathVariable Integer Docid) {
        List<Registration> registrations = registrationService.queryRegistrationByDid(Docid);
        model.addAttribute("AllRegists", registrations);
        DoctorUser doctorUser = doctorUserService.queryDoctorById(Docid);
        model.addAttribute("doc", doctorUser);
        return "/Doctor/Registration";
    }

    @RequestMapping("/ToAddRegis/{Docid}")
    public String toAddRegis(Model model, @PathVariable Integer Docid) {
        model.addAttribute("Docid", Docid);
        return "/Doctor/ToAddRegis";
    }

    @RequestMapping("/AddRegis")
    public String addRegis(Integer Did, String day, String beginTime, String endTime) {
        registrationService.addRegistration(Did, day, beginTime, endTime);
        return "redirect:/Doctor/Registration/" + Did;
    }

    @RequestMapping("/DeleteRegis/{RegisId}/{DocId}")
    public String deleteRegis(@PathVariable Integer RegisId, @PathVariable Integer DocId) {
        registrationService.deleteRegistrationById(RegisId);
        return "redirect:/Doctor/Registration/" + DocId;
    }

    @RequestMapping("/RegisDetail/{RegisId}/{DocId}")
    public String regisDetail(Model model, @PathVariable Integer RegisId, @PathVariable Integer DocId) {
        Registration registration = registrationService.queryRegistrarionById(RegisId);
        PatientUser patientUser = patientUserService.queryPatientById(registration.getPid());
        model.addAttribute("regis", registration);
        model.addAttribute("patient", patientUser);
        if (patientUser.getGender() == Gender.Male)
            model.addAttribute("gender", "男");
        else model.addAttribute("gender", "女");
        return "/Doctor/RegisDetail";
    }

    @RequestMapping("/SelectPatient/{DocId}/{PatientId}")
    public String selectPatient(Model model, @PathVariable Integer DocId, @PathVariable Integer PatientId) {
        try {
            int index = patientUserService.updatePatientDoctorByDoctorId(DocId, PatientId);
            DoctorUser doctorUser = doctorUserService.queryDoctorById(DocId);
            messageService.push(PatientId, "你好，" + doctorUser.getUsername() + "医生将您设置为了祂的患者。");
            return "Doctor/Status/SelectPatientSuccess";
        } catch (Exception e) {
            model.addAttribute("DocId", DocId);
            return "Doctor/Status/SelectPatientFailed";
        }
    }

    @RequestMapping("/PatientList/{DocId}")
    public String patientList(Model model, @PathVariable Integer DocId) {
        List<PatientUser> patientUsers = patientUserService.queryPatientByDid(DocId);
        model.addAttribute("patients", patientUsers);
        DoctorUser doctorUser = doctorUserService.queryDoctorById(DocId);
        model.addAttribute("Doc", doctorUser);
        model.addAttribute("male", Gender.Male);
        return "/Doctor/PatientList";
    }

    @RequestMapping("/Diagnosis/{DocId}/{PatientId}")
    public String diagnosis(Model model, @PathVariable Integer DocId, @PathVariable Integer PatientId) {
        DoctorUser doctorUser = doctorUserService.queryDoctorById(DocId);
        PatientUser patientUser = patientUserService.queryPatientById(PatientId);
        List<MedicalExamination> medicalExaminations =
                medicalExaminationService.queryMedicalExaminationByDepartment(doctorUser.getDepartmentid());
        model.addAttribute("doctor", doctorUser);
        model.addAttribute("patient", patientUser);
        model.addAttribute("medicalExaminations", medicalExaminations);
        model.addAttribute("male", Gender.Male);
        return "/Doctor/Diagnosis";
    }

    @RequestMapping("/ReleaseBinding/{patientId}/{Docid}")
    public String releaseBinding(@PathVariable Integer patientId, @PathVariable Integer Docid) {
        PatientUser patientUser = patientUserService.queryPatientById(patientId);
        patientUser.setDid(null);
        System.out.println("new patient=>>>" + patientUser);
        patientUserService.updatePatient(patientUser);
        return "redirect:/Doctor/PatientList/" + Docid;
    }

    @RequestMapping("/AddOrderAndDetail/{DocId}/{PatientId}")
    public String addOrderAndDetail(@PathVariable Integer DocId, @PathVariable Integer PatientId,
                                    Integer[] exams, String patientDetail) {
        PatientUser patientUser = patientUserService.queryPatientById(PatientId);
        patientUser.setDetail(patientDetail);
        patientUserService.updatePatient(patientUser);
        for (Integer exam : exams) {
            examinationOrderService.addExaminationOrder(PatientId, DocId, exam);
        }
        DoctorUser doctorUser = doctorUserService.queryDoctorById(DocId);
        messageService.push(PatientId, "你好，" + doctorUser.getUsername() + "医生更新了您的项目以及病情描述。");
        return "redirect:/Doctor/PatientList/" + DocId;
    }

    @RequestMapping("/Message/{DocId}")
    public String message(@PathVariable Integer DocId, Model model) {
        List<String> msgs = messageService.getAll(DocId);
        Integer notReadMsg = msgs.size() - messageService.getReadNum(DocId);
        model.addAttribute("messages", msgs);
        model.addAttribute("notReadMsgNum", notReadMsg);
        messageService.setReadNumToAll(DocId);
        return "/Doctor/Message";
    }

    @RequestMapping("/Exit")
    public String exit(HttpSession session) {
        session.removeAttribute("userLoginInfo");
        return "redirect:/";
    }


}
