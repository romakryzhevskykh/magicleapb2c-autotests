package com.sarnova.pay_fabric.page_blocks;

import com.sarnova.helpers.UIComponent;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.sarnova.pay_fabric.page_block_elements.HeaderBlockelements.*;

@Component
public class PayFabricHeaderBlock extends UIComponent {

    @Step("Is Sandbox in live key?")
    public boolean isSandboxInLiveKey() {
        try {
            return $(By.id(SANDBOX_LIVE_STATUS_ID)).getAttribute("checked").equals("true");
        } catch (NullPointerException ex) {
            return false;
        }
    }

    @Step("Change key status.")
    public void changeKeyStatus() {
        click(CHANGE_LIVE_KEY_XPATH);
        waitUntilPageIsFullyLoaded();
    }

    @Step("Set Sandbox to non live key.")
    public void setNonLiveKey() {
        if (isSandboxInLiveKey()) {
            changeKeyStatus();
        }
    }
}
