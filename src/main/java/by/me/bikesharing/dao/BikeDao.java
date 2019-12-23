package by.me.bikesharing.dao;


import by.me.bikesharing.entity.Bike;
import by.me.bikesharing.exception.DaoException;

import java.math.BigDecimal;

public interface BikeDao extends BaseDao<Long, Bike> {
    boolean updateBikeWithCheck(Bike bike) throws DaoException;
}
