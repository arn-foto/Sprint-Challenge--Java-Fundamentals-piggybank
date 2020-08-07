package com.lamdaschool.piggybank.controllers;

import com.lamdaschool.piggybank.repositories.PiggyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PiggyController
{
    @Autowired
    PiggyRepo pigRepo;

    // http://localhost:2019/total

    @GetMapping(value = "/total",
            produces = { "application/json"})
    public ResponseEntity<?> listMoney()
    {

        return  new ResponseEntity<>(HttpStatus.OK);
    }
}
