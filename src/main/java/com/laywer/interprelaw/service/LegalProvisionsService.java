package com.laywer.interprelaw.service;

import com.laywer.interprelaw.model.LegalProvisions;

import java.util.List;

public interface LegalProvisionsService {
    public LegalProvisions getLastLabel();

    public int insertLegal(LegalProvisions legalProvisions);

    public int updateLegal(LegalProvisions legalProvisions);
//
    public int deleteLegal(int id);

    public List<LegalProvisions> selectAll();

}
