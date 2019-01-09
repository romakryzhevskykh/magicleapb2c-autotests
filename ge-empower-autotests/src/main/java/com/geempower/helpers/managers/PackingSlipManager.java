package com.geempower.helpers.managers;

import com.geempower.helpers.models.PackingSlip;
import com.geempower.helpers.request_engine.GETRequest;
import com.geempower.helpers.request_engine.POSTRequest;
import com.geempower.helpers.user_engine.UserSession;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.IOException;
import java.util.ArrayList;

@Component
public class PackingSlipManager {
    private POSTRequest PREPARE_PACKING_SLIP_DOCUMENT = new POSTRequest("Prepare packing slop document for downloading.", "packingslip/pdf/prepare/%s");
    private GETRequest DOWNLOAD_PACKING_SLIP_DOCUMENT = new GETRequest("Download packing slip.", "packingslip/pdf/download/%s");

    private ArrayList<PackingSlip> packingSlipList = new ArrayList<>();

    @Step("Create Packing Slip Instance.")
    public void createPackingSlipInstance(String orderId, String orderLine, String dataPackingSlipNumber, String dataPackingBolNumber) {
        packingSlipList.add(new PackingSlip(orderId, orderLine, dataPackingSlipNumber, dataPackingBolNumber));
    }

    @Step("Get Packing Slip By Order Id.")
    public PackingSlip getPackingSlipByOrderId(String orderNo) {
        return packingSlipList.stream().filter(packingSlip -> packingSlip.getOrderId().equals(orderNo)).findAny().orElse(null);
}

    @Step("Prepare Packing Slip Document.")
    public int preparePackingSlipDocument(UserSession userSession, String orderNo, String orderLine, String dataPackingSlipNumber, String dataPackingBolNumber) throws IOException {
        POSTRequest preparePackingSlipDocument = PREPARE_PACKING_SLIP_DOCUMENT.getClone();
        String packingSlipURI = orderNo + "/" + orderLine + "/" + dataPackingBolNumber + "/" + dataPackingSlipNumber;
        preparePackingSlipDocument.setPostString(packingSlipURI);
        preparePackingSlipDocument.sendPostRequest(userSession);
        return preparePackingSlipDocument.getResponse().getResponseCode();
    }

    @Step("Download Packing Slip Document.")
    public int downloadPackingSlipDocument(UserSession userSession, String orderNo, String orderLine, String dataPackingSlipNumber, String dataPackingBolNumber) throws IOException {
        GETRequest downloadPackingSlipDocument = DOWNLOAD_PACKING_SLIP_DOCUMENT.getClone();
        String packingSlipURI = orderNo + "/" + orderLine + "/" + dataPackingBolNumber + "/" + dataPackingSlipNumber;
        downloadPackingSlipDocument.setValue(packingSlipURI);
        downloadPackingSlipDocument.sendGetRequest(userSession);
        return downloadPackingSlipDocument.getResponse().getResponseCode();
    }
}
