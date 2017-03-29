package vn.framgia.service;

import java.io.Serializable;
import java.util.List;
import vn.framgia.bean.BookingBean;
import vn.framgia.bean.ClientBean;
import vn.framgia.bean.RoomBean;
import vn.framgia.bean.ShowBookingBean;
/**
 * Created by FRAMGIA\duong.van.tien on 13/03/2017.
 */

public interface IBookingService extends Serializable{
	public List<List<ShowBookingBean>> findAllBookingOrderByDesc();
	public List<List<ShowBookingBean>> searchBookingByNameClient(String nameClient);
	public Float calculateTotalPrice(Long days, Float priceOfRoom, List items);
	public boolean addBooking(BookingBean bookingBean, ClientBean clientBean, RoomBean roomBean);
}
