package org.budowa.router;

import java.util.AbstractMap;
import java.util.Map;

public class Routes {
    /**
     * Routes in application
     * Careful the collection is immutable!
     */
    private static final Map<Route, RouteData> routes = Map.ofEntries(
            new AbstractMap.SimpleEntry<>(Route.LOGIN, new RouteData().title("Logowanie")),
            new AbstractMap.SimpleEntry<>(Route.DASHBOARD, new RouteData().title("Dashboard")),
            new AbstractMap.SimpleEntry<>(Route.BUILDING_DETAIL, new RouteData().title("Szczegóły budynku"))
    );

    /**
     * @param route route of a scene
     * @return data of the route
     */
    public static RouteData getRouteData(Route route) {
        return Routes.routes.get(route);
    }


}
