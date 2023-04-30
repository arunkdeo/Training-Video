package com.omniscient.learning.stateservice.service;

import com.omniscient.learning.stateservice.model.State;

import java.util.List;

public interface IStateService {
    List<State> getStates();
    State getStateByStateCode(String stateCode);

    State getStateByStateName(String stateName);
    String getCitiesOfState(String StateName);
    boolean createState(State state);
    State updateState(State state);
    State deleteState(State state);
}
