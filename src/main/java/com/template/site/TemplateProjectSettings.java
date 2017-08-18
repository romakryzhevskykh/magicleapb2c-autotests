package com.template.site;

import lombok.Getter;

public class TemplateProjectSettings {

    @Getter private final String url;
    @Getter private final String username;
    @Getter private final String password;

    public TemplateProjectSettings(String url, String user, String pass) {
        this.url = url;
        this.username = user;
        this.password = pass;
    }
}
