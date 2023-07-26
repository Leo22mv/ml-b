package com.ml.mlbs.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BuyRequest {
    private Long id_user;
    private Integer total;
    private List<BuyDetailsRequest> buy;
}
