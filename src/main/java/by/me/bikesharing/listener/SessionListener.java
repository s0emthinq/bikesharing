package by.me.bikesharing.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        session.setAttribute("language", "en_US");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        //fixme
    }
}
