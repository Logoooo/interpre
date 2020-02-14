package com.laywer.interprelaw.controller;

import com.laywer.interprelaw.model.User;
import com.laywer.interprelaw.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static java.lang.System.out;

@Controller
@RequestMapping(value = "/user", method = RequestMethod.POST)
public class LoginController {
    @Resource
    private IUserService userservice;

    @PostMapping("/login")
    public void login(String username, String password, HttpServletRequest request, HttpServletResponse response){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        User checkedUser = this.userservice.checkUser(user);
        if (checkedUser == null){
            out.print("no");
        }else {
            //登陆成功
            request.getSession().setAttribute("user",checkedUser);
            out.print("yes");
        }
        out.flush();
        out.close();
    }


}
