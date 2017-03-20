package vn.framgia.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import vn.framgia.bean.UserBean;
import vn.framgia.service.IUserService;
import vn.framgia.util.Helpers;

import java.util.HashMap;
import java.util.List;

/**
 * Created by FRAMGIA\duong.van.tien on 06/03/2017.
 *
 */
@Controller
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    IUserService userService;


    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() {
        logger.info("view index");
        HashMap<String, Object> model = new HashMap<String, Object>();
        List<UserBean> listUsersBean = userService.findAllUsers();
        return new ModelAndView("index", model);
    }
}
