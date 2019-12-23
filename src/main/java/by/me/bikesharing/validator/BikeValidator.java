package by.me.bikesharing.validator;

import by.me.bikesharing.dao.impl.BikeDaoImpl;
import by.me.bikesharing.entity.Bike;
import by.me.bikesharing.exception.DaoException;
import by.me.bikesharing.exception.ServiceException;
import by.me.bikesharing.service.BikeService;
import com.mysql.cj.util.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;


public class BikeValidator {

    private static final Logger logger = LogManager.getLogger();

    public static final String ID_REGEX = "\\d{1,6}";
    public static final String COORDINATES_REGEX = "\\d{2}.\\d{2,4}";
    public static final String COST_PER_HOUR_REGEX = "\\d{0,2}(\\.\\d{1,2})?";
    public static final String STATUS_REGEX = "[0-1]";
    public static final double MIN_MINSK_LATITUDE = 53.8501;
    public static final double MAX_MINSK_LATITUDE = 53.9501;
    public static final double MIN_MINSK_LONGITUDE = 27.4531;
    public static final double MAX_MINSK_LONGITUDE = 27.6401;

    private static final BikeDaoImpl bikeDao = BikeDaoImpl.getInstance();
    private static final BikeService bikeService = new BikeService();

    public static boolean isParametersNullOrEmpty(String... parameters) {
        for (String parameter : parameters) {
            if (StringUtils.isNullOrEmpty(parameter)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isParametersValid(String latitudeAsString, String longitudeAsString, String costPerHourAsString,
                                            String statusAsString, String organisationIdAsString) {
        return isLatitudeValid(latitudeAsString) && isLongitudeValid(longitudeAsString)
                && isCostPerHourValid(costPerHourAsString) && isStatusValid(statusAsString)
                && isOrganisationIdValid(organisationIdAsString);
    }

    public static boolean isIdValid(String id) {
        return id.matches(ID_REGEX);
    }

    public static boolean isLatitudeValid(String latitude) {
        if (latitude.matches(COORDINATES_REGEX)) {
            return Double.parseDouble(latitude) >= MIN_MINSK_LATITUDE && Double.parseDouble(latitude) <= MAX_MINSK_LATITUDE;
        } else {
            return false;
        }
    }

    public static boolean isLongitudeValid(String longitude) {
        if (longitude.matches(COORDINATES_REGEX)) {
            return Double.parseDouble(longitude) >= MIN_MINSK_LONGITUDE && Double.parseDouble(longitude) <= MAX_MINSK_LONGITUDE;
        } else {
            return false;
        }
    }

    public static boolean isCostPerHourValid(String costPerHour) {
        return costPerHour.matches(COST_PER_HOUR_REGEX);
    }

    public static boolean isStatusValid(String status) {
        return status.matches(STATUS_REGEX);
    }

    public static boolean isOrganisationIdValid(String idOrganisation) {
        return idOrganisation.matches(ID_REGEX);
    }

    public static boolean isBikeWithSuchIdExist(long id) {

        Bike emptyBike = new Bike();
        try {
            return !emptyBike.equals(bikeDao.findById(id));
        } catch (DaoException e) {
            logger.error("Can't validate if bike is exists");
        }
        return false;
    }

    public static boolean isBikeFree(long id) {
        try {
            return bikeDao.findById(id).getStatus() == 0;
        } catch (DaoException e) {
            logger.error("Can't validate if bike is free. Returning false");
        }
        return false;
    }

    public static boolean isBikeAlreadyHasSuchParameters(long id, double latitude, double longitude, double costPerHour,
                                                         int status, long idOrganisation) {
        Bike bike = new Bike(id, latitude, longitude, costPerHour, status, idOrganisation);
        try {
            Bike foundBike = bikeDao.findById(id);
            return bike.equals(foundBike);
        } catch (DaoException e) {
            logger.error("Can't validate if bike already has such parameters. Returning false");
            return false;
        }
    }

    public static boolean isBikeCoordinatesUnique(double latitude, double longitude) {
        try {
            List<Bike> bikes = bikeService.readAllBikes();
            for (Bike bike : bikes) {
                if (bike.getLatitude() == latitude && bike.getLongitude() == longitude) {
                    return false;
                }
            }
        } catch (ServiceException e) {
            logger.error("Can't validate if bike is free. Returning false");
            return false;
        }
        return true;
    }
}
