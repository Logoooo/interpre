package com.laywer.interprelaw.controller;

import com.laywer.interprelaw.model.Law;
import com.laywer.interprelaw.model.PrivateLendBase;
import com.laywer.interprelaw.service.LawService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/law",method= RequestMethod.POST)
public class LawController {

    @Resource
    private LawService lawService;

    @PostMapping(value = "/insert")
    @ResponseBody
    public String insert(@ModelAttribute("law")Law law, Model model){
        System.out.println(law.toString());
        lawService.insertLaw(law);
        model.addAttribute("result","yes");
        return "success";
    }
    //多表连接，尽量不要适用删除方法
    @PostMapping(value = "/delete")
    public int delete(int lawId){
        return lawService.deleteLaw(lawId);
    }


    //模板页不存在（报错），另外一种情况（使用th:include标签的时候才会出错，解决方法：使用模板引用文件的时候不用“/”打头）
    @PostMapping(value = "/update")
    @ResponseBody
    public ModelAndView update(@ModelAttribute("law")Law law,ModelAndView m){
        lawService.updateLaw(law);
        m.addObject("result","yes");
        m.setViewName("list");
        return m;
    }
}
