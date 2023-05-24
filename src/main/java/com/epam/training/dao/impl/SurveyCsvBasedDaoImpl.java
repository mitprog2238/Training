package com.epam.training.dao.impl;

import com.epam.training.dao.SurveyDao;
import com.epam.training.dto.SurveyDataDto;
import com.epam.training.rowmapper.CustomStringToSurveyDataRowMapper;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SurveyCsvBasedDaoImpl implements SurveyDao {


//    path from repo root can be used for the case, you're running the app via entry point from the IDE
//    private static final String PATH_TO_DATA_SOURCE = "src/main/resources/csv/annual-enterprise-survey.csv";

    //absolute path should be used for the case, you're running compiled jar file.
    private static final String PATH_TO_DATA_SOURCE = "D:\\ITPU\\code\\Training\\src\\main\\resources\\csv\\annual-enterprise-survey.csv";


    @Override
    public List<SurveyDataDto> retrieveAllSurveyDataFromDataSource() {

        List<String[]> allData = fetchDataFromCsvFile();

        removeHeaderDataFromPureDataSet(allData);

        List<SurveyDataDto> sDataResulted = transformStringDataIntoDtoBasedCollection(allData);
        return sDataResulted;
    }

    private static List<String[]> fetchDataFromCsvFile() {
        FileReader filereader = null;
        try {
            filereader = new FileReader(PATH_TO_DATA_SOURCE);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        CSVParser parser = new CSVParserBuilder()/*.withSeparator(rawSeparator)*/.build();
        CSVReader csvReader = new CSVReaderBuilder(filereader)
                .withCSVParser(parser)
                .build();

        List<String[]> allData;
        try {
            allData = csvReader.readAll();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
        return allData;
    }

    private List<SurveyDataDto> transformStringDataIntoDtoBasedCollection(List<String[]> allData) {
        CustomStringToSurveyDataRowMapper rowMapper =new CustomStringToSurveyDataRowMapper();
        List<SurveyDataDto> result = new ArrayList<>();

//        for (String[] row : allData.subList(0,5)) {
        for (String[] row : allData) {
            SurveyDataDto sd = rowMapper.mapRaw(row);

            result.add(sd);
        }
         return result;
    }

    private void removeHeaderDataFromPureDataSet(List<String[]> allData) {
        allData.remove(0);
    }
}
