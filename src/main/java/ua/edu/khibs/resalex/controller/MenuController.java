package ua.edu.khibs.resalex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.edu.khibs.resalex.model.Dish;
import ua.edu.khibs.resalex.service.DishService;
import ua.edu.khibs.resalex.service.MenuService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MenuController {

    private MenuService menuService;
    private DishService dishService;



    @RequestMapping(value = "/admin/menu/menuAdmin", method = RequestMethod.GET)
    public ModelAndView getAllMenu() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("menu", menuService.getAllMenu());
        modelAndView.setViewName("admin/menu/menuAdmin");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/updateMenuId={id}", method = RequestMethod.GET)
    public ModelAndView updateMenuForm(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("menu", menuService.getMenuById(Long.parseLong(id)));
        modelAndView.setViewName("admin/menu/menu");
        return modelAndView;
    }


    @RequestMapping(value = "/admin/updateMenuId={id}", method = RequestMethod.POST)
    public ModelAndView updateMenu(@PathVariable Long id,
                                   @RequestParam("menuName") String name) {

        ModelAndView modelAndView = new ModelAndView();
        menuService.updateMenuInfo(id, name);
        modelAndView.setViewName("redirect: ../admin/menu/menuAdmin");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/addDishToMenu/{menuName}", method = RequestMethod.GET)
    public ModelAndView addDishToMenu(@PathVariable String menuName) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("dishToAdd", menuService.getDishToAddToMenu(menuName));
        modelAndView.addObject("menuName", menuName);
        modelAndView.setViewName("/admin/menu/addDishToMenu");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/addDishToMenu/{menuName}", method = RequestMethod.POST)
    public ModelAndView addDishToMenu(HttpServletRequest request, @PathVariable String menuName) {
        ModelAndView modelAndView = new ModelAndView();
        String[] dishToAdd = request.getParameterValues("dish");
        menuService.addDishToMenu(menuName, dishToAdd);
        modelAndView.setViewName("redirect:../menu/menuAdmin");
        return modelAndView;
    }

    @RequestMapping (value = "/admin/menu/newMenu", method = RequestMethod.GET)
    public ModelAndView addMenuForm() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("dishes", dishService.getAllDish());
        modelAndView.setViewName("admin/menu/newMenu");
        return modelAndView;
    }

    @RequestMapping (value = "/admin/menu/newMenu", method = RequestMethod.POST)
    public ModelAndView addNewMenu(HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView();

        List<Dish> dishes = new ArrayList<>();

        String name = request.getParameter("menuName");
        menuService.addNewMenu(name,dishes);
        String[] dishString = request.getParameterValues("dish");

        if(dishString!= null) {
            menuService.addDishToMenu(name, dishString);
        }
        modelAndView.setViewName("redirect:../menu/menuAdmin");
        return modelAndView;
    }

    @Autowired
    public void setDishService(DishService dishService) {
        this.dishService = dishService;
    }

    @Autowired
    public void setMenuService(MenuService menuService) {
        this.menuService = menuService;
    }
}
