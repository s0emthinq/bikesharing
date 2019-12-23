package by.me.bikesharing.dao;

import by.me.bikesharing.entity.Order;
import by.me.bikesharing.exception.DaoException;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;

public interface OrderDao extends BaseDao<Long, Order> {
    Order findByBikeId(long bikeId) throws DaoException;

    long getIdOrderByParameters(long idUser, int idBike, LocalTime beginTime,
                                LocalTime endTime, BigDecimal cost, long cardId) throws DaoException;

    List<Order> getUserOrdersByLogin(String login) throws DaoException;

    boolean payForOrder(String serialNumber, long orgId, BigDecimal cost) throws DaoException;
}
