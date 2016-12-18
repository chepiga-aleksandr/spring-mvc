package ua.edu.khibs.resalex.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.edu.khibs.resalex.model.Employee;
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

    @RequestMapping(value = "/admin/employeeId={id}", method = RequestMethod.GET)
    public ModelAndView adminEmployee(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("employee", employeeService.getEmployeeById(id));
        modelAndView.setViewName("admin/employeeAdmin");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/employees", method = RequestMethod.GET)
    public String adminEmployees(Map<String, Object> model) {
        model.put("employees", employeeService.getEmployees());
        return "admin/employeesAdmin";
    }

    @RequestMapping(value = "/admin/updateEmployeeId={id}", method = RequestMethod.POST)
    public ModelAndView updateExistingEmployee(@PathVariable Long id,
                                               @RequestParam("employeeName") String name,
                                               @RequestParam("employeeSurname") String surame,
                                               @RequestParam("employeePosition") String position,
                                               @RequestParam("employeeSalary") double salary) {
        ModelAndView modelAndView = new ModelAndView();
        Employee updateEmployee = employeeService.setInformationUpdateEmployee(name, surame, position, salary);
        employeeService.updateEmployeeInfo(id, updateEmployee);
        modelAndView.addObject("employee", employeeService.getEmployeeById(id));
        modelAndView.setViewName("redirect:../admin/employees");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/newEmployee", method = RequestMethod.GET)
    public ModelAndView addEmployeeForm() {
        ModelAndView modelAndView = new ModelAndView();


        modelAndView.setViewName("admin/newEmployee");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/newEmployee", method = RequestMethod.POST)
    public ModelAndView addNewEmployee(@RequestParam("employeeName") String name,
                                     @RequestParam("employeeSurname") String surame,
                                     @RequestParam("employeePosition") String position,
                                     @RequestParam("employeeSalary") Float salary) {
        ModelAndView modelAndView = new ModelAndView();
        employeeService.addNewEmployee(name, surame, position, salary);
        modelAndView.setViewName("redirect:../admin/employees");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/deleteEmployeeId={id}", method = RequestMethod.GET)
    public ModelAndView deleteEmployee(@PathVariable Long id) {

        ModelAndView modelAndView = new ModelAndView();
        employeeService.deleteEmployee(employeeService.getEmployeeById(id));
        modelAndView.addObject("employees", employeeService.getEmployees());
        modelAndView.setViewName("admin/employeesAdmin");
        return modelAndView;
    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}