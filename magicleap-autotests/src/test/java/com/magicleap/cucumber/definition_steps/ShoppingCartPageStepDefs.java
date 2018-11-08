package com.magicleap.cucumber.definition_steps;

import com.magicleap.helpers.managers.users.UserSessions;
import com.magicleap.storefront.page_blocks.HeaderRowPageBlock;
import com.magicleap.storefront.pages.LoginPage;
import org.springframework.beans.factory.annotation.Autowired;

public class ShoppingCartPageStepDefs extends AbstractStepDefs {
    @Autowired UserSessions userSessions;
    @Autowired LoginPage loginPage;
    @Autowired HeaderRowPageBlock headerRowPageBlock;
}
