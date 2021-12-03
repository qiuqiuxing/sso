package com.example.controller;

import com.example.util.SSOCheck;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class ExcelController {


    /*
     * 进入jsp页面
     */
    @RequestMapping("/index")
    public String html(Map map, HttpServletRequest req) {
        String gotoUrl = req.getParameter("gotoUrl");
        HttpSession session = req.getSession();
        session.setAttribute("gotoUrl", gotoUrl);
        return "login";
    }

    @PostMapping("/login")
    public String log(String username, String password, String gotoUrl, HttpServletResponse response) {
        boolean ok = SSOCheck.checkLogin(username, password);
        if (ok) {
            Cookie cookie = new Cookie("ssocookie", "sso");
            cookie.setPath("/");
            response.addCookie(cookie);
            return gotoUrl;
        }
        return null;
    }


    @GetMapping("/demo1")
    public String demo1(HttpServletRequest request) {
        if (SSOCheck.checkCookie(request)) {
            return "success1";
        }
        request.getSession().setAttribute("gotoUrl", "success1");
        return "login";
    }

    @GetMapping("/demo2")
    public String demo2(HttpServletRequest request) {
        if (SSOCheck.checkCookie(request)) {
            return "success2";
        }
        request.getSession().setAttribute("gotoUrl", "success2");
        return "login";
    }

}
