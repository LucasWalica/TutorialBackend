package com.ccsw.tutorial.Loan.model;


import com.ccsw.tutorial.Game.model.Game;
import com.ccsw.tutorial.client.model.Client;
import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name="loan")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name="game_id", nullable = false)
    private Game gameId;

    @ManyToOne
    @JoinColumn(name="client_id", nullable = false)
    private Client clientId;

    @Column(name="start_date", nullable = false)
    private Date startDate;

    @Column(name="end_date", nullable = false)
    private Date endData;


    public void setId(Long id) {
        this.id = id;
    }

    public void setGame(Game gameId) {
        this.gameId = gameId;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setClient(Client clientId) {
        this.clientId = clientId;
    }

    public void setEndData(Date endData) {
        this.endData = endData;
    }

    public Game getGame() {
        return gameId;
    }

    public Long getId() {
        return id;
    }

    public Client getClient() {
        return clientId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndData() {
        return endData;
    }



}
