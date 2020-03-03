package com.laywer.interprelaw.controller;


import com.laywer.interprelaw.service.MenuService;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;


@Controller
@RequestMapping(value = "/menu", method = RequestMethod.POST)
public class MenuController {

    private JSONArray treejson;
    @Resource
    private MenuService menuService;

//    @PostMapping(value = "/allMenu")
//    public List<MenuTree> getMenu(){
//        System.out.println(menuService.treeList());
//        return menuService.treeList();
//    }

    @PostMapping(value = "/allMenu")
    @ResponseBody
    public JSONArray getTree(){
        treejson = menuService.getTreeJson();
        System.out.println("返回结果："+treejson);
        return treejson;
    }

    public JSONArray getTreejson(){
        return treejson;
    }

    public void setTreejson(JSONArray treejson) {
        this.treejson = treejson;
    }
}
