package ua.edu.khibs.resalex.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.edu.khibs.resalex.model.Dish;
import ua.edu.khibs.resalex.service.DishService;

@Controller
public class DishController {

    private DishService dishService;

    @RequestMapping(value = "/dish", method = RequestMethod.GET)
    public ModelAndView dish(@RequestParam String dishName) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("dish", dishService.getDishByName(dishName));
        modelAndView.setViewName("dish");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/updateDishId={id}", method = RequestMethod.POST)
    public ModelAndView updateDishInfo(@PathVariable Long id,
                                       @RequestParam("dishName") String name,
                                       @RequestParam("dishWeight") Integer weight,
                                       @RequestParam("dishPrice") Integer price) {
        ModelAndView modelAndView = new ModelAndView();
        Dish updateDish = dishService.setInformationUpdateDish(name, weight, price);
        dishService.updateDishInfo(id, updateDish);
        modelAndView.addObject("dish", dishService.getDishById(id));
        modelAndView.setViewName("redirect:..admin/dishes");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/dishes", method = RequestMethod.GET)
    public ModelAndView getAllDishes() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("dishes", dishService.getAllDish());
        modelAndView.setViewName("/admin/dishes");
        return modelAndView;
    }

    @Autowired
    public void setDishesService(DishService dishService) {
        this.dishService = dishService;
    }
}