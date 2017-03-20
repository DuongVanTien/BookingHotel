package vn.framgia.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tienduongvan on 12/03/2017.
 */
public class UsedServiceBean implements Serializable {
    private Integer id;
    private Integer bookingId;
    private Integer serviceId;

    private List<Integer> servicesId = new ArrayList<Integer>();

    public List<Integer> getServicesId() {
        return servicesId;
    }

    public void setServicesId(List<Integer> servicesId) {
        this.servicesId = servicesId;
    }

    public UsedServiceBean() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }
}
