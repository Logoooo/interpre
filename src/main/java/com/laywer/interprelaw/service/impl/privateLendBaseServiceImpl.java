package com.laywer.interprelaw.service.impl;

import com.laywer.interprelaw.mapper.PrivateLendBaseMapper;
import com.laywer.interprelaw.model.PrivateLendBase;
import com.laywer.interprelaw.service.PrivateLendBaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("privateLendBaseService")
public class privateLendBaseServiceImpl implements PrivateLendBaseService {
    @Resource
    private PrivateLendBaseMapper privateLendBaseMapper;

    @Override
    public int insertCase(PrivateLendBase privateLendBase) {
        return privateLendBaseMapper.insert(privateLendBase);
    }

    @Override
    public int deleteCase(int caseId) {
        return privateLendBaseMapper.deleteByPrimaryKey(caseId);
    }

    @Override
    public PrivateLendBase selectByCaseId(int caseId) {
        return privateLendBaseMapper.selectByPrimaryKey(caseId);
    }

    @Override
    public int update(PrivateLendBase privateLendBase) {
        return privateLendBaseMapper.updateByPrimaryKey(privateLendBase);
    }
}
