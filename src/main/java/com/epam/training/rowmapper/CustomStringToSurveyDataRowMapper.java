package com.epam.training.rowmapper;

import com.epam.training.dto.SurveyData;

/**
 * @author mitprog1
 *
 *  Transforms the single row fetched from the csv file
 *  into {@link SurveyData} object
 *
 * */
public class CustomStringToSurveyDataRowMapper {

    public SurveyData mapRaw(String[] row){
        SurveyData sd = new SurveyData();

        sd.setYear(row[0]);
        sd.setIndustry_code(row[1]);
        sd.setIndustry_name_ANZSIC(row[2]);
        sd.setRme_size_grp(row[3]);
        sd.setVariable(row[4]);
        sd.setValue(row[5]);
        sd.setUnit(row[6]);

        return sd;
    };
}
