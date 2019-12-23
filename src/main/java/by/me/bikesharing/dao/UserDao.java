package by.me.bikesharing.dao;

import by.me.bikesharing.entity.Order;
import by.me.bikesharing.entity.User;
import by.me.bikesharing.exception.DaoException;

import java.math.BigDecimal;
import java.util.List;

public interface UserDao extends BaseDao<Long, User> {
    User findUserByLogin(String login) throws DaoException;

    BigDecimal getUserBalanceByLogin(String login) throws DaoException;

    boolean updateUserBalanceByLogin(String login, BigDecimal newBalance) throws DaoException;

    boolean updateUserStatusById(long id, int status) throws DaoException;
}
