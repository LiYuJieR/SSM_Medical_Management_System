package com.liyujie.controller;

import com.liyujie.utils.VerifyCodeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
@Controller
@RequestMapping("/Verify")
public class VerifyCodeController {
    @RequestMapping(value="Code", method = RequestMethod.GET)
    public void verifyCode(Model model, HttpServletRequest request, HttpServletResponse response) {
        try {
            OutputStream outputStream=response.getOutputStream();
            int w = 200, h = 80;
            String code = VerifyCodeUtils.generateVerifyCode(4);
            request.getSession().setAttribute("TrueCode",code);
            VerifyCodeUtils.outputImage(w, h, outputStream, code);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
