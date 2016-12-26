package ua.edu.khibs.resalex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.edu.khibs.resalex.service.DishService;
import ua.edu.khibs.resalex.service.EmployeeService;
import ua.edu.khibs.resalex.service.MenuService;
import ua.edu.khibs.resalex.service.RestaurantService;

import java.util.Map;

@Controller
public class MainController {

    private RestaurantService restaurantService;
    private EmployeeService employeeService;
    private MenuService menuService;
    private DishService dishService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Map<String, Object> model) {
        model.put("employees", employeeService.getEmployees());
        model.put("restaurant", restaurantService.getInfo());
        model.put("allMenu", menuService.getAllMenu());
        model.put("allDishes", dishService.getAllDish());
        return "index";
    }




    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Autowired
    public void setDishService(DishService dishService) {
        this.dishService = dishService;
    }

    @Autowired
    public void setRestaurantService(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }
    @Autowired
    public void setMenuService(MenuService menuService) {
        this.menuService = menuService;
    }
}