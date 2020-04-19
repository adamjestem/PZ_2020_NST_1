package org.budowa.flow.owner;

import org.budowa.entities.Building;
import org.budowa.flow.shared.DashboardBaseController;
import org.budowa.services.BuildingsService;

public class OwnerDashboardController extends DashboardBaseController {

    BuildingsService buildingsService = BuildingsService.create();

    @Override
    protected Building[] loadBuildings() {
        return this.buildingsService.getAllBuildings();
    }
}
