package com.microservices.currencyexchangemicroservice.services;

import com.microservices.currencyexchangemicroservice.exceptions.ResourceNotFoundException;
import com.microservices.currencyexchangemicroservice.models.CurrencyExchange;

import java.util.Optional;

public interface ExchangeService {
    CurrencyExchange retrieveExchangeValue(String from, String to) throws ResourceNotFoundException;
}
