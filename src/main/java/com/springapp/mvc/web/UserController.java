package com.springapp.mvc.web;

import com.springapp.mvc.domain.Product;
import com.springapp.mvc.domain.User;
import com.springapp.mvc.repository.ProductRepository;
import com.springapp.mvc.repository.UserRepository;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("/products/{productId}")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @ModelAttribute("product")
    public Product findProduct(@PathVariable("productId") Long productId) {
        Product product = productRepository.findOne(productId);
        return product;
    }

    @RequestMapping(value = "/api/users", method = RequestMethod.GET)
    public
    @ResponseBody
    String listUsersJson(ModelMap model) throws JSONException {
        JSONArray userArray = new JSONArray();
        for (User user : userRepository.findAll()) {
            JSONObject userJSON = new JSONObject();
            userJSON.put("id", user.getId());
            userJSON.put("firstName", user.getFirstName());
            userJSON.put("lastName", user.getLastName());
            userJSON.put("email", user.getEmail());
            userJSON.put("jobTitle", user.getProduct().getName());
            userArray.put(userJSON);
        }
        return userArray.toString();
    }

    @RequestMapping("/delete/{userId}")
    public String deleteUser(@PathVariable("userId") Long userId) {
        userRepository.delete(userRepository.findOne(userId));
        return "redirect:/";
    }

    @RequestMapping(value = "/user/new", method = RequestMethod.GET)
    public String initCreationForm(Product product, ModelMap model) {
        User user = new User();
        product.addUser(user);
        model.put("user", user);
        return "createUserForm";
    }

    @RequestMapping(value = "/user/new", method = RequestMethod.POST)
    public String processCreationForm(Product product, @Valid User user, BindingResult result, ModelMap model) {

        if (result.hasErrors()) {
            model.put("user", user);
            return "createUserForm";

        } else {
            product.addUser(user);
            userRepository.save(user);
            return "welcome";
        }
    }
}

