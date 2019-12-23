package by.me.bikesharing.dao;

import by.me.bikesharing.entity.Entity;
import by.me.bikesharing.exception.DaoException;
import by.me.bikesharing.pool.CustomConnectionPool;
import by.me.bikesharing.pool.ProxyConnection;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public interface BaseDao<K, T extends Entity> {

    List<T> readAll() throws DaoException;

    T findById(K id) throws DaoException;

    boolean create(T t) throws DaoException;

    boolean delete(T t) throws DaoException;

    boolean delete(K id) throws DaoException;

    T update(T t) throws DaoException;

    default void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                // fixme throw new DaoException(e)?
            }
        }
    }

    default void close(ProxyConnection connection) {
        if (connection != null) {
            CustomConnectionPool.INSTANCE.releaseConnection(connection);
        }
    }
}
