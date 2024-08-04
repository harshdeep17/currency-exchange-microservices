package com.microservices.currencyexchangemicroservice.services;

import com.microservices.currencyexchangemicroservice.exceptions.ResourceNotFoundException;
import com.microservices.currencyexchangemicroservice.models.CurrencyExchange;
import com.microservices.currencyexchangemicroservice.repositories.CurrencyExchangeRepository;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CurrencyExchangeService implements ExchangeService{

    private CurrencyExchangeRepository currencyExchangeRepository;
    private Environment environment;
    CurrencyExchangeService(CurrencyExchangeRepository currencyExchangeRepository,Environment environment){
        this.currencyExchangeRepository=currencyExchangeRepository;
        this.environment=environment;
    }
    @Override
    public CurrencyExchange retrieveExchangeValue(String from, String to) throws ResourceNotFoundException {
        Optional<CurrencyExchange> currencyExchangeOptional=currencyExchangeRepository
                .findByFromAndTo(from,to);
        if(!currencyExchangeOptional.isPresent()){
            throw new ResourceNotFoundException("Unable to find data for "+ from + " to "+ to);
        }
        CurrencyExchange currencyExchange=currencyExchangeOptional.get();
        String port = environment.getProperty("local.server.port");
        currencyExchange.setEnvironment(port);
        return currencyExchange;
    }
}
