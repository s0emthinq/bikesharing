package by.me.bikesharing.command;

import by.me.bikesharing.entity.RouteType;
import by.me.bikesharing.manager.ConfigurationManager;
import by.me.bikesharing.servlet.Router;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ForwardToLogin implements ActionCommand {
    @Override
    public Router execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("role") == null) {
            return new Router(RouteType.FORWARD, ConfigurationManager.getProperty("path.page.login"));
        } else {
            int role = (int) session.getAttribute("role");
            if (role == 1) {
                return new Router(RouteType.FORWARD, ConfigurationManager.getProperty("path.page.bikes"));
            }
            if (role == 0) {
                return new Router(RouteType.FORWARD, ConfigurationManager.getProperty("path.page.orderBike"));
            }
        }
        return new Router(RouteType.FORWARD, ConfigurationManager.getProperty("path.page.login"));
    }
}
