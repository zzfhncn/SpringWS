package com.demo.controller;

import com.demo.bean.Employee;
import com.demo.service.IUserInfoService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class EmployeeController {

    @Autowired
    private IUserInfoService iUserInfoService;
    
    @RequestMapping(method = RequestMethod.GET, value = "/employee/{id}")
    public ModelAndView getEmployee(@PathVariable String id) {
        Employee e = iUserInfoService.getUserById(id);
        //Employee e = employeeDS.get(Long.parseLong(id));
        //return new ModelAndView(XML_VIEW_NAME, "object", e);
        return new ModelAndView();
    }

    @RequestMapping(value = "/login")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }
}
