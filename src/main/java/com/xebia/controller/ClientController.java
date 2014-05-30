package com.xebia.controller;

import com.xebia.domain.Client;
import com.xebia.domain.ClientList;
import com.xebia.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static org.springframework.http.HttpStatus.*;
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

    @RequestMapping(value = "/" ,method = GET)
    public String hello(){
        return "Hello xebian";
    }

    @RequestMapping(value = "/clients", method = GET)
    public ResponseEntity<ClientList> allClients() {
        List<Client> clients = clientService.findAll();
        clients.add(new Client(1L, "Nico"));
        if(clients.isEmpty()){
            return new ResponseEntity<>(NO_CONTENT);
        }else{
            return new ResponseEntity<>(new ClientList(clients),OK);
        }
    }

    @RequestMapping(value="/client.html", method = RequestMethod.GET)
    public Model getListClients(Model model) {
      model.addAttribute("clients", clientService.findAll());
      return model;
    }

    @RequestMapping(value = "/client", method = GET)
    public Client client(@RequestParam(value = "name") String name) {
        return new Client(idGenerator.incrementAndGet(), name);
    }

    @RequestMapping(value = "/client", method = POST)
    @ResponseStatus(CREATED)
    public Client createClient(@RequestBody final Client client) {
        return clientService.save(client);
    }
}
