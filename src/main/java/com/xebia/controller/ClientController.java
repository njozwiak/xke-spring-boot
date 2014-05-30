package com.xebia.controller;

import com.xebia.domain.Client;
import com.xebia.domain.ClientList;
import com.xebia.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

// TODO 1.4 : Déclarer cette classe en RestController
public class ClientController {

    private final AtomicLong idGenerator = new AtomicLong();

    // TODO 1.5 : Injecter le ClientService

    @Inject
    public ClientController() {

    }

    @RequestMapping(value = "/" ,method = GET)
    public String hello(){
        return "Hello xebian";
    }

    @RequestMapping(value = "/clients", method = GET, produces = { "application/json", "application/xml" })
    public ResponseEntity<ClientList> allClients() {
        // TODO 1.5 : Utiliser le service ClientService.findAll()

        List<Client> clients = getClients();

        if(clients.isEmpty()){
            return new ResponseEntity<>(NO_CONTENT);
        }else{
            return new ResponseEntity<>(new ClientList(clients),OK);
        }
    }

    @RequestMapping(value="/client.html", method = RequestMethod.GET)
    public Model getListClients(Model model) {
      // TODO 1.5 : Utiliser le service ClientService.findAll()

      model.addAttribute("clients", getClients());
      return model;
    }

    private List<Client> getClients() {
        List<Client> clients = new ArrayList<>();
        clients.add(new Client(1L, "Federer"));
        clients.add(new Client(2L, "Nadal"));
        clients.add(new Client(3L, "Tsonga"));
        return clients;
    }

    @RequestMapping(value = "/client", method = GET, produces = { "application/json", "application/xml" })
    public Client client(@RequestParam(value = "name") String name) {
        return new Client(idGenerator.incrementAndGet(), name);
    }

    @RequestMapping(value = "/client", method = POST)
    @ResponseStatus(CREATED)
    public Client createClient(@RequestBody final Client client) {
        // TODO 1.5 : Utiliser le service ClientService.save

        return null;
    }
}
