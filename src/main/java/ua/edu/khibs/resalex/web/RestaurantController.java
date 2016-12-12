package ua.edu.khibs.resalex.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.edu.khibs.resalex.service.RestaurantService;

import java.util.Map;
@Controller
public class RestaurantController {

    private RestaurantService restaurantService;

    @RequestMapping(value = "/restaurant", method = RequestMethod.GET)
    public String restaurant (Map<String, Object> model) {
        model.put("restaurant", restaurantService.getInfo());
        return "restaurant";
    }

    @Autowired
    public void setRestaurantService(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }
}
