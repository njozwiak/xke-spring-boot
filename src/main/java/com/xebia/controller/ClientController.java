package com.xebia.controller;

import com.xebia.domain.Client;
import com.xebia.service.ClientService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static com.google.common.collect.Lists.newArrayList;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class ClientController {

    private final AtomicLong idGenerator = new AtomicLong();

    private final ClientService clientService;

    @Inject
    public ClientController(final ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(value = "/clients", method = GET)
    public List<Client> allClients() {
        Client client1 = new Client(idGenerator.incrementAndGet(), "client1");
        Client client2 = new Client(idGenerator.incrementAndGet(), "client2");
        Client client3 = new Client(idGenerator.incrementAndGet(), "client3");

        return newArrayList(client1, client2, client3);
    }

    @RequestMapping(value = "/client", method = GET)
    public Client client(@RequestParam(value = "name") String name) {
        return new Client(idGenerator.incrementAndGet(), name);
    }

    @RequestMapping(value = "/client", method = POST)
    public Client createClient(@RequestBody @Valid final Client client) {
        return clientService.save(client);
    }
}
