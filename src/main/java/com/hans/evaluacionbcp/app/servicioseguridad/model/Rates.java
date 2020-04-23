package com.hans.evaluacionbcp.app.servicioseguridad.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "rates")
public class Rates implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String rate;
    @Column(name = "exchange_rate")
    private Double exchangeRate;
    @ManyToOne
    @JoinColumn(name = "currency_id", nullable = false)
    private Currency currency;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public Double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(Double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
