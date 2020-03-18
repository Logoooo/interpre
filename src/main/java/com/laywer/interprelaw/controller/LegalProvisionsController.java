package com.laywer.interprelaw.controller;

import com.laywer.interprelaw.model.LegalProvisions;
import com.laywer.interprelaw.service.LegalProvisionsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/legal",method = RequestMethod.POST)
public class LegalProvisionsController {

    @Resource
    private LegalProvisionsService legalProvisionsService;

    //传过来的参数只有法律条文，标签自动补全
    @PostMapping(value = "/insert")
    @ResponseBody
    public String insert(@ModelAttribute("legalProvisions")LegalProvisions legalProvisions, Model model){
        String legal = legalProvisions.getLegalprovisions();
        System.out.println(legal);
        //查找最近一个法律条文的标签
        String labal = legalProvisionsService.getLastLabel().getLabel();
        int i;
        i = Integer.parseInt(labal);
        System.out.println(i);
        i++;
//        String.valueOf(i);
        legalProvisions.setLabel(String.valueOf(i));
        System.out.println(legalProvisions.toString());
        if (labal != null && legal != null){
            legalProvisionsService.insertLegal(legalProvisions);
            return "success";
        }else {
            return "fail";
        }
    }
    //删除法律条文和标签
    @PostMapping(value = "/delete")
    @ResponseBody
    public int delete(int id){
        int index;
        if (id > 0){
            index = legalProvisionsService.deleteLegal(id);
            return index;
        }else {
            return 0;
        }
    }

    //更新法律条文和标签信息
    @PostMapping(value = "/update")
    @ResponseBody
    public int update(@ModelAttribute("legalProvisions")LegalProvisions legalProvisions, Model model){
        String legal = legalProvisions.getLegalprovisions();
        String label = legalProvisions.getLabel();
        System.out.println(legalProvisions.toString());
        int index;
        if (label != null && legal != null){
            index = legalProvisionsService.updateLegal(legalProvisions);
            return index;
        }else {
            return 0;
        }
    }

    //查询所有
    @PostMapping(value = "/selectAll")
    @ResponseBody
    public List<LegalProvisions> selectAll(){
        List<LegalProvisions> list = new ArrayList<>();
        list = legalProvisionsService.selectAll();
        return list;
    }
}
