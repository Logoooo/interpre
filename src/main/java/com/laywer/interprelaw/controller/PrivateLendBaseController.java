package com.laywer.interprelaw.controller;

import com.laywer.interprelaw.model.PrivateLendBase;
import com.laywer.interprelaw.service.PrivateLendBaseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/base", method = RequestMethod.POST)
public class PrivateLendBaseController {

    @Resource
    private PrivateLendBaseService privateLendBaseService;

    @PostMapping(value = "/insert")
    @ResponseBody
    public String insert(@ModelAttribute("privateLendBase")PrivateLendBase privateLendBase, Model model){
        System.out.println(privateLendBase.getWhetherrepay());
        System.out.println(privateLendBase.toString());
        privateLendBaseService.insertCase(privateLendBase);
        model.addAttribute("result","yes");
        return "success";
    }

    @PostMapping(value = "/delete")
    @ResponseBody
    public int delete(int caseId){
        return privateLendBaseService.deleteCase(caseId);
    }

    //没有解析出静态资源文件，所以这里报错
    @PostMapping(value = "/update")
    @ResponseBody
    public ModelAndView updateCase(@ModelAttribute("privateLendBase") PrivateLendBase privateLendBase,ModelAndView m){
        privateLendBaseService.update(privateLendBase);
        m.addObject("result","yes");
        m.setViewName("list");
        return m;
    }}
