package com.livethegame.ManageTicket.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class TournamentInfoResponse {

    @ApiModelProperty(name = "Numero de jugadores registrados", required = true,example = "", value = "")
    private int numberOfPlayers;
    @ApiModelProperty(name = "Numero de asistentes registrados", required = true,example = "", value = "")
    private int numberOfViewers;
    @ApiModelProperty(name = "Total generado por los jugadores", required = true,example = "", value = "")
    private double gainOfTheTournament;
    @ApiModelProperty(name = "Total generado por los asistentes", required = true,example = "", value = "")
    private double gainOfTheBroadcasts;

    public TournamentInfoResponse(){
        setGainOfTheBroadcasts(0);
        setGainOfTheTournament(0);
        setNumberOfPlayers(0);
        setNumberOfViewers(0);
    }
    public void addToGainOfTheBroadcasts(double sum){
        this.gainOfTheBroadcasts +=sum;
    }
    public void addToGainOfTheTournament(double sum){
        this.gainOfTheTournament +=sum;
    }
    public void addNumberOfPlayers(){
        this.numberOfPlayers++;
    }
    public void addNumberOfViewers(){
        this.numberOfViewers++;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public int getNumberOfViewers() {
        return numberOfViewers;
    }

    public void setNumberOfViewers(int numberOfViewers) {
        this.numberOfViewers = numberOfViewers;
    }

    public double getGainOfTheTournament() {
        return gainOfTheTournament;
    }

    public void setGainOfTheTournament(double gainOfTheTournament) {
        this.gainOfTheTournament = gainOfTheTournament;
    }

    public double getGainOfTheBroadcasts() {
        return gainOfTheBroadcasts;
    }

    public void setGainOfTheBroadcasts(double gainOfTheBroadcasts) {
        this.gainOfTheBroadcasts = gainOfTheBroadcasts;
    }
}
