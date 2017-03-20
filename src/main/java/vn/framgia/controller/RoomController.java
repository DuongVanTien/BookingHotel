package vn.framgia.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import vn.framgia.util.Helpers;

import java.util.List;

/**
 * Created by FRAMGIA\duong.van.tien on 07/03/2017.
 *
 */
@Controller
public class RoomController {
    private static final Logger logger = LoggerFactory.getLogger(RoomController.class);

    @Autowired
    IRoomService roomService;

    @RequestMapping(value = "/new_room", method = RequestMethod.GET)
    public String index(Model model) {
        RoomBean roomBean = new RoomBean();
        model.addAttribute("roomBeanForm", roomBean);
        return "newRoom";
    }

    @RequestMapping(value = "/new_room", method = RequestMethod.POST)
    public ModelAndView addRoom(@ModelAttribute(value = "roomBeanForm") RoomBean roomBean,
                                BindingResult result) {
        boolean check = true;

        if (Helpers.isEmpty(roomBean.getName())) {
            result.reject("name", "room name is not empty");
            check = false;
        }
        if (Helpers.isEmpty(roomBean.getPrice()+"")) {
            result.reject("price", "price is not empty");
            check = false;
        }
        if (Helpers.isEmpty(roomBean.getDescription())) {
            result.reject("description", "description is not empty");
            check = false;
        }
        if (!check) {
            return new ModelAndView("newRoom");
        }

        boolean checkAdd = true;
        roomService.addRoom(roomBean);
        if(!checkAdd) {
            ModelAndView view = new ModelAndView();
            view.setViewName("newRoom");
            view.addObject("errAddRoom", "add room - the error occurred, duplicate....");
            return view;
        }

        return new ModelAndView("redirect:rooms");
    }

    @RequestMapping(value = "/rooms", method = RequestMethod.GET)
    public ModelAndView showListRooms() {
        List<RoomBean> listRoomsBean = roomService.findAllRooms();

        ModelAndView view = new ModelAndView("rooms");
        view.addObject("listRoomsBean", listRoomsBean);
        return view;
    }

    @RequestMapping("/delete_room")
    public ModelAndView deleteRoom(@RequestParam int id) {
        roomService.deleteRoom(id);
        return new ModelAndView("redirect:rooms");
    }

    @RequestMapping("/edit_room")
    public ModelAndView editEmployee(@RequestParam int id) {
        RoomBean roomBean = roomService.getRoomBeanById(id);
        return new ModelAndView("editRoom", "roomBeanForm", roomBean);
    }

    @RequestMapping("/update_room")
    public ModelAndView updateEmployee(@ModelAttribute(value = "roomBeanForm") RoomBean roomBean) {
        roomService.udpateRoom(roomBean);
        return new ModelAndView("redirect:rooms");
    }
}
