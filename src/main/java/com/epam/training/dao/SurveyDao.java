package com.epam.training.dao;

import com.epam.training.dto.SurveyDataDto;

import java.util.List;

/**
 * @author mitprog1
 *
 * Fetching all data from csv file
 *
 * */
public interface SurveyDao {

    List<SurveyDataDto> retrieveAllSurveyDataFromDataSource();
}
