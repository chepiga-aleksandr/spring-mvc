package ua.edu.khibs.resalex.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.edu.khibs.resalex.service.IngredientService;

@Controller
public class IngredientController {

    private IngredientService ingredientService;

    @RequestMapping(value = "/admin/addIngredientToList", method = RequestMethod.GET)
    public ModelAndView addNewIngredientForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("ingredient", ingredientService.getAllIngredient());
        modelAndView.setViewName("admin/newIngredient");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/addIngredientToList", method = RequestMethod.POST)
    public ModelAndView addNewIngredient(@RequestParam("ingredientName") String name,
                                        @RequestParam("ingredientAmount") Integer amount){
            ModelAndView modelAndView = new ModelAndView();
            ingredientService.addNewIngredient(name, amount);
            modelAndView.setViewName("redirect:../admin/dishes");
            return modelAndView;
        }

    @Autowired
    public void setIngredientService(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }
}