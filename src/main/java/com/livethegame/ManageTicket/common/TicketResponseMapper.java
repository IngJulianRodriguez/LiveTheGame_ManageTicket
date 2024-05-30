package com.livethegame.ManageTicket.common;

import com.livethegame.ManageTicket.dto.FoundTicketResponse;
import com.livethegame.ManageTicket.dto.TicketResponse;
import com.livethegame.ManageTicket.entities.Tickets;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface TicketResponseMapper {
    TicketResponse ticketToTicketResponse(Tickets source);
    FoundTicketResponse ticketToFoundTicketResponse(Tickets source);
    List<FoundTicketResponse> listTicketsToListFoundTicketsResponse(List<Tickets> source);
}
