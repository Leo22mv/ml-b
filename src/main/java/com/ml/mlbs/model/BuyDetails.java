package com.ml.mlbs.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class BuyDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_details;
    // private Long id_product;
    @ManyToOne(optional = true)
    @JoinColumn(name = "id_product")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "id_buy")
    private Buy buy;
    private Integer quantity;
}
