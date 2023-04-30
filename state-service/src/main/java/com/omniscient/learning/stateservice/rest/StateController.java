package com.omniscient.learning.stateservice.rest;

import com.omniscient.learning.stateservice.model.State;
import com.omniscient.learning.stateservice.service.IStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/state")
public class StateController {

    private final IStateService stateService;

    @Autowired
    public StateController(IStateService stateService) {
        this.stateService = stateService;
    }

    @GetMapping("/")
    public ResponseEntity<Map<String, String>> ping() {
        return new ResponseEntity<>(getServerStatus(), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<State>> getStates() {
        return new ResponseEntity<>(this.stateService.getStates(), HttpStatus.OK);
    }

    @GetMapping("/code/{stateCode}")
    public ResponseEntity<State> getStateByStateCode(@PathVariable("stateCode") String stateCode) {
        return new ResponseEntity<>(this.stateService.getStateByStateCode(stateCode), HttpStatus.OK);
    }

    @GetMapping("/name/{stateName}")
    public ResponseEntity<State> getStateByStateName(@PathVariable("stateName") String stateName) {
        return new ResponseEntity<>(this.stateService.getStateByStateName(stateName), HttpStatus.OK);
    }

    //Just for ping service.
    private Map<String, String> getServerStatus() {
        Map<String, String> status = new HashMap<>();
        status.put("HttpStatus", "OK");
        status.put("HttpStatusCode", HttpStatus.OK.toString());
        status.put("time", LocalDateTime.now().toString());
        return status;
    }

}
