package com.livethegame.ManageTicket.dto;

import com.livethegame.ManageTicket.entities.Services;
import com.livethegame.ManageTicket.entities.TicketsStages;
import com.livethegame.ManageTicket.entities.Users;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

@ApiModel()
public class FoundTicketResponse {

    @ApiModelProperty(name = "Id", required = true,example = "", value = "")
    private Long id;
    @ApiModelProperty(name = "Precio del ticket", required = true,example = "", value = "")
    private double price_ticket;
    @ApiModelProperty(name = "Id del usuario", required = true,example = "", value = "")
    private Users user;
    @ApiModelProperty(name = "Id del tipo de servicio", required = true,example = "", value = "")
    private Services service;
    @ApiModelProperty(name = "", required = true,example = "", value = "")
    private Long service_id_value;
    @ApiModelProperty(name = "Etapa del ticket", required = true,example = "", value = "")
    private TicketsStages ticket_stage;


    public FoundTicketResponse(){
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice_ticket() {
        return price_ticket;
    }

    public void setPrice_ticket(double price_ticket) {
        this.price_ticket = price_ticket;
    }


    public Long getUser() {
        return user.getId();
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getService() {
        return service.getName();
    }

    public void setService(Services service) {
        this.service = service;
    }

    public Long getService_id_value() {
        return service_id_value;
    }

    public void setService_id_value(Long service_id_value) {
        this.service_id_value = service_id_value;
    }

    public String getTicket_stage() {
        return ticket_stage.getName();
    }

    public void setTicket_stage(TicketsStages ticket_stage) {
        this.ticket_stage = ticket_stage;
    }
}
