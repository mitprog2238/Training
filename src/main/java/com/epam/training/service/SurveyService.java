package com.epam.training.service;

import com.epam.training.dto.SurveyDataDto;

import java.util.List;
/**
 *
 * @author mitprog1
 *
 * manipulates/aggregates, then returns the final result set;
 *
 */
public interface SurveyService {

    /**
     * returns pure data set, which was fetched from the data source
     * */
    List<SurveyDataDto> retrieveAllSurveyData();

    /**
     * returns the data set, filtered by exact industryCode - value
     * */
    List<SurveyDataDto> retrieveSurveyDataFilteredByIndustryCode(String industryCode);
}
