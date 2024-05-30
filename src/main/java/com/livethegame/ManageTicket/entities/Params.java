package com.livethegame.ManageTicket.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Entity
public class Params {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @SequenceGenerator(name = "hibernate_sequence", sequenceName = "hibernate_sequence_params", allocationSize = 1)
    private long id;
    private String name;
    private String type;
    private String value;
    private LocalDateTime date_created;
    private LocalDateTime last_updated;


    public Params() {
        this.setDate_created();
        this.setLast_updated();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public LocalDateTime getDate_created() {
        return date_created;
    }

    private void setDate_created() {
        ZoneId easternTime = ZoneId.of("America/Bogota");
        this.date_created = LocalDateTime.now(easternTime);;
    }

    public LocalDateTime getLast_updated() {
        return last_updated;
    }

    private void setLast_updated() {
        this.last_updated = this.getDate_created();
    }

    public long getValueAsLong(){
        if ("long".equals(type.toLowerCase())) {
            try {
                return Long.parseLong(value);
            } catch (NumberFormatException e) {
                System.err.println("Error al convertir el valor a long: " + e.getMessage());
                return 0L;
            }
        } else {
            System.err.println("Error en tipo de parametro, se esperaba long.");
            return 0L;
        }
    }

    public int getValueAsInt(){
        if ("int".equals(type.toLowerCase())) {
            try {
                return Integer.parseInt(value);
            } catch (NumberFormatException e) {
                System.err.println("Error al convertir el valor a int: " + e.getMessage());
                return 0;
            }
        } else {
            System.err.println("Error en tipo de parametro, se esperaba int.");
            return 0;
        }
    }
    public String getValueAsString(){
        if ("string".equals(type.toLowerCase())) {
            return value;
        }else{
            System.err.println("Error en tipo de parametro, se esperaba string.");
            return "";
        }
    }
}
