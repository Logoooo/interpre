package com.laywer.interprelaw.mapper;

import com.laywer.interprelaw.model.Law;
import com.laywer.interprelaw.model.LawExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LawMapper {
    int countByExample(LawExample example);

    int deleteByExample(LawExample example);

    int deleteByPrimaryKey(Integer lawid);

    int insert(Law record);

    int insertSelective(Law record);

    List<Law> selectByExampleWithBLOBs(LawExample example);

    List<Law> selectByExample(LawExample example);

    Law selectByPrimaryKey(Integer lawid);

    Law selectByCaseId(Integer caseId);

    int updateByExampleSelective(@Param("record") Law record, @Param("example") LawExample example);

    int updateByExampleWithBLOBs(@Param("record") Law record, @Param("example") LawExample example);

    int updateByExample(@Param("record") Law record, @Param("example") LawExample example);

    int updateByPrimaryKeySelective(Law record);

    int updateByPrimaryKeyWithBLOBs(Law record);

    int updateByPrimaryKey(Law record);
}