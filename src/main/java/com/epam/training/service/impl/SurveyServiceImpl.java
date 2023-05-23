package com.epam.training.service.impl;

import com.epam.training.dao.SurveyDao;
import com.epam.training.dto.SurveyData;
import com.epam.training.service.SurveyService;

import java.util.ArrayList;
import java.util.List;

public class SurveyServiceImpl implements SurveyService {

    private SurveyDao dao;

    public SurveyServiceImpl(SurveyDao dao) {
        this.dao = dao;
    }

    @Override
    public List<SurveyData> retrieveAllSurveyData() {
        return dao.retrieveAllSurveyDataFromDataSource();
    }

    @Override
    public List<SurveyData> retrieveSurveyDataFilteredByIndustryCode(String industryCode) {
        List<SurveyData> all = dao.retrieveAllSurveyDataFromDataSource();

        List<SurveyData> filtered = filterByIndustryCode(all, industryCode);

        return filtered;
    }

    private List<SurveyData> filterByIndustryCode(List<SurveyData> all, String industryCode) {
        List<SurveyData> filtered = new ArrayList<>();

        for (SurveyData data: all) {
            if(industryCode.equalsIgnoreCase(data.getIndustry_code())){
                filtered.add(data);
            }
        }

        return filtered;
    }
}
