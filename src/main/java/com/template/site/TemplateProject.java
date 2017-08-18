package com.template.site;

import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
public class TemplateProject {
    @Getter private TemplateProjectSettings templateProjectSettings;

    public TemplateProject(TemplateProjectSettings templateProjectSettings) {
        this.templateProjectSettings = templateProjectSettings;
    }

}
