package vn.framgia.dao;

import vn.framgia.model.Booking;
import java.util.List;
import vn.framgia.model.Booking;
/**
 * Created by FRAMGIA\duong.van.tien on 13/03/2017.
 *
 */
public interface IBookingDAO extends IGenericDAO<Booking, Integer>{
	public List<Booking> findAllOrderClientId();
	public List<Booking> findBillByNameClient(String nameClient);
}
