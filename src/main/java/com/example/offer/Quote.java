package com.example.offer;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Embeddable
public class Quote implements Serializable {

    @Column(precision = 13, scale = 3)
    private BigDecimal price;

    @OneToMany
    private List<Fee> fees = new ArrayList<>();

    public Quote() {
    }

    public Quote(BigDecimal price, List<Fee> fees) {
        this.price = price;
        this.fees = fees;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<Fee> getFees() {
        return fees;
    }

    public void setFees(List<Fee> fees) {
        this.fees = fees;
    }
}
