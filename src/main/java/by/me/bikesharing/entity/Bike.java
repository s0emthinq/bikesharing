package by.me.bikesharing.entity;

import java.util.Objects;

public class Bike extends Entity {
    private long id;
    private double latitude;
    private double longitude;
    private double costPerHour;
    private int status;
    private long idOrganisation;

    public Bike() {
    }

    public Bike(long id, double latitude, double longitude, double costPerHour, int status, long idOrganisation) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.costPerHour = costPerHour;
        this.status = status;
        this.idOrganisation = idOrganisation;
    }

    public Bike(double latitude, double longitude, double costPerHour, int status, long idOrganisation) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.costPerHour = costPerHour;
        this.status = status;
        this.idOrganisation = idOrganisation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getCostPerHour() {
        return costPerHour;
    }

    public void setCostPerHour(double costPerHour) {
        this.costPerHour = costPerHour;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getIdOrganisation() {
        return idOrganisation;
    }

    public void setIdOrganisation(long idOrganisation) {
        this.idOrganisation = idOrganisation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bike bike = (Bike) o;
        return Double.compare(bike.latitude, latitude) == 0 &&
                Double.compare(bike.longitude, longitude) == 0 &&
                Double.compare(bike.costPerHour, costPerHour) == 0 &&
                status == bike.status &&
                idOrganisation == bike.idOrganisation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude, costPerHour, status, idOrganisation);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Bike{");
        sb.append("id=").append(id);
        sb.append(", latitude=").append(latitude);
        sb.append(", longitude=").append(longitude);
        sb.append(", costPerHour=").append(costPerHour);
        sb.append(", status=").append(status);
        sb.append(", idOrganisation=").append(idOrganisation);
        sb.append('}');
        return sb.toString();
    }
}
