package com.epam.training.service.impl;

import com.epam.training.dao.SurveyDao;
import com.epam.training.dto.SurveyDataDto;
import com.epam.training.service.SurveyService;

import java.util.ArrayList;
import java.util.List;

public class SurveyServiceImpl implements SurveyService {

    private SurveyDao dao;

    public SurveyServiceImpl(SurveyDao dao) {
        this.dao = dao;
    }

    @Override
    public List<SurveyDataDto> retrieveAllSurveyData() {
        return dao.retrieveAllSurveyDataFromDataSource();
    }

    @Override
    public List<SurveyDataDto> retrieveSurveyDataFilteredByIndustryCode(String industryCode) {
        List<SurveyDataDto> all = dao.retrieveAllSurveyDataFromDataSource();

        List<SurveyDataDto> filtered = filterByIndustryCode(all, industryCode);

        return filtered;
    }

    private List<SurveyDataDto> filterByIndustryCode(List<SurveyDataDto> all, String industryCode) {
        List<SurveyDataDto> filtered = new ArrayList<>();

        for (SurveyDataDto data: all) {
            if(industryCode.equalsIgnoreCase(data.getIndustry_code())){
                filtered.add(data);
            }
        }

        return filtered;
    }
}
