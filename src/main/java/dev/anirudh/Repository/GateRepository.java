package dev.anirudh.Repository;

import dev.anirudh.Models.Gate;

import java.util.*;

//In memory database implemented
public class GateRepository {
    private Map<Long, Gate> gateMap = new HashMap<>();
    private Long gateId = 0L;

    public Gate save(Gate gate) {
        //update + insert = upsert
        if(gate.getId() == null){
            gateId += 1;
            gate.setId(gateId);
            gateMap.put(gateId, gate);
        }
        else{
            gateMap.put(gate.getId(), gate);
        }

        return gate;
    }

    public Optional<Gate> findById(Long gateId){
        if(gateMap.containsKey(gateId)){
            return Optional.of(gateMap.get(gateId));
        }
        else{
            return Optional.empty();
        }
    }

    public List<Gate> findAll(){
        return new ArrayList<>(gateMap.values());
    }
}