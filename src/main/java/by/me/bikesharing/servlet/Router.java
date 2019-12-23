package by.me.bikesharing.servlet;

import by.me.bikesharing.entity.RouteType;

public class Router {

    private RouteType routeType;
    private String page;

    public Router() {

    }

    public Router(RouteType routeType, String page) {
        this.routeType = routeType;
        this.page = page;
    }

    public RouteType getRouteType() {
        return routeType;
    }

    public void setRouteType(RouteType routeType) {
        this.routeType = routeType;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
}
