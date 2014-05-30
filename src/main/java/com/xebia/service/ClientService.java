package com.xebia.service;

import com.xebia.properties.ClientProperties;
import com.xebia.domain.Client;
import com.xebia.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    @Value("${app.environment}")
    private String environment;

    @Inject
    ClientProperties properties;

    @Inject
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Transactional(readOnly = true)
    public List<Client> findAll() {
        if (properties.isOrderByName()) {
            return clientRepository.findAll(new Sort(Sort.Direction.ASC, "name"));
        } else {
            return clientRepository.findAll();
        }
    }

    @Transactional
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public String getEnvironment() {
        return environment;
    }
}
