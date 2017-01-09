package ua.edu.khibs.resalex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.edu.khibs.resalex.model.Dish;
import ua.edu.khibs.resalex.model.Employee;
import ua.edu.khibs.resalex.service.DishService;
import ua.edu.khibs.resalex.service.EmployeeService;
import ua.edu.khibs.resalex.service.OrdersService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OrdersController {

    private OrdersService ordersService;
    private EmployeeService employeeService;
    private DishService dishService;

    @RequestMapping(value = "/admin/orders/orders", method = RequestMethod.GET)
    public ModelAndView getAllOrders() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("orders", ordersService.getAllOrders());
        modelAndView.setViewName("/admin/orders/ordersAdmin");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/orders/update_OrderId={id}", method = RequestMethod.GET)
    public ModelAndView updateOrdersForm(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("orders", ordersService.getOrdersById(Long.parseLong(id)));
        modelAndView.addObject("employees", employeeService.getEmployeeByPosition("WAITER"));
        modelAndView.setViewName("/admin/orders/updateOrders");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/orders/updateOrdersId={id}", method = RequestMethod.POST)
    public ModelAndView updateOrders(@PathVariable Long id,
                                     @RequestParam("employeeId") Long employeeId,
                                     @RequestParam("numberOfTable") Integer numberOfTable,
                                     @RequestParam("dateOfOrders") Date dateOfOrders) {
        ModelAndView modelAndView = new ModelAndView();
        ordersService.updateOrdersInfo(id, employeeId, numberOfTable, dateOfOrders);
        modelAndView.setViewName("redirect:/admin/orders/orders");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/orders/createOrders", method = RequestMethod.GET)
    public ModelAndView createNewOrdersForm() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("employees", employeeService.getEmployeeByPosition("WAITER"));
        modelAndView.addObject("dishes", dishService.getAllDish());
        modelAndView.setViewName("/admin/orders/newOrders");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/orders/createOrders", method = RequestMethod.POST)
    public ModelAndView createNewOrders(@RequestParam("employeeId") Long employeeId,
                                        @RequestParam("numberOfTable") Integer numberOfTable,
                                        @RequestParam("dateOfOrders") Date dateOfOrders,
                                        @RequestParam("dish") String[] dishesInOrders) {
        ModelAndView modelAndView = new ModelAndView();
        Employee employee = employeeService.getEmployeeById(employeeId);

        List<Dish> dishes = new ArrayList<>();
        for (String dishName : dishesInOrders) {
            Dish dish = dishService.getDishByName(dishName);
            dishes.add(dish);
        }
        ordersService.createNewOrders(employee, numberOfTable, dateOfOrders, dishes);
        modelAndView.setViewName("redirect:/admin/orders/orders");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/orders/deleteOrderId={id}", method = RequestMethod.GET)
    public ModelAndView deleteOrders(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        ordersService.deleteOrders(id);
        modelAndView.setViewName("redirect:/admin/orders/orders");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/dish/deleteDishFromOrders={id}", method = RequestMethod.GET)
    public ModelAndView deleteDishFromOrdersForm(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("listDishes", ordersService.getOrdersById(id).getListOfDishInOrder());
        modelAndView.setViewName("/admin/dish/deleteDishFromOrders");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/dish/deleteDishFromOrders={id}", method = RequestMethod.POST)
    public ModelAndView deleteDishFromOrders(@PathVariable Long id,
                                             @RequestParam ("dish") String[] listOfDishesToDelete) {
        ModelAndView modelAndView = new ModelAndView();
        ordersService.deleteDishInOrders(id, listOfDishesToDelete);
        modelAndView.addObject("listDishes", ordersService.getOrdersById(id).getListOfDishInOrder());
        modelAndView.setViewName("redirect:/admin/orders/orders");
        return modelAndView;
    }

    @RequestMapping (value = "/admin/dish/addDishToOrder={id}", method = RequestMethod.GET)
    public ModelAndView addDishToOrderForm (@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject ("allDish", dishService.getAllDish());
        modelAndView.setViewName("/admin/dish/addDishToOrder");
        return modelAndView;
    }

    @RequestMapping (value = "/admin/dish/addDishToOrder={id}", method = RequestMethod.POST)
    public ModelAndView addDishToOrder (@PathVariable Long id,
                                        @RequestParam ("dishToAdd") String [] dishToOrder) {
        ModelAndView modelAndView = new ModelAndView();
        ordersService.addDishToOrder(id, dishToOrder);
        modelAndView.setViewName("redirect:/admin/orders/orders");
        return modelAndView;
    }

    @Autowired
    public void setOrdersService(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Autowired
    public void setDishService(DishService dishService) {
        this.dishService = dishService;
    }
}
