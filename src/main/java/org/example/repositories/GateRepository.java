package org.example.repositories;

import org.example.models.Gate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

//IN Memory DB -> List or Map
public class GateRepository {
    private Map<Long, Gate> gateMap = new HashMap<>();
    private Long gateId = 0L;

    public Gate save(Gate gate) {
        //update if gateId or insert if gate object
        if(gate.getId() == null) {
            //insert
            gateId++;
            gate.setId(gateId);
            gateMap.put(gateId, gate);
        }else{
            //update
            gateMap.put(gate.getId(), gate);
        }

        return gate;
    }

    public Optional<Gate> findById(Long gateId) {
        if(gateMap.containsKey(gateId)) {
            return Optional.of(gateMap.get(gateId));
        }else{
            return Optional.empty();
        }
    }
}
