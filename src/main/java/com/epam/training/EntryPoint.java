package com.epam.training;

import com.epam.training.dao.SurveyDao;
import com.epam.training.dao.impl.SurveyDaoImpl;
import com.epam.training.dto.SurveyDataDto;
import com.epam.training.service.SurveyService;
import com.epam.training.service.impl.SurveyServiceImpl;

import java.util.List;

/**
 *
 * @author mitprog1
 *
 * This is entry point into the following feature:
 * The feature reads data from the csv file located in resource-folder.
 * printed result is based on an input param, which means a need of filtering
 * the result set by a particular business attribute value.
 * The feature design bases on the following arcitecture:
 * in the core of it - {@link SurveyDao},
 * describing fetching all data from the data source (csv-file in our case);
 * {@link SurveyService}, manipulates/aggregates, then returns the final result set
 *
 * */
public class EntryPoint {

    public static void main(String[] args) {
        SurveyDao dao = new SurveyDaoImpl();
        SurveyService service = new SurveyServiceImpl(dao);

        if (args.length == 0){
            System.out.println("There were no filtering params.");

            printAllDataFromTheFile(service);
        } else {
            String filteringParam = fetchFilteringParam(args);
            System.out.println("Industry code for filtering is "+ filteringParam);

            printFilteredDataByIndustryCode(service, filteringParam);
        }

    }

    private static String fetchFilteringParam(String[] args) {
        String filteringParam = String.valueOf(args[0]);
        return filteringParam;
    }

    private static void printFilteredDataByIndustryCode(SurveyService service, String filteringParam) {
        List<SurveyDataDto> surveyData = service.retrieveSurveyDataFilteredByIndustryCode(filteringParam);

        for (SurveyDataDto sdItem : surveyData) {
            System.out.println(sdItem);
        }
    }

    private static void printAllDataFromTheFile(SurveyService service) {
        List<SurveyDataDto> surveyData = service.retrieveAllSurveyData();

        for (SurveyDataDto sdItem : surveyData) {
            System.out.println(sdItem);
        }
    }
}
