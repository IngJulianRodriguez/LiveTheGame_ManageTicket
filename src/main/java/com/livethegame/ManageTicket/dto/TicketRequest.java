package com.livethegame.ManageTicket.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class TicketRequest {


    @ApiModelProperty(name = "Id del ticket", required = false, example = "", value = "")
    private long id;


    public TicketRequest() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
