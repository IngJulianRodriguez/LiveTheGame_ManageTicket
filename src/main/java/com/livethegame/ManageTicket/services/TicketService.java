package com.livethegame.ManageTicket.services;

import com.livethegame.ManageTicket.common.TicketResponseMapper;
import com.livethegame.ManageTicket.dto.FoundTicketResponse;
import com.livethegame.ManageTicket.dto.TicketResponse;
import com.livethegame.ManageTicket.entities.*;
import com.livethegame.ManageTicket.exception.*;
import com.livethegame.ManageTicket.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    TicketsStagesRepository ticketsStageRepository;
    @Autowired
    ParamsRepository paramsRepository;
    @Autowired
    TicketResponseMapper ticketResponseMapper;


    public TicketResponse payTicket(Long idTicket){
        Optional<Tickets> optionalTicket = ticketRepository.findById(idTicket);
        if (optionalTicket.isEmpty()) {
            throw new TicketNotFoundException("Ticket no encontrado con ID: " + idTicket);
        }
        Tickets ticket = optionalTicket.get();
        if(ticket.getPrice_ticket()>0){
            if(paymentWasSuccessful(ticket.getPrice_ticket())){

            }else{
                throw new PaymentFailedException("Pago no fue exitoso, por favor intente mas tarde");
            }
        }
        Tickets savedTicket = updateStageTicket(ticket);
        return ticketResponseMapper.ticketToTicketResponse(savedTicket);
    }
    public FoundTicketResponse ticketById(Long idTicket){
        Optional<Tickets> optionalTicket = ticketRepository.findById(idTicket);
        if (optionalTicket.isEmpty()) {
            throw new TicketNotFoundException("Ticket no encontrado con ID: " + idTicket);
        }
        FoundTicketResponse foundTicketResponse
                = ticketResponseMapper.ticketToFoundTicketResponse(optionalTicket.get());
        return foundTicketResponse;
    }
    public List<FoundTicketResponse> list(){
        List<Tickets> listTickets = ticketRepository.findAll();
        List<FoundTicketResponse> foundTicketListResponse
                = ticketResponseMapper.listTicketsToListFoundTicketsResponse(listTickets);
        return foundTicketListResponse;
    }

    private Tickets updateStageTicket(Tickets ticket){
        Optional<Params> optionalParamsTicketStagesPaidId = paramsRepository.findByName("tickets_stages.paid.id");
        if (optionalParamsTicketStagesPaidId.isEmpty()) {
            throw new ParamsNotFoundException("Parametro tickets_stages.paid.id no encontrado");
        }
        Optional<TicketsStages> optionalTicketStage
                = ticketsStageRepository.findById(optionalParamsTicketStagesPaidId.get().getValueAsLong());
        if (optionalTicketStage.isEmpty()) {
            throw new TicketStageNotFoundException("Etapa de servicio no encontrado con ID: "+optionalParamsTicketStagesPaidId.get().getValueAsLong());
        }
        ticket.setTicket_stage(optionalTicketStage.get());
        ticket.setLast_updated();
        return ticketRepository.save(ticket);
    }
    private boolean paymentWasSuccessful(double price) {
        //Logic must be implemented for communication with payment gateway
        return true;
    }

}
