package by.me.bikesharing.entity;

import by.me.bikesharing.dao.CardDao;

import java.math.BigDecimal;
import java.util.Objects;

public class Card extends Entity {
    private long id;
    private String serialNumber;
    private BigDecimal balance;
    private long idUser;

    public Card() {

    }

    public Card(long id, String serialNumber, BigDecimal balance, long idUser) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.balance = balance;
        this.idUser = idUser;
    }

    public Card(String serialNumber, BigDecimal balance, long idUser) {
        this.serialNumber = serialNumber;
        this.balance = balance;
        this.idUser = idUser;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return idUser == card.idUser &&
                Objects.equals(serialNumber, card.serialNumber) &&
                Objects.equals(balance, card.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialNumber, balance, idUser);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Card{");
        sb.append("id=").append(id);
        sb.append(", serialNumber='").append(serialNumber).append('\'');
        sb.append(", balance=").append(balance);
        sb.append(", idUser=").append(idUser);
        sb.append('}');
        return sb.toString();
    }
}
