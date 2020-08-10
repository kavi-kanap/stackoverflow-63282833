package com.example.offer;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Purchase implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Offer offer;

    @Embedded
    @AssociationOverride(name = "fees",
            joinTable = @JoinTable(
                    name = "purchase_fees",
                    inverseJoinColumns = @JoinColumn(name = "fee_id", referencedColumnName = "id"),
                    joinColumns = @JoinColumn(name = "purchase_id", referencedColumnName = "id")
            )
    )
    private Quote quote;

    public Purchase(Offer offer, Quote quote) {
        this.offer = offer;
        this.quote = quote;
    }

    public Purchase() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public Quote getQuote() {
        return quote;
    }

    public void setQuote(Quote quote) {
        this.quote = quote;
    }
}
