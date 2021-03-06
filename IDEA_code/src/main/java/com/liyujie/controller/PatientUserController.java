package com.liyujie.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.liyujie.entity.*;
import com.liyujie.service.*;
import com.liyujie.utils.AlipayConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/Patient")
public class PatientUserController {
    @Autowired
    @Qualifier("patientUserService")
    private PatientUserService patientUserService;

    @Autowired
    @Qualifier("registrationService")
    private RegistrationService registrationService;

    @Autowired
    @Qualifier("departmentService")
    private DepartmentService departmentService;

    @Autowired
    @Qualifier("doctorUserService")
    private DoctorUserService doctorUserService;

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
        return "/Patient/Login";
    }

    @RequestMapping("/LoginValid")
    public String loginValid(HttpSession session,String account, String password, String verifyCode, HttpServletRequest request) {
        String trueCode = (String) request.getSession().getAttribute("TrueCode");
        if (!verifyCode.equalsIgnoreCase(trueCode))
            return "Patient/status/VerifyCodeError";
        try {
            int index = patientUserService.valid(account, password);
            session.setAttribute("userLoginInfo",account);
            return "redirect:/Patient/MainFrame/" + index;
        }
        catch (Exception e){
            return "Patient/status/LoginFailed";
        }


    }

    @RequestMapping("/ToRegister")
    public String toRegister() {
        return "/Patient/ToRegister";
    }

    @RequestMapping("/Register")
    public String register(PatientUser patientUser, Integer Patientgender) {
        if (Patientgender == 0) patientUser.setGender(Gender.Male);
        else if (Patientgender == 1) patientUser.setGender(Gender.Female);
        try {
           int index =  patientUserService.addPatient(patientUser);
           return "redirect:/Patient/MainFrame/" + index;
        }
        catch (Exception e){
            return "Patient/status/RegisterFailed";
        }
    }

    @RequestMapping("/MainFrame/{Pid}")
    public String mainFrame(Model model, @PathVariable Integer Pid) {
        PatientUser patientUser = patientUserService.queryPatientById(Pid);
        model.addAttribute("patient", patientUser);
        return "/Patient/MainFrame";
    }

    @RequestMapping("/ToRegistration/{departmentid}/{patientId}")
    public String toRegistration(Model model, @PathVariable Integer departmentid, @PathVariable Integer patientId) {
        model.addAttribute("patientId", patientId);
        List<Registration> registrations = registrationService.queryRegistrationNotRegistedByDepartmentId(departmentid);
        model.addAttribute("registrations", registrations);
        List<Department> departments = departmentService.queryAllDepartments();
        model.addAttribute("departments", departments);
        List<DoctorUser> doctorUsers = doctorUserService.queryDoctorsByRegistration(registrations);
        model.addAttribute("doctorusers", doctorUsers);
        return "/Patient/ToRegistration";
    }

    /**
     * ????????????????????????controller??????
     *
     * @param departmentid ?????????????????????
     * @param patientId
     * @return
     */
    @RequestMapping("/RegistrationTrans/{patientId}")
    public String registrationTrans(Integer departmentid, @PathVariable Integer patientId) {
        return "redirect:/Patient/ToRegistration/" + departmentid + "/" + patientId;
    }

    /**
     * ???????????????????????????
     *
     * @return
     */
    @RequestMapping("/Regist/{registrationId}/{patientId}")
    public String regist(@PathVariable Integer registrationId, @PathVariable Integer patientId) {
        int index = registrationService.setPatientRegis(registrationId, patientId);
        PatientUser patientUser = patientUserService.queryPatientById(patientId);
        try{
            Registration registration = registrationService.queryRegistrarionById(registrationId);
            Integer DocId = registration.getDid();
            messageService.push(DocId, "???????????????" + patientUser.getName() + "????????????" + registration.getDay()
                    + "???" + registration.getBeginTime() + "???" + registration.getEndTime() + "?????????");
            return "redirect:/Patient/Status/RegistSuccess/" + patientId;
        }
        catch (Exception e){
            return "redirect:/Patient/Status/RegistFailed/" + patientId;
        }


    }

    @RequestMapping("/Status/RegistSuccess/{patientId}")
    public String registSuccess(Model model, @PathVariable Integer patientId) {
        model.addAttribute("Pid", patientId);
        return "Patient/status/RegistSuccess";
    }

    @RequestMapping("/Status/RegistFailed/{patientId}")
    public String registFailed(Model model, @PathVariable Integer patientId) {
        model.addAttribute("Pid", patientId);
        return "Patient/status/RegistFailed";
    }

    @RequestMapping("/RegistrationInfor/{patientId}")
    public String registrationInfor(Model model, @PathVariable Integer patientId) {
        List<Registration> registrations = registrationService.queryRegistrationByPid(patientId);
        model.addAttribute("registrations", registrations);
        model.addAttribute("patientId", patientId);
        List<DoctorUser> doctorUsers = doctorUserService.queryDoctorsByRegistration(registrations);
        model.addAttribute("doctorusers", doctorUsers);
        return "/Patient/RegistrationInfor";
    }

    @RequestMapping("/CancelRegist/{registrationId}/{patientId}")
    public String cancelRegist(Model model, @PathVariable Integer registrationId, @PathVariable Integer patientId) {
        registrationService.removePatientRegis(registrationId);

        PatientUser patientUser = patientUserService.queryPatientById(patientId);
        Registration registration = registrationService.queryRegistrarionById(registrationId);
        Integer DocId = registration.getDid();
        messageService.push(DocId, "???????????????" + patientUser.getName() + "???????????????" + registration.getDay()
                + "???" + registration.getBeginTime() + "???" + registration.getEndTime() + "?????????");

        model.addAttribute("Pid", patientId);
        return "Patient/status/CancelRegistSuccess";
    }

    @RequestMapping("/PersonalCenter/{PatientId}")
    public String personalCenter(Model model, @PathVariable Integer PatientId) {
        PatientUser patientUser = patientUserService.queryPatientById(PatientId);
        model.addAttribute("patient", patientUser);
        return "/Patient/PersonalCenter";
    }

    @RequestMapping("/SelfhelpPay/{PatientId}")
    public String selfhelpPay(Model model, @PathVariable Integer PatientId) {
        List<ExaminationOrder> examinationOrders = examinationOrderService.queryExaminationOrderByPIdNotPaid(PatientId);
        List<MedicalExamination> examinations = medicalExaminationService.queryMedicalExaminationByOrder(examinationOrders);
        model.addAttribute("examinations", examinations);
        Float totalCost = 0.0f;
        for (MedicalExamination examination : examinations) {
            totalCost += examination.getCost();
        }
        model.addAttribute("totalCost", totalCost);
        return "/Patient/SelfhelpPay";
    }

    @RequestMapping("/GoAlipay/{orderId}/{cost}")
    public String goAlipay(@PathVariable String orderId, @PathVariable String cost) {
        //??????????????????AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        //??????????????????
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        //?????????????????????????????????????????????????????????????????????
        String out_trade_no = orderId;
        //?????????????????????
        String total_amount = cost;
        //?????????????????????
        String subject = "????????????";

        // ?????????????????????????????????????????????????????????????????????????????????1m???15d???m-?????????h-?????????d-??????1c-?????????1c-??????????????????????????????????????????????????????0??????????????????????????????????????????????????? ??? 1.5h??????????????? 90m???
        String timeout_express = "1c";

        alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"timeout_express\":\"" + timeout_express + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //??????
        String result = null;
        try {
            result = alipayClient.pageExecute(alipayRequest).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        return result;
    }

    @RequestMapping("/SelfPage/{patientId}")
    public String selfPage(@PathVariable Integer patientId, Model model) {
        PatientUser patientUser = patientUserService.queryPatientById(patientId);
        model.addAttribute("patient", patientUser);
        return "/Patient/SelfPage";
    }

    @RequestMapping("/ToChangePhoneAndPassword/{patientId}")
    public String toChangePhoneAndPassword(@PathVariable Integer patientId,Model model) {
        PatientUser patientUser=patientUserService.queryPatientById(patientId);
        model.addAttribute("patient",patientUser);
        return "/Patient/ToChangePhoneAndPassword";
    }

    @RequestMapping("/ChangePhoneAndPassword/{patientId}")
    public String changePhoneAndPassword(@PathVariable Integer patientId, String password,
                                         String newPhone, String newPassword) {
        PatientUser patientUser = patientUserService.queryPatientById(patientId);
        try{
            int index = patientUserService.valid(patientUser.getPhone(), password);
            patientUser.setPassword(newPassword);
            patientUser.setPhone(newPhone);
            patientUserService.updatePatient(patientUser);
            return "/Patient/MainFrame";
        }
        catch (Exception e){
            return "redirect:/Patient/Status/RegistFailed/" + patientId;
        }

    }

    @RequestMapping("/Message/{patientId}")
    public String message(@PathVariable Integer patientId, Model model) {
        List<String> msgs = messageService.getAll(patientId);
        Integer notReadMsg = msgs.size() - messageService.getReadNum(patientId);
        model.addAttribute("messages", msgs);
        model.addAttribute("notReadMsgNum", notReadMsg);
        messageService.setReadNumToAll(patientId);
        return "/Patient/Message";
    }


    @RequestMapping("/Exit")
    public String exit(HttpSession session)
    {
        session.removeAttribute("userLoginInfo");
        return "redirect:/";
    }
}

