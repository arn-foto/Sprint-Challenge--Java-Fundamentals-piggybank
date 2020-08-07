package com.lamdaschool.piggybank.controllers;
import com.lamdaschool.piggybank.models.Piggybank;
import com.lamdaschool.piggybank.repositories.PiggyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


@RestController
public class PiggyController {

    public List<Piggybank> coinList = new ArrayList<>();

    private String checkPlural(Piggybank coin) {
        if (coin.getQuantity() > 1) {
            return coin.getNamepural();
        } else return coin.getName();
    }

    private double getTotal() {
        double total = 0;

        for (Piggybank coin : coinList) {
            total += coin.getQuantity() * coin.getValue();
        }

        return total;
    }

    @Autowired
    PiggyRepo coinrepo;

    @GetMapping(value = "/total",
            produces = {"application/json"})

    public ResponseEntity<?> listTotal() {
        coinList.clear();
        coinrepo.findAll().iterator().forEachRemaining(coinList::add);

        for (Piggybank coin : coinList) {
            System.out.println(coin.getQuantity() + " " + checkPlural(coin));
        }
        DecimalFormat df = new DecimalFormat("###.##");
        System.out.println("The piggy bank holds $" + (df.format(getTotal())));


        return new ResponseEntity<>(HttpStatus.OK);
    }
}