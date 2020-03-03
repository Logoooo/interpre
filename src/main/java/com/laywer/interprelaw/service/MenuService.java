package com.laywer.interprelaw.service;


import com.laywer.interprelaw.model.MenuTree;
import net.sf.json.JSONArray;

import java.util.List;

public interface MenuService {
    public JSONArray getTreeJson();

    List<MenuTree> treeList();
}
