package com.xebia.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app.client")
public class ClientProperties {
    private Boolean orderByName = false;

    public Boolean isOrderByName() {
        return orderByName;
    }

    public void setOrderByName(Boolean orderByName) {
        this.orderByName = orderByName;
    }
}
