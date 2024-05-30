package com.livethegame.ManageTicket.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class TicketResponse {

    @ApiModelProperty(name = "Id", required = true,example = "", value = "")
    private Long id;

    public TicketResponse(){
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
