package com.xebia.service;

import com.xebia.DefaultConfig;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DefaultConfig.class, loader = SpringApplicationContextLoader.class)
public class ClientServiceTestIT {

    @Inject
    private ClientService clientService;

    @Test
    public void should_environment_be_test() {
        Assertions.assertThat(clientService.getEnvironment()).isEqualTo("test");
    }
}
