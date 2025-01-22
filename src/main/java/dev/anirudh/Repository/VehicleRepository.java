package dev.anirudh.Repository;

import dev.anirudh.Models.Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class VehicleRepository {
    private Map<Long, Vehicle> vehicleMap = new HashMap<>();
    private Long vehicleId = 0L;

    public Vehicle save(Vehicle vehicle) {
        if(vehicle.getId() == null){
            vehicleId += 1;
            vehicle.setId(vehicleId);
            vehicleMap.put(vehicleId, vehicle);
        }
        else{
            vehicleMap.put(vehicle.getId(), vehicle);
        }
        return vehicle;
    }

    public Optional<Vehicle> findById(Long vehicleId) {

        if(vehicleMap.containsKey(vehicleId)){
            return Optional.of(vehicleMap.get(vehicleId));
        }
        else{
            return Optional.empty();
        }
    }

    public Optional<Vehicle> findByVehicleNumber(String vehicleNumber) {

        for(Map.Entry<Long, Vehicle> entry : vehicleMap.entrySet()){
            if(entry.getValue().getVehicleNumber().equals(vehicleNumber)){
                return Optional.of(entry.getValue());
            }
        }

        return Optional.empty();
    }
}