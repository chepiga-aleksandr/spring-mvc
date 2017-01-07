package ua.edu.khibs.resalex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.edu.khibs.resalex.model.Ingredient;
import ua.edu.khibs.resalex.service.DishService;
import ua.edu.khibs.resalex.service.IngredientService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DishController {

    private DishService dishService;
    private IngredientService ingredientService;

    @RequestMapping(value = "/admin/dish/addIngredientToDish/{dishName}", method = RequestMethod.GET)
    public ModelAndView addIngredientForm(@PathVariable String dishName) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("ingredientsToAdd", dishService.getIngredientToAddToDish(dishName));
        modelAndView.addObject("dishName", dishName);
        modelAndView.setViewName("admin/ingredient/addIngredientToDish");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/dish/addIngredientToDish/{dishName}", method = RequestMethod.POST)
    public ModelAndView addIngredientToDish(HttpServletRequest request, @PathVariable String dishName) {
        ModelAndView modelAndView = new ModelAndView();
        String[] ingredientsToAdd = request.getParameterValues("ingredient");
        dishService.addIngredientToDish(dishName, ingredientsToAdd);
        modelAndView.setViewName("redirect:../dishes");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/dish/deleteIngredientFromDish/{dishName}", method = RequestMethod.GET)
    public ModelAndView deleteIngredientForm(@PathVariable String dishName) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("ingredientsToDelete", dishService.getDishByName(dishName).getListOfIngredient());
        modelAndView.addObject("dishName", dishName);
        modelAndView.setViewName("admin/ingredient/deleteIngredientFromDish");
        return modelAndView;
    }

    @RequestMapping (value = "/admin/dish/deleteIngredientFromDish/{dishName}", method = RequestMethod.POST)
    public ModelAndView deleteIngredientFromDish (HttpServletRequest request, @PathVariable String dishName){
        ModelAndView modelAndView = new ModelAndView();
    String [] ingredientToDelete = request.getParameterValues("ingredient");
    dishService.deleteIngredientFromDish(dishName, ingredientToDelete);
    modelAndView.setViewName("redirect:../dishes");
    return modelAndView;
    }

    @RequestMapping(value = "/dish", method = RequestMethod.GET)
    public ModelAndView dish(@RequestParam String dishName) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("dish", dishService.getDishByName(dishName));
        modelAndView.setViewName("dish");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/dish/dishes", method = RequestMethod.GET)
    public ModelAndView getAllDishes() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("dishes", dishService.getAllDish());
        modelAndView.setViewName("admin/dish/dishesAdmin");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/dish/update_DishId={id}", method = RequestMethod.GET)
    public ModelAndView updateDish(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("dish", dishService.getDishById(Long.parseLong(id)));
        modelAndView.setViewName("admin/dish/dishAdmin");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/dish/updateDishId={id}", method = RequestMethod.POST)
    public ModelAndView updateExistingDish(@PathVariable Long id,
                                           @RequestParam("dishName") String name,
                                           @RequestParam("dishWeight") Integer weight,
                                           @RequestParam("dishPrice") Integer price) {
        ModelAndView modelAndView = new ModelAndView();
        dishService.updateDishInfo(id, name, weight, price);
        modelAndView.setViewName("redirect:../admin/dish/dishes");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/dish/newDish", method = RequestMethod.GET)
    public ModelAndView addEmployeeForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("ingredients", ingredientService.getAllIngredient());
        modelAndView.setViewName("admin/dish/newDish");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/dish/newDish", method = RequestMethod.POST)
    public ModelAndView addNewDish(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();

        List<Ingredient> ingredients = new ArrayList<>();
        String name = request.getParameter("dishName");
        Integer weight = Integer.parseInt(request.getParameter("dishWeight"));
        Integer price = Integer.parseInt(request.getParameter("dishPrice"));
        dishService.addNewDish(name, weight, price, ingredients);
        String[] ingrs = request.getParameterValues("ingr");
        if(ingrs != null) {
            dishService.addIngredientToDish(name, ingrs);
        }
        modelAndView.setViewName("redirect:../dish/dishes");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/dish/deleteDishId={id}", method = RequestMethod.GET)
    public ModelAndView deleteDish(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        dishService.deleteDish(id);
        modelAndView.addObject("dishes", dishService.getAllDish());
        modelAndView.setViewName("admin/dish/dishesAdmin");
        return modelAndView;
    }
    @Autowired
    public void setDishService(DishService dishService) {
        this.dishService = dishService;
    }
    @Autowired
    public void setIngredientService(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }
}