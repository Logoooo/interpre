package com.laywer.interprelaw.service.impl;

import com.laywer.interprelaw.mapper.MenuTreeMapper;
import com.laywer.interprelaw.model.MenuTree;
import com.laywer.interprelaw.service.MenuService;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("menuService")
public class MenuServiceImpl implements MenuService {

    @Resource
    MenuTreeMapper menuMapper;

    @Override
    public JSONArray getTreeJson() {

        Map<String, Object> treeMap = new HashMap<String, Object>();
        Map<String, Object> treejsonMap = new HashMap<String,Object>();
        treeMap.put("id",0);
        treeMap.put("authName", "功能菜单");
        treeMap.put("children",treeList());
        treeMap.put("level",0);
        treeMap.put("path","manager");
        JSONArray jsonObject = JSONArray.fromObject(treeMap);

        return jsonObject;
    }

    @Override
    public List<MenuTree> treeList() {
        List<MenuTree> nextSubSet = new ArrayList<MenuTree>();
        List<MenuTree> ts = new ArrayList<MenuTree>();
        //最小的level
        Integer minlevel = menuMapper.minId();
        System.out.println("最小等级："+minlevel);
        //一级目录
        List<MenuTree> friList = menuMapper.getFirstLevel(1);

        for (MenuTree menuTree : friList){
            System.out.println("一级目录:"+menuTree.getAuthname());
            //根据一级目录查找所有的子集

            System.out.println(menuTree.toString());
            nextSubSet = menuMapper.getNextSubSet(menuTree);
            menuTree.setChildren(nextSubSet);
//            ts.add(menuTree);
//            System.out.println("二级："+menuTree.getChildren());
//            System.out.println(menuTree.toString());
//            ts.add(menuTree);
            //遍历二级目录的集合
            for (MenuTree menuTree1 : nextSubSet){
                List<MenuTree> ts2 = getDeeptLevel(menuTree1);
                //将下面的子集都依次递归起来
                menuTree1.setChildren(ts2);
//                ts.add(menuTree1);
            }
            ts.add(menuTree);

        }
        return ts;
    }

    //递归查询
    public List<MenuTree> getDeeptLevel(MenuTree menuTree){
        List<MenuTree> tslevel = menuMapper.getNextSubSet(menuTree);
        if (tslevel.size()>0){
            for (int i=0;i<tslevel.size();i++){
                getDeeptLevel(tslevel.get(i));
            }
        }
        return tslevel;
    }
}
