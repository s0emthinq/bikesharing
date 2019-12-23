package by.me.bikesharing.command;

import by.me.bikesharing.command.client.CommandEnum;
import by.me.bikesharing.entity.RouteType;
import by.me.bikesharing.manager.ConfigurationManager;
import by.me.bikesharing.manager.TextManager;
import by.me.bikesharing.servlet.Router;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ChangeLanguageCommand implements ActionCommand {
    @Override
    public Router execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String language = (String) session.getAttribute("language");
        if ("en_US".equals(language)) {
            session.setAttribute("language", "ru_RU");
        } else {
            session.setAttribute("language", "en_US");
        }

        if (session.getAttribute("role") == null) {
            return new Router(RouteType.FORWARD, ConfigurationManager.getProperty("path.page.login"));
        }

        if ((int) session.getAttribute("role") == 1) {
            return CommandEnum.SHOW_ALL_BIKES.getCommand().execute(request);
        } else {
            return CommandEnum.FORWARD_TO_ORDER_BIKE.getCommand().execute(request);
        }
    }
}
