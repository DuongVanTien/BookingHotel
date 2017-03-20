package vn.framgia.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import vn.framgia.bean.*;
import vn.framgia.service.IBookingService;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Created by tienduongvan on 08/03/2017.
 *
 */
@Controller
public class BookingController {
    private static final Logger logger = LoggerFactory.getLogger(RoomController.class);

    @Autowired
    IRoomService roomService;

    @Autowired
    IServiceService serviceService;

    @Autowired
    IBookingService bookingService;


    @RequestMapping(value = "/viewBooking", method = RequestMethod.GET)
    public ModelAndView viewBooking(Model model) {
        ModelAndView view = new ModelAndView();
        ConditionBookingBean conditionBookingBean = new ConditionBookingBean();
        model.addAttribute("conditionBooOkingBeanForm", conditionBookingBean);
        List<RoomBean> listRoomsBean = roomService.findAllRooms();
        view.addObject("listRoomsBean", listRoomsBean);
        view.setViewName("viewBooking");
        return view;
    }

    // !!! chua check empty cho form nhap dieu kien search
    @RequestMapping(value = "/searchRoomCondition", method = RequestMethod.POST)
    public ModelAndView searchRoomCondition(
            @ModelAttribute("conditionBookingBeanForm") ConditionBookingBean conditionBookingBean) {
        try {
            ModelAndView view = new ModelAndView();
            Integer size = conditionBookingBean.getSize();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date start = sdf.parse(conditionBookingBean.getStartDate());
            Date end  = sdf.parse(conditionBookingBean.getEndDate());
            List<RoomBean> listRoomsBean = roomService.searchRoomCondition(start, end, size);
            if(listRoomsBean == null) {
                view.addObject("err_empty", "Can not find results by condition");
                listRoomsBean = roomService.findAllRooms();
                view.addObject("listRoomsBean", listRoomsBean);
                view.setViewName("viewBooking");
                return view;
            }
            view.addObject("conditionBookingBeanForm", conditionBookingBean);
            view.addObject("listRoomsBean", listRoomsBean);
            view.setViewName("viewBooking");
            return view;
        } catch (ParseException e) {
            logger.error("Exception in function searchRoomCondition in BookingController : ", e);
        }
    }

    @RequestMapping(value = "/booking", method = RequestMethod.POST)
    public String bookingInfo(Model model, @ModelAttribute("roomBeanForm") RoomBean roomBeanForm,
                              @ModelAttribute("conditionBookingBeanForm") ConditionBookingBean conditionBookingBean, HttpServletRequest request) {
//        String start_date = conditionBookingBean.getStartDate();
//        String end_date = conditionBookingBean.getEndDate();
        System.out.println("-----X-----"+conditionBookingBean.getStartDate());
        model.addAttribute("conditionBookingBeanForm", conditionBookingBean);


        String start = roomBeanForm.getStart();
        Integer id = roomBeanForm.getId();
        String param = request.getParameter("start");

        System.out.println("-----X----- : "+start+"--------- : "+id+"--------- : "+param);



        RoomBean roomBean = roomService.getRoomBeanById(id);
        model.addAttribute("roomBeanForm", roomBean);

        ClientBean clientBean = new ClientBean();
        model.addAttribute("clientBeanForm", clientBean);

        List<ServiceBean> listServicesBean = serviceService.getAllServices();
//        Set<ServiceBean> setServiceBean = new HashSet<ServiceBean>(listServicesBean);
        model.addAttribute("listServicesBeanForm", listServicesBean);

        BookingBean bookingBean = new BookingBean();
        model.addAttribute("bookingBeanForm", bookingBean);

        System.out.println("------------------listService : "+listServicesBean.size());

        return "booking";
    }

    // chua chay vi bidding BookingBean dang bi thieu cac thuoc tinh
//    @RequestMapping(value = "/booking---------", method = RequestMethod.POST)
//    public String bookingAction(@ModelAttribute("clientBeanForm") ClientBean clientBean,
//                                @ModelAttribute("roomBeanForm") RoomBean roomBean,
//                                @ModelAttribute("bookingBeanForm") BookingBean bookingBean) {
//
//
////        System.out.println("--------listServicesBeanForm: "+listServicesBeanForm);
////        System.out.println("-------listServicesBeanForm.getId() : "+listServicesBeanForm.size());
////        for(int i=0; i<listServicesBeanForm.size(); ++i) {
////            System.out.println("----"+listServicesBeanForm.get(i));
////        }
//
//        return "viewBooking";
//    }

}
