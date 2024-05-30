package com.livethegame.ManageTicket.controller;

import com.livethegame.ManageTicket.dto.FoundTicketResponse;
import com.livethegame.ManageTicket.dto.TicketRequest;
import com.livethegame.ManageTicket.dto.TicketResponse;
import com.livethegame.ManageTicket.exception.*;
import com.livethegame.ManageTicket.services.MonitoringService;
import com.livethegame.ManageTicket.services.TicketService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Api(tags = "Api Manage Ticket")
@RestController
@RequestMapping("/tickets")
public class ManageTicketRestController {

    @Autowired
    TicketService ticketService;
    @Autowired
    MonitoringService monitoringService;

    @PatchMapping("/pay/{id}")
    public ResponseEntity<?> payTicket(@PathVariable Long id) {
        try {
            TicketResponse ticketResponse = ticketService.payTicket(id);
            String message = "Pago realizado de forma exitosa";
            monitoringService.registerSuccessLog(String.valueOf(ticketResponse.getId()),"/pay/{id} "+id.toString()+" "+ticketResponse);
            return ResponseEntity.ok(message);
        } catch (TicketNotFoundException
                 | ParamsNotFoundException
                 | TicketStageNotFoundException e) {
            monitoringService.registerControlledExceptionLog("","/pay/{id} "+id.toString()+" "+e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            monitoringService.registerNotControlledExceptionLog("","/pay/{id} "+id.toString()+" "+e.getMessage());
            return ResponseEntity.status(500).body("Error interno del servidor");
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> listTicketsById(@PathVariable String id){
        Long idTicket;
        try {
            idTicket = Long.parseLong(id);
            FoundTicketResponse foundTicketResponse = ticketService.ticketById(idTicket);
            monitoringService.registerSuccessLog(String.valueOf(foundTicketResponse.getId()),"/{id} "+id.toString()+" "+foundTicketResponse);
            return ResponseEntity.ok(foundTicketResponse);
        } catch (TicketNotFoundException e){
            monitoringService.registerControlledExceptionLog("","/{id} "+id.toString()+" "+e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (NumberFormatException e) {
            monitoringService.registerControlledExceptionLog("","/{id} "+id.toString()+" "+e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id ticket inválido: " + id);
        } catch (Exception e) {
            monitoringService.registerNotControlledExceptionLog("","/{id} "+id.toString()+" "+e.getMessage());
            return ResponseEntity.status(500).body("Error interno del servidor");
        }
    }
    @GetMapping("/list")
    public ResponseEntity<?> listAll(){
        try {
            List<FoundTicketResponse> listFoundTicketResponse = ticketService.list();
            monitoringService.registerSuccessLog("","/list "+listFoundTicketResponse);
            return ResponseEntity.ok(listFoundTicketResponse);
        } catch (Exception e) {
            monitoringService.registerNotControlledExceptionLog("","/list "+e.getMessage());
            return ResponseEntity.status(500).body("Error interno del servidor");
        }
    }
    @GetMapping("/test-manage")
    public ResponseEntity<?> testManage(){
        return ResponseEntity.ok().build();
    }
}
