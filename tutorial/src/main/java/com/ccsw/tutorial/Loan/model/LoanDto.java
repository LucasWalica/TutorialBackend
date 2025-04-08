package com.ccsw.tutorial.Loan.model;


import com.ccsw.tutorial.client.model.ClientDto;
import com.ccsw.tutorial.Game.model.GameDto;

import java.util.Date;


public class LoanDto {

    private Long id;
    private GameDto game;
    private ClientDto client;
    private Date startDate;
    private Date endDate;

    public ClientDto getClient() {
        return client;
    }

    public void setGame(GameDto game) {
        this.game = game;
    }

    public void setClient(ClientDto client) {
        this.client = client;
    }

    public GameDto getGame() {
        return game;
    }

    public void setId(Long id) {
        this.id = id;
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



    public Date getStartDate() {
        return startDate;
    }


    public Date getEndDate() {
        return endDate;
    }
}
