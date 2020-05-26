package org.budowa.flow;

import org.budowa.flow.buildings.EditBuildingScene;
import org.budowa.flow.raports.WorkStatusRaportScene;
import org.budowa.flow.users.AddUserScene;
import org.budowa.flow.users.UsersListScene;
import org.budowa.flow.worker.WorkerDashboardScene;
import org.budowa.flow.buildings.AddBuildingScene;

import java.util.AbstractMap;
import java.util.Map;

public class FlowsRegistry {
    private static final Map<Flow, String> registry = Map.ofEntries(
            new AbstractMap.SimpleEntry<>(Flow.LOGIN, "LoginScene"),
            new AbstractMap.SimpleEntry<>(Flow.MANAGER_DASHBOARD, "ManagerDashboardScene"),
            new AbstractMap.SimpleEntry<>(Flow.OWNER_DASHBOARD, "OwnerDashboardScene"),
            new AbstractMap.SimpleEntry<>(Flow.BUILDING_DETAIL, "BuildingDetailScene"),
            new AbstractMap.SimpleEntry<>(Flow.WORKER_DASHBOARD, WorkerDashboardScene.class.getSimpleName()),
            new AbstractMap.SimpleEntry<>(Flow.ADD_CONSTRUCTION, AddBuildingScene.class.getSimpleName()),
            new AbstractMap.SimpleEntry<>(Flow.ADD_USER, AddUserScene.class.getSimpleName()),
            new AbstractMap.SimpleEntry<>(Flow.EDIT_BUILDING, EditBuildingScene.class.getSimpleName()),
            new AbstractMap.SimpleEntry<>(Flow.USERS_LIST, UsersListScene.class.getSimpleName()),
            new AbstractMap.SimpleEntry<>(Flow.EDIT_USER, AddUserScene.class.getSimpleName()),
            new AbstractMap.SimpleEntry<>(Flow.WORK_STATUS_RAPORT, WorkStatusRaportScene .class.getSimpleName())
    );

    public static String getFXML(Flow flow) {
        return FlowsRegistry.registry.get(flow);
    }
}
