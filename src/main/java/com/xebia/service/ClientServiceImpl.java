package com.xebia.service;

import com.xebia.domain.Client;
import com.xebia.repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    @Inject
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    @Transactional
    public Client save(Client client) {
        return clientRepository.save(client);
    }
}
