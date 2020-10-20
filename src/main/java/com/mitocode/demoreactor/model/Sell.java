package com.mitocode.demoreactor.model;

import java.time.LocalDateTime;

public class Sell {

    private Integer idSell;
    private LocalDateTime date;

    public Sell() {
    }

    public Sell(Integer idSell, LocalDateTime date) {
        this.idSell = idSell;
        this.date = date;
    }

    public Integer getIdSell() {
        return idSell;
    }

    public void setIdSell(Integer idSell) {
        this.idSell = idSell;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Sell{" +
                "idSell=" + idSell +
                ", date=" + date +
                '}';
    }
}
