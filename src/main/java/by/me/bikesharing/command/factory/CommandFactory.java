package by.me.bikesharing.command.factory;


import by.me.bikesharing.command.ActionCommand;
import by.me.bikesharing.command.EmptyCommand;
import by.me.bikesharing.command.client.CommandEnum;

import javax.servlet.http.HttpServletRequest;

public class CommandFactory {
    public ActionCommand defineCommand(HttpServletRequest request) {
        ActionCommand current = new EmptyCommand();
        String action = request.getParameter("command");
        if (action == null || action.isEmpty()) {
            return current;
        }

        try {
            CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
            current = currentEnum.getCommand();
        } catch (IllegalArgumentException e) {
            request.setAttribute("wrongCommand", "Command not found or wrong");
        }
        return current;
    }
}