package by.me.bikesharing.dao;

import by.me.bikesharing.entity.Card;
import by.me.bikesharing.exception.DaoException;

import java.math.BigDecimal;
import java.util.List;

public interface CardDao extends BaseDao<Long, Card> {
    boolean depositMoneyOnCard(String serialNumber, BigDecimal amount) throws DaoException;

    Card findBySerialNumber(String serialNumber) throws DaoException;

    List<Card> readAllUserCardByLogin(String login) throws DaoException;
}
