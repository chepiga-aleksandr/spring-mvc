package ua.edu.khibs.resalex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.edu.khibs.resalex.service.EmployeeService;

import java.util.Map;

@Controller
public class EmployeeController {
    private EmployeeService employeeService;

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public ModelAndView employees() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("employees", employeeService.getEmployeeByPosition("WAITER"));
        return modelAndView;
    }

    @RequestMapping(value = "/admin/employee/employees", method = RequestMethod.GET)
    public String adminEmployees(Map<String, Object> model) {
        model.put("employees", employeeService.getEmployees());
        return "admin/employee/employeesAdmin";
    }

    @RequestMapping(value = "/admin/employee/update_EmployeeId={id}", method = RequestMethod.GET)
    public ModelAndView updateEmployee(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("employee", employeeService.getEmployeeById(Long.parseLong(id)));
        modelAndView.setViewName("admin/employee/employeeAdmin");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/employee/updateEmployeeId={id}", method = RequestMethod.POST)
    public ModelAndView updateExistingEmployee(@PathVariable Long id,
                                               @RequestParam("employeeName") String name,
                                               @RequestParam("employeeSurname") String surame,
                                               @RequestParam("employeePosition") String position,
                                               @RequestParam("employeeSalary") Float salary,
                                               @RequestParam("employeeLogin") String login,
                                               @RequestParam("employeePassword") String password,
                                               @RequestParam("employeeRole") String role) {
        ModelAndView modelAndView = new ModelAndView();
        employeeService.updateEmployeeInfo(id, name, surame, position, salary, login, password, role);
        modelAndView.setViewName("redirect:../employee/employees");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/employee/newEmployee", method = RequestMethod.GET)
    public ModelAndView addEmployeeForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/employee/newEmployee");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/employee/newEmployee", method = RequestMethod.POST)
    public ModelAndView addNewEmployee(@RequestParam("employeeName") String name,
                                       @RequestParam("employeeSurname") String surame,
                                       @RequestParam("employeePosition") String position,
                                       @RequestParam("employeeSalary") Float salary,
                                       @RequestParam("employeeLogin") String login,
                                       @RequestParam("employeePassword") String password,
                                       @RequestParam("employeeRole") String role) {
        ModelAndView modelAndView = new ModelAndView();
        employeeService.addNewEmployee(name, surame, position, salary, login, password, role);
        modelAndView.setViewName("redirect:../employee/employees");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/employee/deleteEmployeeId={id}", method = RequestMethod.GET)
    public ModelAndView deleteEmployee(@PathVariable Long id) {

        ModelAndView modelAndView = new ModelAndView();
        employeeService.deleteEmployee(employeeService.getEmployeeById(id));
        modelAndView.addObject("employees", employeeService.getEmployees());
        modelAndView.setViewName("admin/employee/employeesAdmin");
        return modelAndView;
    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}