package org.budowa.router;

/**
 * Builder pattern
 */
public class RouteData {
    public String title;

    public RouteData title(String title) {
        this.title = title;
        return this;
    }
}
