//package ua.edu.khibs.resalex.web;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import ua.edu.khibs.resalex.service.MenuService;
//
//import java.util.Map;
//
//@Controller
//public class MenuController {
//
//    private MenuService menuService;
//
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//
//    public String menu(Map<String, Object> model) {
//
//        model.put("menuService", menuService.getAllMenu());
//        return "menu";
//    }
//
//    @Autowired
//    public void setMenuService(MenuService menuService) {
//        this.menuService = menuService;
//    }
//}
//
