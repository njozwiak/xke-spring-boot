package com.xebia.controller;

import com.xebia.controller.ClientController;
import com.xebia.domain.Client;
import com.xebia.service.ClientService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ClientControllerTest {

    @Mock
    private ClientService clientService;

    private ClientController clientController;

    @Before
    public void setUp() {
        clientController = new ClientController(clientService);
    }

    @Test
    public void should_create_client() {
        Client savedClient = new Client();
        when(clientService.save(any(Client.class))).thenReturn(savedClient);

        Client clientToTest = new Client();
        Client returnedClient = clientController.createClient(clientToTest);
        verify(clientService, times(1)).save(clientToTest);

        assertThat(savedClient).isEqualTo(returnedClient);

    }

}
