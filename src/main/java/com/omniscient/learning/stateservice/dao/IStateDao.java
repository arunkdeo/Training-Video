package com.omniscient.learning.stateservice.dao;

import com.omniscient.learning.stateservice.model.State;

import java.util.List;

public interface IStateDao {
    List<State> getStates();
    State getStateByCode(String stateCode);
    List<String> getCitiesOfState(String StateName);
    boolean createState(State state);
    State updateState(State state);
    State deleteState(State state);

    State getStateByName(String stateName);
}
