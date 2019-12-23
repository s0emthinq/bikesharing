package by.me.bikesharing.validator;

import by.me.bikesharing.dao.BikeDao;
import by.me.bikesharing.dao.OrderDao;
import by.me.bikesharing.dao.UserDao;
import by.me.bikesharing.dao.impl.OrderDaoImpl;
import by.me.bikesharing.dao.impl.UserDaoImpl;
import by.me.bikesharing.entity.Order;
import by.me.bikesharing.exception.DaoException;
import by.me.bikesharing.service.OrderService;
import com.mysql.cj.util.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.time.LocalTime;

public class OrderValidator {

    private static final Logger logger = LogManager.getLogger();

    public static final String TIME_REGEX = "^(?:\\d|[01]\\d|2[0-3]):[0-5]\\d$";

    public static boolean isParametersNullOrEmpty(String... parameters) {
        for (String parameter : parameters) {
            if (StringUtils.isNullOrEmpty(parameter)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isTimeValid(String time) {
        return time.matches(TIME_REGEX);
    }

    public static boolean isEndTimeAfterBeginTime(LocalTime beginTime, LocalTime endTime) {
        return endTime.isAfter(beginTime);
    }



    public static boolean isOrderFinished(long orderId) {
        final OrderDao orderDao = OrderDaoImpl.getInstance();
        try {
            Order order = orderDao.findById(orderId);
            return order.getStatus() == 1 && order.getReturnTime() != null;
        } catch (DaoException e) {
            logger.error("Can't validate if order is active. Returning false", e);
        }
        return false;
    }
}
