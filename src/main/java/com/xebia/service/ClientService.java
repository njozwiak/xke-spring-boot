package com.xebia.service;

import com.xebia.domain.Client;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Service
public class ClientService {

    // TODO 2.1 : Injecter ClientRepository

    // TODO 3.4 : injecter la valeur app.enviromnent en utilisant @Value
    private String environment;

    // TODO 3.5 : utiliser les @ConfigurationProperties pour gérer les configuration du service
    // TODO 3.5 : Injecter ClientProperties

    // TODO 2.1 : Injecter ClientRepository

    @Inject
    public ClientService() {
    }

    @Transactional(readOnly = true)
    public List<Client> findAll() {
        // TODO 2.1 : Utiliser ClientRepository.findAll()
        // TODO 3.5 : Ajouter une condition avec la classe ClientProperties pour trier les clients par nom (ordre croissant) lorsque
        // TODO       la propriété orderByName est true
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
