package com.microservices.currencyexchangemicroservice.controllers;

import com.microservices.currencyexchangemicroservice.exceptions.ResourceNotFoundException;
import com.microservices.currencyexchangemicroservice.models.CurrencyExchange;
import com.microservices.currencyexchangemicroservice.repositories.CurrencyExchangeRepository;
import com.microservices.currencyexchangemicroservice.services.ExchangeService;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
public class CurrencyExchangeController {

    private ExchangeService exchangeService;
    CurrencyExchangeController(ExchangeService exchangeService){
        this.exchangeService=exchangeService;
    }
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    CurrencyExchange retrieveExchangeValue(@PathVariable("from") String from,
                                           @PathVariable("to") String to) throws ResourceNotFoundException {
        CurrencyExchange currencyExchange=exchangeService.retrieveExchangeValue(from,to);

        return currencyExchange;
    }
}
//http://localhost:8000/currency-exchange/from/USD/to/INR