package com.template.site;

import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
public class TemplateProject {

    @Getter private final String url;
    @Getter private final String username;
    @Getter private final String password;

    public TemplateProject(String url, String user, String pass) {
        this.url = url;
        this.username = user;
        this.password = pass;
    }
}
