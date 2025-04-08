package com.ccsw.tutorial.Loan.model;


import com.ccsw.tutorial.Game.model.Game;
import com.ccsw.tutorial.client.model.Client;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    private Game game;

    @ManyToOne
    @JoinColumn(name="client_id", nullable = false)
    private Client client;

    @Column(name="start_date", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date startDate;

    @Column(name="end_date", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date endDate;


    public void setId(Long id) {
        this.id = id;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setEndData(Date endDate) {
        this.endDate = endDate;
    }

    public Game getGame() {
        return game;
    }

    public Long getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }



}
