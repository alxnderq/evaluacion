package com.hans.evaluacionbcp.app.servicioseguridad.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "currency")
public class Currency implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, name = "currency_base")
    private String currencyBase;
    @OneToMany(mappedBy = "currency")
    private Set<Rates> rates;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrencyBase() {
        return currencyBase;
    }

    public void setCurrencyBase(String currencyBase) {
        this.currencyBase = currencyBase;
    }

    public Set<Rates> getRates() {
        return rates;
    }

    public void setRates(Set<Rates> rates) {
        this.rates = rates;
    }
}
