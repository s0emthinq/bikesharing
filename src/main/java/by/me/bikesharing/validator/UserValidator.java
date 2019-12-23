package by.me.bikesharing.validator;

import by.me.bikesharing.dao.BikeDao;
import by.me.bikesharing.dao.UserDao;
import by.me.bikesharing.dao.impl.BikeDaoImpl;
import by.me.bikesharing.dao.impl.UserDaoImpl;
import by.me.bikesharing.entity.User;
import by.me.bikesharing.exception.DaoException;
import by.me.bikesharing.exception.ServiceException;
import com.mysql.cj.util.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserValidator {

    private static final Logger logger = LogManager.getLogger();
    private static UserDao userDao = UserDaoImpl.getInstance();

    public static final String ID_REGEX = "\\d{1,6}";
    public static final String LOGIN_REGEX = "^(?=.{4,15}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$";
    public static final String PASSWORD_REGEX = "^(?=.{4,15}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$";
    public static final String EMAIL_REGEX = ".+\\@.+\\..+";

    public static boolean isParametersNullOrEmpty(String... parameters) {
        for (String parameter : parameters) {
            if (StringUtils.isNullOrEmpty(parameter)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isIdValid(String id) {
        return id.matches(ID_REGEX);
    }

    public static boolean isLoginValid(String login) {
        return login.matches(LOGIN_REGEX);
    }

    public static boolean isPasswordValid(String password) {
        return password.matches(PASSWORD_REGEX);
    }

    public static boolean isUserExists(String login) {
        User emptyUser = new User();
        try {
            return !emptyUser.equals(userDao.findUserByLogin(login));
        } catch (DaoException e) {
            logger.error(e);
            return false;
        }
    }

    public static boolean isUserAdmin(long id) {
        try {
            return userDao.findById(id).getRole() == 1;
        } catch (DaoException e) {
            logger.error("Can't validate if user admin. Returning true(he is admin)", e);
            return true;
        }
    }

    public static boolean isUserExists(long id) {
        User emptyUser = new User();
        try {
            return !emptyUser.equals(userDao.findById(id));
        } catch (DaoException e) {
            logger.error(e);
            return false;
        }
    }

    public static boolean isPasswordsSame(String password, String repeatedPassword) {
        return password.matches(repeatedPassword);
    }

    public static boolean isEmailValid(String email) {
        return email.matches(EMAIL_REGEX);
    }

    public static boolean isUserActive(long id) {
        try {
            return userDao.findById(id).getStatus() == 0;
        } catch (DaoException e) {
            logger.error("Can't validate if user is active. Returning false", e);
            return false;
        }
    }

    public static boolean isUserActive(String login) {
        try {
            return userDao.findUserByLogin(login).getStatus() == 0;
        } catch (DaoException e) {
            logger.error("Can't validate if user is active. Returning false", e);
            return false;
        }
    }

    public static boolean isUserHasCard(String login){
        try {
            return userDao.findUserByLogin(login).getCardId() == 0;
        } catch (DaoException e) {
            logger.error("Can't validate if user has card. Returning false", e);
            return false;
        }
    }
}
