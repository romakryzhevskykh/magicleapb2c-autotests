package com.template.hybris.import_cockpit;

import com.template.helpers.BasePageObject;
import com.template.hybris.import_cockpit.models.TemplateImportCockpit;
import org.springframework.beans.factory.annotation.Autowired;

public class ImportCockpitBasePage extends BasePageObject {

    @Autowired protected TemplateImportCockpit importCockpitProject;
}
