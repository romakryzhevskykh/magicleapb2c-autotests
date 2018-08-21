package com.geempower.hybris.hac.models;

import com.geempower.hybris.Cockpit;
import com.geempower.hybris.hac.pages.*;
import org.springframework.beans.factory.annotation.Autowired;

public class TemplateHAC extends Cockpit {
    private HacActiveNode hacActiveNode;

    public TemplateHAC(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Autowired
    private HacLoginPage loginPage;

    public void setHacActiveNode(HacActiveNode hacActiveNode) {
        this.hacActiveNode = hacActiveNode;
    }

    public String getHacActiveNode(){
        return String.valueOf(this.hacActiveNode);
    }

    @Override
    public String getBaseUrl() {
        return String.format(this.baseUrl, hacActiveNode.getNodeValue());
    }

    @Override
    public String getLoginUrl() {
        return loginPage.getPageUrl();
    }
}
