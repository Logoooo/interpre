package com.laywer.interprelaw.service;

import com.laywer.interprelaw.model.Law;

public interface LawService {
    public int insertLaw(Law law);

    public int deleteLaw(int lawId);

    public int updateLaw(Law law);
}
