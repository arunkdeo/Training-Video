package com.omniscient.learning.stateservice.model;

import java.util.Arrays;
import java.util.List;

public class State {
    private String stateCode;
    private String stateName;
    private String stateCapital;
    private List<String> majorCities;

    public State(){
    }
    public State(String stateCode, String stateName, String stateCapital, String... majorCities) {
        this();
        this.stateCode = stateCode;
        this.stateName = stateName;
        this.stateCapital = stateCapital;
        this.majorCities = Arrays.asList(majorCities);
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getStateCapital() {
        return stateCapital;
    }

    public void setStateCapital(String stateCapital) {
        this.stateCapital = stateCapital;
    }

    public List<String> getMajorCities() {
        return majorCities;
    }

    public void setMajorCities(List<String> majorCities) {
        this.majorCities = majorCities;
    }
}
