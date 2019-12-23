package by.me.bikesharing.command;

import by.me.bikesharing.servlet.Router;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface ActionCommand {
    Router execute(HttpServletRequest request);
}