package com.sarnova.hybris.import_cockpit;

import com.sarnova.helpers.BasePageObject;
import com.sarnova.hybris.import_cockpit.models.SarnovaImportCockpit;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ImportCockpitBasePage extends BasePageObject {

    @Autowired protected SarnovaImportCockpit importCockpitProject;
}
