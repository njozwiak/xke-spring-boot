package com.xebia.controller;

import com.xebia.domain.Client;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;

public class ClientControllerTestIT {

    @Test
    public void should_list_client() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(APPLICATION_JSON);
        headers.setAccept(asList(APPLICATION_JSON));

        RestTemplate template = new RestTemplate();

        ResponseEntity<Client> entity = template.getForEntity(
                "http://localhost:8080/client?name=test", Client.class);

        assertThat("test").isEqualTo(entity.getBody().getName());
    }
}
