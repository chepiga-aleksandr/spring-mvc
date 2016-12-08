package ua.edu.khibs.resalex.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.edu.khibs.resalex.service.RestaurantService;

import java.util.Map;

@Controller
public class MainController {

    private RestaurantService restaurantService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Map<String, Object> model) {
        model.put("restaurantService", restaurantService.getInfo());
        return "index";
    }

    @Autowired
    public void setRestaurantService(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }
}
