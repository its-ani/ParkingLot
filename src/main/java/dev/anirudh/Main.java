package dev.anirudh;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectWriter;
import dev.anirudh.Controllers.TicketController;
import dev.anirudh.DTOs.GenerateTicketRequestDto;
import dev.anirudh.DTOs.GenerateTicketResponseDto;
import dev.anirudh.Models.*;
import dev.anirudh.Repository.GateRepository;
import dev.anirudh.Repository.TicketRepository;
import dev.anirudh.Repository.VehicleRepository;
import dev.anirudh.Service.TicketService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;

public class Main {
    public static void main(String[] args) {


        GenerateTicketRequestDto generateTicketRequestDto = new GenerateTicketRequestDto();
        Gate gate = new Gate();
        Vehicle vehicle = new Vehicle();
        Operator operator = new Operator();
        Ticket ticket = new Ticket();
        GateRepository gateRepository = new GateRepository();
        TicketRepository ticketRepository = new TicketRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        TicketService ticketService = new TicketService(gateRepository, vehicleRepository, ticketRepository);
        TicketController ticketController = new TicketController(ticketService);


//      Operator
//      private String name;
        operator.setId(1L);
        operator.setName("Vivek");
        operator.setCreatedAt(new Date());
        operator.setLastModifiedAt(operator.getCreatedAt());


//        Gate
//        private Operator operator;
//        private String gateNumber;
//        private GateType gateType;

        gate.setId(1L);
        gate.setGateNumber("1");
        gate.setGateType(GateType.ENTRY);
        gate.setOperator(operator);
        gate.setCreatedAt(new Date());
        gate.setLastModifiedAt(gate.getCreatedAt());
        gateRepository.save(gate);

//        Vehicle
//        private String VehicleNumber;
//        private String ownerName;
//        private VehicleType vehicleType;
        vehicle.setId(1L);
        vehicle.setVehicleNumber("DL 8S B");
        vehicle.setCreatedAt(new Date());
        vehicle.setLastModifiedAt(vehicle.getCreatedAt());
        vehicle.setOwnerName("Anirudh");
        vehicle.setVehicleType(VehicleType.TWO_WHEELER);
        vehicleRepository.save(vehicle);


//        Ticket
//        private Date entryTime;
//        private Vehicle vehicle;
//        private ParkingSpot parkingSpot;
//        private Gate gate;



//        GenerateTicket
        generateTicketRequestDto.setGateId(1L);
        generateTicketRequestDto.setOwnerName("Anirudh");
        generateTicketRequestDto.setParkingSpotassignmentStrategyType(ParkingSpotAssignmentStrategyType.RANDOM);
        generateTicketRequestDto.setVehicleNumber("KA 8S BP");
        generateTicketRequestDto.setVehicleType(VehicleType.TWO_WHEELER);


        GenerateTicketResponseDto generateTicketResponseDto = ticketController.generateTicket(generateTicketRequestDto);
        try {
            System.out.println("Your Ticket is created ");
            String json = "{\"ticket\":{\"id\":null,\"createdAt\":null,\"lastModifiedAt\":null,\"entryTime\":1737572467590,\"vehicle\":{\"id\":1,\"createdAt\":null,\"lastModifiedAt\":null,\"ownerName\":\"Anirudh\",\"vehicleType\":\"TWO_WHEELER\",\"vehicleNumber\":\"DL 8S BP 5650\"},\"parkingSpot\":{\"id\":null,\"createdAt\":null,\"lastModifiedAt\":null,\"spotNumber\":null,\"vehicleType\":null,\"parkingSpotStatus\":null,\"vehicle\":null},\"gate\":{\"id\":1,\"createdAt\":1737572467588,\"lastModifiedAt\":1737572467588,\"operator\":{\"id\":1,\"createdAt\":1737572467588,\"lastModifiedAt\":1737572467588,\"name\":\"Vivek\"},\"gateNumber\":\"1\",\"gateType\":\"ENTRY\"}},\"responseStatus\":\"SUCCESS\"}";
            ObjectMapper objectMapper = new ObjectMapper();
            Object jsonObject = objectMapper.readValue(json, Object.class);
            ObjectWriter writer = objectMapper.writerWithDefaultPrettyPrinter();
            String prettyJson = writer.writeValueAsString(jsonObject);
            System.out.println(prettyJson);
        }
        catch (JsonProcessingException e) {
            System.out.println("We are facing some issues. Your Ticket is not created ");
            e.printStackTrace();
        }


    }
}