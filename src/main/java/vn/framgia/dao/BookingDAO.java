package vn.framgia.dao;

import vn.framgia.model.Booking;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import vn.framgia.bean.BookingBean;
import vn.framgia.model.Booking;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by FRAMGIA\duong.van.tien on 13/03/2017.
 */
public class BookingDAO extends GenericDAO<Booking, Integer>implements IBookingDAO{

    public BookingDAO() {
        super.setPersistentClass(Booking.class);
    }
}
