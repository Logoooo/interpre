package com.laywer.interprelaw.controller;

import com.laywer.interprelaw.model.User;
import com.laywer.interprelaw.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/user", method = RequestMethod.POST)
public class UserController {
    @Resource
    private IUserService userService;

    @PostMapping(value = "/register")
    @ResponseBody
    public String register(@ModelAttribute("user")User user, Model model){
        System.out.println(user.toString());
        userService.register(user);
        model.addAttribute("result","yes");
        return "success";
    }

    @PostMapping(value = "/update")
    @ResponseBody
    public ModelAndView updateUserInfo(@ModelAttribute("user") User user, ModelAndView m){
        userService.update(user);
        m.addObject("result","yes");
        m.setViewName("list");
        return m;
    }

    @PostMapping(value = "/info")
    public ModelAndView getUserInfo(HttpServletRequest request, ModelAndView m){
        User sessionUser=(User)request.getSession().getAttribute("user");
        User updateUser= userService.selectById(sessionUser.getuId());
        m.addObject("user",updateUser);
        return m;
    }

    @RequestMapping(value = "/addGroup")
    public ModelAndView addGroup(HttpServletRequest request, ModelAndView m){
        User sessionUser=(User)request.getSession().getAttribute("user");
        User updateUser= userService.selectById(sessionUser.getuId());
        m.addObject("user",updateUser);
        return m;
    }
    @RequestMapping(value = "/adminManager")
    public String adminManager(HttpServletRequest request, ModelAndView m){
        User sessionUser=(User)request.getSession().getAttribute("user");
        User updateUser= userService.selectById(sessionUser.getuId());
        m.addObject("user",updateUser);
        return "dataclean/adminManager";
    }
    @RequestMapping(value = "/user/abc",method = RequestMethod.GET)
    public String a(HttpServletRequest request, ModelAndView m){
        User sessionUser=(User)request.getSession().getAttribute("user");
        User updateUser= userService.selectById(sessionUser.getuId());
        m.addObject("user",updateUser);
        return "dropdown";
    }
}
