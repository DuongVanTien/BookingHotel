package vn.framgia.model;

import java.io.Serializable;
import java.util.*;
import java.util.Date;
/**
 * Created by tienduongvan on 27/02/2017.
 *
 */
public class Booking implements Serializable {

    private Integer id;
    private Date checkin;
    private Date checkout;
    private Float totalPrice;
    private String note;
    private Integer isCheckin;
    private Client client;
    private Room room;
    private Set<Service> services = new HashSet<Service>();

    public Booking() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getIsCheckin() {
        return isCheckin;
    }

    public void setIsCheckin(Integer isCheckin) {
        this.isCheckin = isCheckin;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Set<Service> getServices() {
        return services;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }
}
