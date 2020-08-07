package com.lamdaschool.piggybank.controllers;
import com.lamdaschool.piggybank.models.Piggybank;
import com.lamdaschool.piggybank.repositories.PiggyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

    private float getTotal() {
        float total = 0;

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

        System.out.print("The piggy bank holds $" + getTotal());
//        System.out.print("The piggy bank holds 7.3");

        return new ResponseEntity<>(HttpStatus.OK);
    }
}