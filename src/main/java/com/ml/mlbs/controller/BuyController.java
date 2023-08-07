package com.ml.mlbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.ml.mlbs.model.Buy;
import com.ml.mlbs.model.BuyDetails;
import com.ml.mlbs.model.BuyDetailsRequest;
import com.ml.mlbs.model.BuyRequest;
import com.ml.mlbs.model.Product;
import com.ml.mlbs.model.UserEntity;
import com.ml.mlbs.repository.BuyDetailsRepository;
import com.ml.mlbs.repository.BuyRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
// @CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://e-commerce-f.web.app")
public class BuyController {
    private BuyRepository buyRepository;
    private BuyDetailsRepository buyDetailsRepository;

    @Autowired
    public BuyController(BuyRepository buyRepository, BuyDetailsRepository buyDetailsRepository) {
        this.buyRepository = buyRepository;
        this.buyDetailsRepository = buyDetailsRepository;
    }

    // @PostMapping("/compra")
    // public ResponseEntity<String> crearCompra(@RequestBody BuyRequest request) {
    //     try {
    //         Buy buy = new Buy();
    //         buy.setUser(request.getId_user());
    //         buy.setTotal(request.getTotal());

    //         buy = buyRepository.save(buy);

    //         for (BuyDetailsRequest details : request.getBuy()) {
    //             BuyDetails buyDetails = new BuyDetails();
    //             buyDetails.setProduct(buy.getId_buy());
    //             buyDetails.setIdProducto(details.getIdProducto());
    //             buyDetails.setCantidad(details.getCantidad());

    //             detallesCompraRepository.save(detallesCompra);
    //         }

    //         return ResponseEntity.ok("Compra creada correctamente");
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    //     }
    // }

    @PostMapping("/compra")
    // @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<String> createBuy(@RequestBody BuyRequest request) {
        try {
            UserEntity user = new UserEntity();
            user.setId(request.getId_user());

            Buy buy = new Buy();
            buy.setUser(user);
            buy.setTotal(request.getTotal());

            buy = buyRepository.save(buy);

            for (BuyDetailsRequest details : request.getBuy()) {
                Product product = new Product();
                product.setId_product(details.getId_product());

                BuyDetails buyDetails = new BuyDetails();
                buyDetails.setBuy(buy);
                buyDetails.setProduct(product);
                buyDetails.setQuantity(details.getQuantity());

                buyDetailsRepository.save(buyDetails);
            }
            return ResponseEntity.ok("Compra creada correctamente");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



    @GetMapping("/compras")
    // @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Buy>> getBuys() {
        List<Buy> buys = buyRepository.findAll();
        try {
            return ResponseEntity.ok(buys);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/compras/{id}")
    // @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<BuyDetails>> getDetails(@PathVariable Long id) {
        List<BuyDetails> allDetails = buyDetailsRepository.findAll();
        List<BuyDetails> details = new ArrayList<>();
        try {
            for (BuyDetails detail : allDetails) {
                if (detail.getBuy().getId_buy().equals(id)) {
                    details.add(detail);
                }
            }
            return ResponseEntity.ok(details);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}