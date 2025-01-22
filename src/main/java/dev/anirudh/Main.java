package dev.anirudh;

import dev.anirudh.Controllers.TicketController;
import dev.anirudh.DTOs.GenerateTicketRequestDto;
import dev.anirudh.Models.ParkingSpotAssignmentStrategyType;
import dev.anirudh.Models.VehicleType;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        GenerateTicketRequestDto generateTicketRequestDto = new GenerateTicketRequestDto();
        TicketController ticketController = new TicketController();

        generateTicketRequestDto.setGateId(1L);
        generateTicketRequestDto.setOwnerName("Anirudh");
        generateTicketRequestDto.setParkingSpotassignmentStrategyType(ParkingSpotAssignmentStrategyType.RANDOM);
        generateTicketRequestDto.setVehicleNumber("DL 8S BP 5650");
        generateTicketRequestDto.setVehicleType(VehicleType.TWO_WHEELER);


        System.out.println("Your Ticket is created " + ticketController.generateTicket(generateTicketRequestDto));

    }
}