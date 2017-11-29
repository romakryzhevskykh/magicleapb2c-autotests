package com.template.storefront.pages;

import com.template.helpers.BasePageObject;
import com.template.storefront.models.TemplateStorefront;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class StorefrontBasePage extends BasePageObject {
    @Autowired TemplateStorefront storefrontProject;
}
