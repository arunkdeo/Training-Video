package com.omniscient.learning.stateservice.service;

import com.omniscient.learning.stateservice.dao.IStateDao;
import com.omniscient.learning.stateservice.exception.RecordNotFoundException;
import com.omniscient.learning.stateservice.model.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StateServiceImpl implements IStateService {

    private final IStateDao stateDao;

    @Autowired
    public StateServiceImpl(IStateDao stateDao) {
        this.stateDao = stateDao;
    }

    @Override
    public List<State> getStates() {
        return this.stateDao.getStates();
    }

    @Override
    public State getStateByStateCode(String stateCode) {
        State state = this.stateDao.getStateByCode(stateCode);
        if (Objects.isNull(state)) {
            throw new RecordNotFoundException(String.format("State does not exist with state code : %s", stateCode));
        }
        return state;
    }

    @Override
    public State getStateByStateName(String stateName) {
        State state = this.stateDao.getStateByName(stateName);
        if (Objects.isNull(state)) {
            throw new RecordNotFoundException(String.format("State does not exist with state Name : %s", stateName));
        }
        return state;
    }

    @Override
    public String getCitiesOfState(String StateName) {
        return null;
    }

    @Override
    public boolean createState(State state) {
        if (Objects.nonNull(state)) {
            if ((Objects.nonNull(state.getStateCode()) && Objects.nonNull(state.getStateName())
                    && Objects.nonNull(state.getStateCapital())) &&
                    (Objects.isNull(this.getStateByStateCode(state.getStateCode())) && Objects.isNull(this.getStateByStateName(state.getStateName())))) {
                this.createState(state);
            } else {
                throw new RecordNotFoundException("State with same name or code already exist");
            }
        }
        return true;
    }

    @Override
    public State updateState(State state) {
        return null;
    }

    @Override
    public State deleteState(State state) {
        if (Objects.isNull(this.stateDao.getStateByCode(state.getStateCode())) && Objects.isNull(this.stateDao.getStateByName(state.getStateName()))) {
            throw new RecordNotFoundException("Requested state does not exist for deleting");
        }
        return this.stateDao.deleteState(state);
    }
}
