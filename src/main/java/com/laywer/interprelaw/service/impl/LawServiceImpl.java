package com.laywer.interprelaw.service.impl;

import com.laywer.interprelaw.mapper.LawMapper;
import com.laywer.interprelaw.model.Law;
import com.laywer.interprelaw.service.LawService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("lawService")
public class LawServiceImpl implements LawService {
    @Resource
    private LawMapper lawMapper;

    @Override
    public int insertLaw(Law law) {
        return lawMapper.insert(law);
    }

    @Override
    public int deleteLaw(int lawId) {
        return lawMapper.deleteByPrimaryKey(lawId);
    }

    @Override
    public int updateLaw(Law law) {
        return lawMapper.updateByPrimaryKey(law);
    }
}
