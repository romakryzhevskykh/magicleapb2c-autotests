package com.template.hybris.product_cockpit;

import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
public class HybrisProductCockpitSettings {

    @Getter private final String url;
    @Getter private final String username;
    @Getter private final String password;

    public HybrisProductCockpitSettings(String url, String user, String pass) {
        this.url = url;
        this.username = user;
        this.password = pass;
    }
}
