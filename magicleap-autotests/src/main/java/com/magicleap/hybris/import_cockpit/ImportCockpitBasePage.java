package com.magicleap.hybris.import_cockpit;

import com.magicleap.helpers.BasePageObject;
import com.magicleap.hybris.import_cockpit.models.TemplateImportCockpit;
import org.springframework.beans.factory.annotation.Autowired;

public class ImportCockpitBasePage extends BasePageObject {

    @Autowired protected TemplateImportCockpit importCockpitProject;

    @Override
    public String getPageUrl() {
        return null;
    }
}
