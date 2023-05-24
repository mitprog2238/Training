package com.epam.training.dao;

import com.epam.training.dto.SurveyDataDto;

import java.util.List;

/**
 * @author mitprog1
 *
 * Fetching all data from data source
 *
 * */
public interface SurveyDao {

    List<SurveyDataDto> retrieveAllSurveyDataFromDataSource();
}
