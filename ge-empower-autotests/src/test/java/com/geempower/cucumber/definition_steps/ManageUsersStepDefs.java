package com.geempower.cucumber.definition_steps;

import com.geempower.helpers.managers.RegionsManager;

import com.geempower.storefront.page_blocks.IwantToBlock;
import com.geempower.storefront.pages.ManageUsersPage;

import org.springframework.beans.factory.annotation.Autowired;


public class ManageUsersStepDefs extends AbstractStepDefs {
    @Autowired
    private ManageUsersPage manageUsersPage;
    @Autowired
    private IwantToBlock iWantToBlock;
    @Autowired
    private RegionsManager regionsManager;


}