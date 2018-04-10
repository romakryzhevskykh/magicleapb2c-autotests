package com.topcon.hybris.import_cockpit;

import com.topcon.helpers.BasePageObject;
import com.topcon.hybris.import_cockpit.models.TopconImportCockpit;
import org.springframework.beans.factory.annotation.Autowired;

public class ImportCockpitBasePage extends BasePageObject {

    @Autowired protected TopconImportCockpit importCockpitProject;

    @Override
    public String getPageUrl() {
        return null;
    }
}
