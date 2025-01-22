package dev.anirudh.DTOs;

import dev.anirudh.Models.ParkingLot;
import dev.anirudh.Models.ParkingSpot;
import dev.anirudh.Models.ParkingSpotAssignmentStrategyType;
import dev.anirudh.Models.VehicleType;

public class GenerateTicketRequestDto {
    private String vehicleNumber;
    private String ownerName;
    private Long gateId;
    private VehicleType vehicleType;
    private ParkingSpotAssignmentStrategyType parkingSpotassignmentStrategyType;

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Long getGateId() {
        return gateId;
    }

    public void setGateId(Long gateId) {
        this.gateId = gateId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public ParkingSpotAssignmentStrategyType getParkingSpotassignmentStrategyType() {
        return parkingSpotassignmentStrategyType;
    }

    public void setParkingSpotassignmentStrategyType(ParkingSpotAssignmentStrategyType parkingSpotassignmentStrategyType) {
        this.parkingSpotassignmentStrategyType = parkingSpotassignmentStrategyType;
    }
}
