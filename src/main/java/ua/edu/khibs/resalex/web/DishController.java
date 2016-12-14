package ua.edu.khibs.resalex.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.edu.khibs.resalex.service.DishService;

@Controller
public class DishController {

    private DishService dishService;

    @RequestMapping(value = "/dish", method = RequestMethod.GET)
    public ModelAndView dish (@RequestParam("dishName") String dishName) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("dish", dishService.getDishByName(dishName));
        modelAndView.setViewName("dish");
        return modelAndView;
    }

    @Autowired
    public void setDishesService(DishService dishService) {
        this.dishService = dishService;
    }
}