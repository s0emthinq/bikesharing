package by.me.bikesharing.command;

import by.me.bikesharing.entity.RouteType;
import by.me.bikesharing.manager.ConfigurationManager;
import by.me.bikesharing.servlet.Router;

import javax.servlet.http.HttpServletRequest;

public class ForwardToUpdateBikeFormCommand implements ActionCommand {

    @Override
    public Router execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty("path.page.updateBike");
        return new Router(RouteType.FORWARD, page);
    }
}
