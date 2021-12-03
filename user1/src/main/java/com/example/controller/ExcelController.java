package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
//@RequestMapping("/user1")
public class ExcelController {
    @GetMapping("/demo1")
    public String demo1(HttpServletRequest request, RedirectAttributes attributes) {
        if (checkCookie(request)) {
            return "success1";
        }
        attributes.addAttribute("gotoUrl", "redirect:http://192.168.183.1:8087/demo1");
        return "redirect:http://192.168.183.1:8088/user/index";
    }


    public static boolean checkCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("ssocookie") && cookie.getValue().equals("sso")) {
                    return true;
                }
            }
        }
        return false;
    }


    /*
     * 进入jsp页面
     */
    @RequestMapping("/index")
    public String html() {
        return "index";
    }
}
