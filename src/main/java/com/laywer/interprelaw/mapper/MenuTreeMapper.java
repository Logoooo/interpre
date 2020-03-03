package com.laywer.interprelaw.mapper;

import com.laywer.interprelaw.model.MenuTree;
import com.laywer.interprelaw.model.MenuTreeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MenuTreeMapper {
    int countByExample(MenuTreeExample example);

    int deleteByExample(MenuTreeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MenuTree record);

    int insertSelective(MenuTree record);

    List<MenuTree> selectByExample(MenuTreeExample example);

    MenuTree selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MenuTree record, @Param("example") MenuTreeExample example);

    int updateByExample(@Param("record") MenuTree record, @Param("example") MenuTreeExample example);

    int updateByPrimaryKeySelective(MenuTree record);

    int updateByPrimaryKey(MenuTree record);

    //查询最小的level
    Integer minId();

    //根据最小的查询所有的一级菜单
    List<MenuTree> getFirstLevel(Integer minlevel);

    //根据pid查询所有相对应的子集
    List<MenuTree> getNextSubSet(MenuTree menuTree);

    //递归查询
    List<MenuTree> getDeeptLevel(MenuTree menuTree);
}