package dev.anirudh.Repository;

import dev.anirudh.Models.ParkingFloor;
import dev.anirudh.Models.ParkingLot;
import dev.anirudh.Models.VehicleType;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class ParkingLotRepository {
    private final Map<Long, ParkingLot> parkingLotStorage = new HashMap<>();
    private final Map<Long, Long> gateToParkingLotMap = new HashMap<>();

    public int getCapacityForVehicleType(VehicleType type, ParkingFloor floor) {
        return (int) floor.getParkingSpots().stream()
                .filter(spot -> spot.getVehicleType().equals(type))
                .count();
    }

    public Optional<ParkingLot> getParkingLotByGateId(long gateId) {
        Long parkingLotId = gateToParkingLotMap.get(gateId);
        return parkingLotId != null ? Optional.ofNullable(parkingLotStorage.get(parkingLotId)) : Optional.empty();
    }

    public Optional<ParkingLot> getParkingLotById(long id) {
        return Optional.ofNullable(parkingLotStorage.get(id));
    }

    public ParkingLot save(ParkingLot parkingLot) {
        parkingLotStorage.put(parkingLot.getId(), parkingLot);
        parkingLot.getGates().forEach(gate -> gateToParkingLotMap.put(gate.getId(), parkingLot.getId()));
        return parkingLot;
    }

    public List<ParkingFloor> getParkingFloors(ParkingLot parkingLot) {
        return parkingLot.getParkingFloorList();
    }
}
