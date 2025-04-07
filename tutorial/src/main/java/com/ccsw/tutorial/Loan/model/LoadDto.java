package com.ccsw.tutorial.Loan.model;


import com.ccsw.tutorial.client.model.ClientDto;
import com.ccsw.tutorial.Game.model.GameDto;

import java.util.Date;


public class LoadDto {

    private Long id;
    private Long gameId;
    private Long clientId;
    private Date startDate;
    private Date endDate;


    public void setId(Long id) {
        this.id = id;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Long getId() {
        return id;
    }

    public Long getGameId() {
        return gameId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Long getClientId() {
        return clientId;
    }

    public Date getEndDate() {
        return endDate;
    }
}
