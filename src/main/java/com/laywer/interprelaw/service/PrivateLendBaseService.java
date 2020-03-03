package com.laywer.interprelaw.service;

import com.laywer.interprelaw.model.PrivateLendBase;

import java.sql.ResultSet;
import java.util.List;

public interface PrivateLendBaseService {

    //案例库插入数据
    public int insertCase(PrivateLendBase privateLendBase);

    //案例库删除数据
    public int deleteCase(int caseId);

    //通过案例号查找数据
    public PrivateLendBase selectByCaseId(int caseId);

    //更新案例库数据
    public int update(PrivateLendBase privateLendBase);

    //查询案例库数据
    public List<PrivateLendBase> selectAllCase();
}
