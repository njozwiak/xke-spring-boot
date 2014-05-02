package com.xebia;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class ClientController {

    private final AtomicLong idGenerator = new AtomicLong();

    @RequestMapping(value = "/clients", method = GET)
    public @ResponseBody List<Client> allClients() {
        Client client1 = new Client(idGenerator.incrementAndGet(), "client1");
        Client client2 = new Client(idGenerator.incrementAndGet(), "client2");
        Client client3 = new Client(idGenerator.incrementAndGet(), "client3");

        return Lists.newArrayList(client1, client2, client3);
    }

    @RequestMapping(value = "/client", method = GET)
    public
    @ResponseBody
    Client client(@RequestParam(value = "name") String name) {
        return new Client(idGenerator.incrementAndGet(), name);
    }
}
