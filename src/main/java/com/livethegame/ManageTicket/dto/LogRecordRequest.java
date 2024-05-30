package com.livethegame.ManageTicket.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class LogRecordRequest {

    @ApiModelProperty(name = "Nombre del servicio", required = true,example = "", value = "")
    private String service_name;
    @ApiModelProperty(name = "Id de referencia", required = false,example = "", value = "")
    private String service_id_value;
    @ApiModelProperty(name = "Informacion de accion", required = true,example = "", value = "")
    private String information;
    @ApiModelProperty(name = "Id del tipo de alerta", required = true,example = "", value = "")
    private Long type_id;

    public LogRecordRequest(){
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public String getService_id_value() {
        return service_id_value;
    }

    public void setService_id_value(String service_id_value) {
        this.service_id_value = service_id_value;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Long getType_id() {
        return type_id;
    }

    public void setType_id(Long type_id) {
        this.type_id = type_id;
    }
}
