package com.epam.training.dto;

import java.util.Objects;

public class SurveyDataDto {
//    year,industry_code_ANZSIC,industry_name_ANZSIC,rme_size_grp,variable,value,unit

    private String year;
    private String industry_code;
    private String industry_name_ANZSIC;
    private String rme_size_grp;
    private String variable;
    private String value;
    private String unit;


    public SurveyDataDto() {
    }
    public SurveyDataDto(String year, String industry_code, String industry_name_ANZSIC, String rme_size_grp, String variable, String value, String unit) {
        this.year = year;
        this.industry_code = industry_code;
        this.industry_name_ANZSIC = industry_name_ANZSIC;
        this.rme_size_grp = rme_size_grp;
        this.variable = variable;
        this.value = value;
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "SurveyDataRowMapper{" +
                "year='" + year + '\'' +
                ", industry_code='" + industry_code + '\'' +
                ", industry_name_ANZSIC='" + industry_name_ANZSIC + '\'' +
                ", rme_size_grp='" + rme_size_grp + '\'' +
                ", variable='" + variable + '\'' +
                ", value='" + value + '\'' +
                ", unit='" + unit + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SurveyDataDto)) return false;
        SurveyDataDto that = (SurveyDataDto) o;
        return Objects.equals(getYear(), that.getYear()) && Objects.equals(getIndustry_code(), that.getIndustry_code()) && Objects.equals(getIndustry_name_ANZSIC(), that.getIndustry_name_ANZSIC()) && Objects.equals(getRme_size_grp(), that.getRme_size_grp()) && Objects.equals(getVariable(), that.getVariable()) && Objects.equals(getValue(), that.getValue()) && Objects.equals(getUnit(), that.getUnit());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getYear(), getIndustry_code(), getIndustry_name_ANZSIC(), getRme_size_grp(), getVariable(), getValue(), getUnit());
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getIndustry_code() {
        return industry_code;
    }

    public void setIndustry_code(String industry_code) {
        this.industry_code = industry_code;
    }

    public String getIndustry_name_ANZSIC() {
        return industry_name_ANZSIC;
    }

    public void setIndustry_name_ANZSIC(String industry_name_ANZSIC) {
        this.industry_name_ANZSIC = industry_name_ANZSIC;
    }

    public String getRme_size_grp() {
        return rme_size_grp;
    }

    public void setRme_size_grp(String rme_size_grp) {
        this.rme_size_grp = rme_size_grp;
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
