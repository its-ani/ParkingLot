package dev.anirudh.Controllers;

import dev.anirudh.DTOs.GenerateTicketRequestDto;
import dev.anirudh.DTOs.GenerateTicketResponseDto;
import dev.anirudh.Models.ParkingSpotAssignmentStrategyType;
import dev.anirudh.Models.VehicleType;

public class TicketController {
    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto generateTicketRequestDto){

        String vehicleNumber = generateTicketRequestDto.getVehicleNumber();
        Long gateId = generateTicketRequestDto.getGateId();
        String ownerName = generateTicketRequestDto.getOwnerName();
        VehicleType vehicleType = generateTicketRequestDto.getVehicleType();
        ParkingSpotAssignmentStrategyType parkingSpotAssignmentStrategyType = generateTicketRequestDto.getParkingSpotassignmentStrategyType();


        return null;
    }
}
