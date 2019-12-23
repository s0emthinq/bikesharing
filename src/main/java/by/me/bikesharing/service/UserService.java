package by.me.bikesharing.service;

import by.me.bikesharing.dao.UserDao;
import by.me.bikesharing.dao.impl.UserDaoImpl;
import by.me.bikesharing.entity.Order;
import by.me.bikesharing.entity.User;
import by.me.bikesharing.exception.DaoException;
import by.me.bikesharing.exception.ServiceException;
import by.me.bikesharing.validator.BikeValidator;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Random;

public class UserService {

    private static final Logger logger = LogManager.getLogger();

    private UserDao userDao = UserDaoImpl.getInstance();

    public User findUserByLogin(String login) throws ServiceException {
        try {
            return userDao.findUserByLogin(login);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public boolean registerUser(String login, String password, String email) throws ServiceException {
        String hashedPassword = hashUserPassword(password);
        User user = new User(login, hashedPassword, email, 0, 1, "E:\\login\\src\\main\\webapp\\img\\images.png", 0); //fixme
        try {
            return userDao.create(user);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public boolean isLoginMatchesPassword(String login, String password) {
        User user;
        try {
            user = userDao.findUserByLogin(login);
            String hashedPassword = hashUserPassword(password);
            return login.equals(user.getLogin()) && hashedPassword.equals(user.getPassword());
        } catch (DaoException e) {
            logger.error("Can't check if login matches password. Returning false", e);
            return false;
        }
    }

    public static double[] generateRandomCoordinatesWithinMinsk() {
        double coordinates[] = new double[2];
        double minLatitude = BikeValidator.MIN_MINSK_LATITUDE;
        double maxLatitude = BikeValidator.MAX_MINSK_LATITUDE;
        double minLongitude = BikeValidator.MIN_MINSK_LONGITUDE;
        double maxLongitude = BikeValidator.MAX_MINSK_LONGITUDE;
        Random r = new Random();
        double latitude = minLatitude + (maxLatitude - minLatitude) * r.nextDouble();
        double longitude = minLongitude + (maxLongitude - minLongitude) * r.nextDouble();
        coordinates[0] = latitude;
        coordinates[1] = longitude;
        return coordinates;
    }

    public List<User> readAllUsers() throws ServiceException {
        try {
            return userDao.readAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public String hashUserPassword(String password) {
        return DigestUtils.md5Hex(password);
    }

    public boolean blockUser(long id) throws ServiceException {
        try {
            return userDao.updateUserStatusById(id, 1);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public boolean unblockUser(long id) throws ServiceException {
        try {
            return userDao.updateUserStatusById(id, 0);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }


}