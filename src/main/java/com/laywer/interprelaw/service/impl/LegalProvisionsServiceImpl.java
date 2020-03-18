package com.laywer.interprelaw.service.impl;

import com.laywer.interprelaw.mapper.LegalProvisionsMapper;
import com.laywer.interprelaw.model.LegalProvisions;
import com.laywer.interprelaw.service.LegalProvisionsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("lagallProvisionsService")
public class LegalProvisionsServiceImpl implements LegalProvisionsService{
    @Resource
    private LegalProvisionsMapper legalProvisionsMapper;

    @Override
    public LegalProvisions getLastLabel() {
        return legalProvisionsMapper.getLastLabel();
    }

    @Override
    public int insertLegal(LegalProvisions legalProvisions) {
        return legalProvisionsMapper.insert(legalProvisions);
    }

    @Override
    public int updateLegal(LegalProvisions legalProvisions) {
        return legalProvisionsMapper.updateByPrimaryKeySelective(legalProvisions);
    }

    @Override
    public int deleteLegal(int id) {
        return legalProvisionsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<LegalProvisions> selectAll() {
        return legalProvisionsMapper.selectAll();
    }
}
