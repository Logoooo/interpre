package com.laywer.interprelaw.service;

import com.laywer.interprelaw.model.PrivateLendBase;

import java.util.List;

public interface SimComService {
    //计算相似案例集
    public List<PrivateLendBase> similaritySet(double[] goal,double[][] history);

    //读取案例库数据
//    public double[][] readHistoryCase();
}
