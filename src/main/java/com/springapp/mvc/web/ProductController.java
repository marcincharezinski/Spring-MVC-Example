package com.springapp.mvc.web;

import com.springapp.mvc.domain.Product;
import com.springapp.mvc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listUsers(ModelMap model) {
        model.addAttribute("products", productRepository.findAll());
        return "products";
    }

    @RequestMapping(value = "/products/add", method = RequestMethod.GET)
    public String addUser(ModelMap model) {
        model.addAttribute("product", new Product());
        return "createProductForm";
    }

    @RequestMapping(value = "/products/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("product") @Valid Product product, BindingResult result, ModelMap model) {

        if (result.hasErrors()) {
            model.put("product", product);
            return "createProductForm";
        }
        productRepository.save(product);
        return "redirect:/";
    }


}
