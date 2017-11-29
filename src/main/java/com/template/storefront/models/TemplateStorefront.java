package com.template.storefront.models;

public class TemplateStorefront {
    private String startUrl;
    private String loginUrl;
    private String homeUrl;
    private String shippingAddressBookUrl;

    public TemplateStorefront(String startUrl, String loginUrl, String homeUrl, String shippingAddressBookUrl) {
        this.startUrl = startUrl;
        this.loginUrl = loginUrl;
        this.homeUrl = homeUrl;
        this.shippingAddressBookUrl = shippingAddressBookUrl;
    }

    public String getStartUrl() {
        return startUrl;
    }

    public String getLoginUrl() {
        return loginUrl;
    }

    public String getHomeUrl() {
        return homeUrl;
    }

    public String getShippingAddressBookUrl() {
        return shippingAddressBookUrl;
    }
}
