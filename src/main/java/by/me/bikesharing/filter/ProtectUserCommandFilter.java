package by.me.bikesharing.filter;

import by.me.bikesharing.command.client.CommandEnum;
import by.me.bikesharing.manager.ConfigurationManager;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ProtectUserCommandFilter implements Filter {

    private static final String PARAM_NAME_COMMAND = "command";
    private static final String ATTR_NAME_CURRENT_ROLE = "role";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String command = servletRequest.getParameter(PARAM_NAME_COMMAND);
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        if (command != null) {
            command = command.toUpperCase();
            if (command.equals(CommandEnum.FORWARD_TO_ORDER_BIKE.toString())
                    || command.equals(CommandEnum.ORDER_BIKE.toString())
                    || command.equals(CommandEnum.SHOW_ALL_USER_ORDERS.toString())
                    || command.equals(CommandEnum.FINISH_ORDER.toString())
                    || command.equals(CommandEnum.MAKE_DEPOSIT.toString())
            ) {
                if (session.getAttribute(ATTR_NAME_CURRENT_ROLE) != null) {
                    int role = (int) session.getAttribute(ATTR_NAME_CURRENT_ROLE);
                    if (role != 0) {
                        String page = ConfigurationManager.getProperty("path.page.login");
                        ((HttpServletResponse) servletResponse).sendRedirect(page);
                    }
                }
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
    @Override
    public void destroy() {
    }
}
