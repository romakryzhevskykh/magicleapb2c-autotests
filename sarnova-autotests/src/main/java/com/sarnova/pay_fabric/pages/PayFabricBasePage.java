package com.sarnova.pay_fabric.pages;

import com.sarnova.helpers.BasePageObject;
import com.sarnova.pay_fabric.models.PayFabric;
import com.sarnova.pay_fabric.page_blocks.LeftBarBlock;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class PayFabricBasePage extends BasePageObject {
    @Autowired PayFabric payFabric;
    @Autowired LeftBarBlock leftBarBlock;
}
