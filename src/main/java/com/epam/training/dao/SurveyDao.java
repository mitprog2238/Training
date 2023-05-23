package com.epam.training.dao;

import com.epam.training.dto.SurveyData;

import java.util.List;

/**
 * @author mitprog1
 *
 * Fetching all data from csv file
 *
 * */
public interface SurveyDao {

    List<SurveyData> retrieveAllSurveyDataFromDataSource();
}
