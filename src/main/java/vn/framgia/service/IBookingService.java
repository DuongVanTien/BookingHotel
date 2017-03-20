package vn.framgia.service;

import java.io.Serializable;
import java.util.List;
import vn.framgia.bean.ShowBookingBean;
/**
 * Created by FRAMGIA\duong.van.tien on 13/03/2017.
 */

public interface IBookingService extends Serializable{
	public List<List<ShowBookingBean>> findAllBookingOrderByDesc();
	public List<List<ShowBookingBean>> searchBookingByNameClient(String nameClient);
	public Float calculateTotalPrice(Long days, Float priceOfRoom, List items);
}
