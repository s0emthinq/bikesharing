package by.me.bikesharing.entity;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Objects;

public class Order extends Entity {

    private long id;
    private long idUser;
    private long idBike;
    private LocalTime beginTime;
    private LocalTime endTime;
    private BigDecimal cost;
    private LocalTime returnTime;
    private BigDecimal debt;
    private int status;
    private long idCard;

    public Order() {
    }

    public Order(long id, long idUser, long idBike, LocalTime beginTime, LocalTime endTime,
                 BigDecimal cost, LocalTime returnTime, BigDecimal debt, int status, long idCard) {
        this.id = id;
        this.idUser = idUser;
        this.idBike = idBike;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.cost = cost;
        this.returnTime = returnTime;
        this.debt = debt;
        this.status = status;
        this.idCard = idCard;
    }

    public Order(long idUser, long idBike, LocalTime beginTime, LocalTime endTime,
                 BigDecimal cost, LocalTime returnTime, BigDecimal debt, int status, long idCard) {
        this.idUser = idUser;
        this.idBike = idBike;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.cost = cost;
        this.returnTime = returnTime;
        this.debt = debt;
        this.status = status;
        this.idCard = idCard;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public long getIdBike() {
        return idBike;
    }

    public void setIdBike(long idBike) {
        this.idBike = idBike;
    }

    public LocalTime getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(LocalTime beginTime) {
        this.beginTime = beginTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public LocalTime getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(LocalTime returnTime) {
        this.returnTime = returnTime;
    }

    public BigDecimal getDebt() {
        return debt;
    }

    public void setDebt(BigDecimal debt) {
        this.debt = debt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getIdCard() {
        return idCard;
    }

    public void setIdCard(long idCard) {
        this.idCard = idCard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return idUser == order.idUser &&
                idBike == order.idBike &&
                status == order.status &&
                idCard == order.idCard &&
                Objects.equals(beginTime, order.beginTime) &&
                Objects.equals(endTime, order.endTime) &&
                Objects.equals(cost, order.cost) &&
                Objects.equals(returnTime, order.returnTime) &&
                Objects.equals(debt, order.debt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, idBike, beginTime, endTime, cost, returnTime, debt, status, idCard);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Order{");
        sb.append("id=").append(id);
        sb.append(", idUser=").append(idUser);
        sb.append(", idBike=").append(idBike);
        sb.append(", beginTime=").append(beginTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", cost=").append(cost);
        sb.append(", returnTime=").append(returnTime);
        sb.append(", debt=").append(debt);
        sb.append(", status=").append(status);
        sb.append(", idCard=").append(idCard);
        sb.append('}');
        return sb.toString();
    }
}
