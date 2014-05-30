package com.xebia.service;

import com.xebia.domain.Client;
import com.xebia.properties.ClientProperties;
import com.xebia.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Service
public class ClientService {

    // TODO 2.1 : Injecter ClientRepository

    // TODO CONF-a : injecter la valeur app.enviromnent en utilisant @Value
    @Value("${app.environment}")
    private String environment;

    // TODO CONF-b : utiliser les @ConfigurationProperties pour gérer les configuration du service
    @Inject
    ClientProperties properties;

    // TODO 2.1 : Injecter ClientRepository
    @Inject
    public ClientService(ClientRepository clientRepository) {
    }

    @Transactional(readOnly = true)
    public List<Client> findAll() {
        // TODO 2.1 : Utiliser ClientRepository.findAll()
        return null;
    }

    @Transactional
    public Client save(Client client) {
        // TODO 2.1 : Utiliser ClientRepository.save
        return null;
    }

    public String getEnvironment() {
        return environment;
    }
}
