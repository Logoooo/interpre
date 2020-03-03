package com.laywer.interprelaw.mapper;

import com.laywer.interprelaw.model.PrivateLendBase;
import com.laywer.interprelaw.model.PrivateLendBaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PrivateLendBaseMapper {
    int countByExample(PrivateLendBaseExample example);

    int deleteByExample(PrivateLendBaseExample example);

    int deleteByPrimaryKey(Integer caseid);

    int insert(PrivateLendBase record);

    int insertSelective(PrivateLendBase record);

    List<PrivateLendBase> selectByExample(PrivateLendBaseExample example);

    PrivateLendBase selectByPrimaryKey(Integer caseid);

    int updateByExampleSelective(@Param("record") PrivateLendBase record, @Param("example") PrivateLendBaseExample example);

    int updateByExample(@Param("record") PrivateLendBase record, @Param("example") PrivateLendBaseExample example);

    int updateByPrimaryKeySelective(PrivateLendBase record);

    int updateByPrimaryKey(PrivateLendBase record);

    List<PrivateLendBase> selectAll();
}