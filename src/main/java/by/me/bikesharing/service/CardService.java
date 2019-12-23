package by.me.bikesharing.service;

import by.me.bikesharing.dao.CardDao;
import by.me.bikesharing.dao.impl.CardDaoImpl;
import by.me.bikesharing.entity.Card;
import by.me.bikesharing.exception.DaoException;
import by.me.bikesharing.exception.ServiceException;

import java.math.BigDecimal;
import java.util.List;

public class CardService {

    private CardDao cardDao = CardDaoImpl.getInstance();

    public boolean depositMoneyOnCard(String serialNumber, BigDecimal amount) throws ServiceException {
        try {
            return cardDao.depositMoneyOnCard(serialNumber, amount);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public List<Card> getAllUserCardsByLogin(String login) throws ServiceException {
        try {
            return cardDao.readAllUserCardByLogin(login);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public long getCardIdBySerialNumber(String serialNumber) throws ServiceException {
        try {
            return cardDao.findBySerialNumber(serialNumber).getId();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public String getSerialNumberByIdCard(long idCard) throws ServiceException {
        try {
            return cardDao.findById(idCard).getSerialNumber();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

}
