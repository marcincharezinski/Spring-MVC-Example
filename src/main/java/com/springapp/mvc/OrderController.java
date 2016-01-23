package com.springapp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class OrderController {
    @RequestMapping(value = "/create_order", method = RequestMethod.GET)
    public ModelAndView create_order() {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("userr", new User());
        model.put("product", new Product());

        return new ModelAndView("create_order", "command", model);
    }
}
