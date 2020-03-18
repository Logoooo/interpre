package com.laywer.interprelaw.mapper;

import com.laywer.interprelaw.model.Law;
import com.laywer.interprelaw.model.LegalProvisions;
import com.laywer.interprelaw.model.LegalProvisionsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LegalProvisionsMapper {
    int countByExample(LegalProvisionsExample example);

    int deleteByExample(LegalProvisionsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LegalProvisions record);

    int insertSelective(LegalProvisions record);

    List<LegalProvisions> selectByExampleWithBLOBs(LegalProvisionsExample example);

    List<LegalProvisions> selectByExample(LegalProvisionsExample example);

    LegalProvisions selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LegalProvisions record, @Param("example") LegalProvisionsExample example);

    int updateByExampleWithBLOBs(@Param("record") LegalProvisions record, @Param("example") LegalProvisionsExample example);

    int updateByExample(@Param("record") LegalProvisions record, @Param("example") LegalProvisionsExample example);

    int updateByPrimaryKeySelective(LegalProvisions record);

    int updateByPrimaryKeyWithBLOBs(LegalProvisions record);

    int updateByPrimaryKey(LegalProvisions record);

    LegalProvisions getLastLabel();

    List<LegalProvisions> selectAll();
}