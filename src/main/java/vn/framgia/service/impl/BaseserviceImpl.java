package vn.framgia.service.impl;

import vn.framgia.dao.*;

/**
 * Created by FRAMGIA\duong.van.tien on 06/03/2017.
 *
 */
public class BaseserviceImpl {

    protected IUserDAO userDAO;
    protected IRoomDAO roomDAO;
    protected IServiceDAO serviceDAO;
    protected IBookingDAO bookingDAO;

    public IUserDAO getUserDAO() {
        return null;
    }

    public void setUserDAO(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public IRoomDAO getRoomDAO() {
        return roomDAO;
    }

    public void setRoomDAO(IRoomDAO roomDAO) {
        this.roomDAO = roomDAO;
    }

    public IServiceDAO getServiceDAO() {
        return serviceDAO;
    }

    public void setServiceDAO(IServiceDAO serviceDAO) {
        this.serviceDAO = serviceDAO;
    }

    public IBookingDAO getBookingDAO() {
        return bookingDAO;
    }

    public void setBookingDAO(IBookingDAO bookingDAO) {
        this.bookingDAO = bookingDAO;
    }
}
