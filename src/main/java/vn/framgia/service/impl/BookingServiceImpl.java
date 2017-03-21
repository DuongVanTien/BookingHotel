package vn.framgia.service.impl;

import vn.framgia.bean.ItemBean;
import vn.framgia.service.IBookingService;

/**
 * Created by FRAMGIA\duong.van.tien on 13/03/2017.
 */
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import vn.framgia.bean.ShowBookingBean;
import vn.framgia.model.Booking;
import vn.framgia.service.IBookingService;
import vn.framgia.util.Helpers;

public class BookingServiceImpl extends BaseserviceImpl implements IBookingService {
	private static final Logger logger = Logger.getLogger(BookingServiceImpl.class);

	public List<List<ShowBookingBean>> showBooking(List<Booking> listBooking) {
		try {
			List<List<ShowBookingBean>> results = new ArrayList<List<ShowBookingBean>>();
			if (!Helpers.isEmpty(listBooking)) {
				List<ShowBookingBean> listObj = null;
				ShowBookingBean bookingBean = null;
				int buffer = 0;
				for (Booking booking : listBooking) {
					if(buffer != booking.getClient().getId() && buffer != 0) {
						results.add(listObj);
					}
					if(buffer != booking.getClient().getId()){
						listObj = new ArrayList<ShowBookingBean>();
					}
					bookingBean = new ShowBookingBean();
					bookingBean.setNameClient(booking.getClient().getFullName());
					bookingBean.setNameRoom(booking.getRoom().getName());
					bookingBean.setCheckIn(Helpers.convertDatetoString(booking.getCheckIn()));
					bookingBean.setCheckOut(Helpers.convertDatetoString(booking.getCheckOut()));
					bookingBean.setPriceRoom(booking.getTotalPrice());
					bookingBean.setStatus(false);//TODO
					
					listObj.add(bookingBean);
					buffer = booking.getClient().getId();
				}
				results.add(listObj);
				return results;
			}
		} catch (Exception e) {
			logger.error(e);
		}
		return null;
	}

	@Override
	public List<List<ShowBookingBean>> findAllBookingOrderByDesc() {
		try{
			List<Booking> listBooking = bookingDAO.findAllOrderClientId();
			if(!Helpers.isEmpty(listBooking)){
				return showBooking(listBooking);
			}
		}catch(Exception e){
			logger.error(e);
		}
		return null;
	}
	
	@Override
	public List<List<ShowBookingBean>> searchBookingByNameClient(String nameClient) {
		try {
			List<Booking> listBooking = bookingDAO.findBillByNameClient(nameClient);
			if (!Helpers.isEmpty(listBooking)) {
				return showBooking(listBooking);
			}
		} catch (Exception e) {
			logger.error(e);
		}
		return null;
	}

	@Override
	public Float calculateTotalPrice(Long days, Float priceOfRoom, List items) {
		Float totalPriceOfRoom = days*priceOfRoom;
		if(items.size() < 0) {
			return totalPriceOfRoom;
		}
		Float totalPriceOfItem = 0f;
//		System.out.println(items.);
		for(int i =0; i<items.size(); ++i) {
			ItemBean itemBean = itemDAO.getItemById(Integer.parseInt(items.get(i).toString()));
			totalPriceOfItem += itemBean.getPrice();
		}
		return (totalPriceOfRoom+totalPriceOfRoom);

	}
}
