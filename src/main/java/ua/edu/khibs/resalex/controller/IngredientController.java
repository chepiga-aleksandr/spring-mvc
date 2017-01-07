package ua.edu.khibs.resalex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.edu.khibs.resalex.service.IngredientService;

@Controller
public class IngredientController {

    private IngredientService ingredientService;

    @RequestMapping (value = "/admin/store/store", method = RequestMethod.GET)
    public ModelAndView ListIngredientInStore() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("ingredients", ingredientService.getAllIngredient());
        modelAndView.setViewName("admin/store/store");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/store/createNewIngredient", method = RequestMethod.GET)
    public ModelAndView addNewIngredientForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("ingredient", ingredientService.getAllIngredient());
        modelAndView.setViewName("admin/store/newIngredient");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/store/createNewIngredient", method = RequestMethod.POST)
    public ModelAndView addNewIngredient(@RequestParam("ingredientName") String name,
                                         @RequestParam("ingredientAmount") Integer amount) {
        ModelAndView modelAndView = new ModelAndView();
        ingredientService.addNewIngredient(name, amount);
        modelAndView.setViewName("redirect:../store/store");
        return modelAndView;
    }

    @RequestMapping (value = "/admin/store/update_IngredientId={id}", method = RequestMethod.GET)
    public ModelAndView updateIngredientForm (@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("ingredient", ingredientService.getIngredientById(Long.parseLong(id)));
        modelAndView.setViewName("/admin/store/updateIngredient");
        return modelAndView;
    }

    @RequestMapping (value = "/admin/store/updateIngredientId={id}", method = RequestMethod.POST)
    public ModelAndView updateIngredient (@PathVariable Long id,
                                          @RequestParam ("ingredientName") String name,
                                          @RequestParam ("ingredientAmount") Integer amount) {
        ModelAndView modelAndView = new ModelAndView();
        ingredientService.updateIngredientInfo(id, name, amount);
        modelAndView.setViewName("redirect:../store/store");
        return modelAndView;
    }

    @RequestMapping (value = "/admin/store/deleteIngredientId={id}", method = RequestMethod.GET)
    public ModelAndView deleteIngredient (@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        ingredientService.deleteIngredientFromStore(ingredientService.getIngredientById(id));
        modelAndView.setViewName("redirect:../store/store");
        return modelAndView;
    }

    @Autowired
    public void setIngredientService(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }
}