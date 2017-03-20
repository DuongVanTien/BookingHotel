package vn.framgia.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import vn.framgia.util.Helpers;

import java.util.List;

/**
 * Created by FRAMGIA\duong.van.tien on 08/03/2017.
 *
 */
@Controller
public class ServiceController {
    public static final Logger logger = Logger.getLogger(ServiceController.class);

    @Autowired
    IServiceService serviceService;

    @RequestMapping(value = "/new_service", method = RequestMethod.GET)
    public String addService(Model model) {
        ServiceBean serviceBean = new ServiceBean();
        model.addAttribute("serviceBeanForm", serviceBean);
        return "newService";
    }

    @RequestMapping(value = "/new_service", method = RequestMethod.POST)
    public ModelAndView addService(@ModelAttribute("serviceBeanForm") ServiceBean serviceBean) {
        boolean check=true;
        if (Helpers.isEmpty(serviceBean.getName())) {
            check = false;
        }
        if(Helpers.isEmpty(serviceBean.getPrice()+"")) {
            check = false;
        }
        if(Helpers.isEmpty(serviceBean.getDescription())) {
            check = false;
        }

        if(!check) {
            return new ModelAndView("newService");
        }

        boolean checkAdd = true;
        checkAdd = serviceService.addService(serviceBean);
        if(checkAdd) {
            ModelAndView view = new ModelAndView();
            view.setViewName("newService");
            view.addObject("errAddService", "add service - the error occurred, duplicate....");
            return view;
        }

        return new ModelAndView("redirect:services");
    }

    @RequestMapping(value = "/services", method = RequestMethod.GET)
    public ModelAndView showListServices() {
        ModelAndView view = new ModelAndView("services");
        List<ServiceBean> listServicesBean = serviceService.getAllServices();
        if(listServicesBean == null)
            view.addObject("listServicesBeanEmpty", "List service is empty");
        else
            view.addObject("listServicesBeanEmpty", "");
        view.addObject("listServicesBean", listServicesBean);
        return view;
    }

    @RequestMapping(value = "/delete_service")
    public ModelAndView deleteService(@RequestParam int id) {
        boolean check = true;
        check = serviceService.deleteService(id);
        if(check) {
            ModelAndView view = new ModelAndView();
            view.setViewName("services");
            view.addObject("errDeleteService", "Delete service - the error occurred");
            return view;
        }
        return new ModelAndView("redirect:services");
    }

    @RequestMapping(value = "/edit_service", method = RequestMethod.GET)
    public ModelAndView editService(@RequestParam int id) {
        ServiceBean serviceBean = serviceService.getServiceBeanById(id);
        if(serviceBean == null) {
            ModelAndView view = new ModelAndView();
            view.setViewName("services");
            view.addObject("errEditService", "Edit service - the error occurred");
            return view;
        }
        ModelAndView view = new ModelAndView();
        view.addObject("serviceBeanForm", serviceBean);
        view.setViewName("editService");
        return view;
    }

    @RequestMapping(value = "/update_service", method = RequestMethod.POST)
    public ModelAndView updateService(@ModelAttribute("serviceBeanForm") ServiceBean serviceBean) {
        boolean check = true;
        check  = serviceService.updateService(serviceBean);
        if(!check) {
            ModelAndView view = new ModelAndView();
            view.setViewName("editService");
            view.addObject("errDeleteService", "Delete service - the error occurred");
            return view;
        }
        return new ModelAndView("redirect:services");
    }
}
