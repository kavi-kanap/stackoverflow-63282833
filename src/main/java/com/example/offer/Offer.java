package com.example.offer;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Offer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    @AssociationOverride(name = "fees",
            joinTable = @JoinTable(
                    name = "offer_fees",
                    inverseJoinColumns = @JoinColumn(name = "fee_id", referencedColumnName = "id"),
                    joinColumns = @JoinColumn(name = "offer_id", referencedColumnName = "id")
            )
    )
    private Quote quote;

    public Offer() {
    }

    public Offer(Quote quote) {
        this.quote = quote;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Quote getQuote() {
        return quote;
    }

    public void setQuote(Quote quote) {
        this.quote = quote;
    }
}
