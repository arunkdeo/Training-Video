package com.omniscient.learning.stateservice.dao;

import com.omniscient.learning.stateservice.model.State;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StateDaoImpl implements IStateDao {

    private static final List<State> STATES = new ArrayList<>();
    private static final Map<String, State> STATE_BY_CODE = new HashMap<>();
    private static final Map<String, State> STATE_BY_NAME = new HashMap<>();

    @PostConstruct
    public void prepareStateData() throws IOException {
        Resource resource = new ClassPathResource("states.csv");
        List<String> stateCsv = Files.readAllLines(Paths.get(resource.getURI()));
        stateCsv.remove(0);
        stateCsv.forEach(state -> {
            String[] sa = state.split(",");
            State so = new State(sa[0], sa[1], sa[2], sa[3].split("\\|"));
            STATES.add(so);
            STATE_BY_CODE.put(so.getStateCode(), so);
            STATE_BY_NAME.put(so.getStateName(), so);
        });
    }

    @Override
    public List<State> getStates() {
        return new ArrayList<>(STATES);
    }

    @Override
    public State getStateByCode(String stateCode) {
        return STATE_BY_CODE.get(stateCode);
    }

    @Override
    public List<String> getCitiesOfState(String stateName) {
        return STATE_BY_NAME.get(stateName).getMajorCities();
    }

    @Override
    public boolean createState(State state) {

        return false;
    }

    @Override
    public State updateState(State state) {
        return null;
    }

    @Override
    public State deleteState(State state) {
        STATES.remove(state);
        STATE_BY_NAME.remove(state.getStateName());
        STATE_BY_CODE.remove(state.getStateCode());
        return state;
    }

    @Override
    public State getStateByName(String stateName) {
        return STATE_BY_NAME.get(stateName);
    }
}
