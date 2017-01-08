package ua.edu.khibs.resalex.service;

import org.springframework.transaction.annotation.Transactional;
import ua.edu.khibs.resalex.Dao.EmployeeDao;
import ua.edu.khibs.resalex.Dao.OrdersDao;
import ua.edu.khibs.resalex.model.Dish;
import ua.edu.khibs.resalex.model.Employee;
import ua.edu.khibs.resalex.model.Orders;

import java.sql.Date;
import java.util.List;

public class OrdersService {

    private OrdersDao ordersDao;
    private EmployeeDao employeeDao;

    @Transactional
    public List<Orders> getAllOrders() {
        return ordersDao.findAllOrders();
    }

    @Transactional
    public Orders getOrdersById(Long id) {
        return ordersDao.findOrdersById(id);
    }

    @Transactional
    public void updateOrdersInfo(Long id, Long employeeId, Integer tableNumber, Date orderDate) {
        Orders orders = ordersDao.findOrdersById(id);
        orders.setEmployee(employeeDao.findEmployeeById(employeeId));
        orders.setNumberOfTable(tableNumber);
        orders.setOrderDate(orderDate);
        ordersDao.updateOrders(orders);
    }
    @Transactional
    public void createNewOrders (Employee employee, Integer numberOfTable, Date orderDate, List<Dish> dish) {
        Orders orders = new Orders();
        orders.setEmployee(employee);
        orders.setNumberOfTable(numberOfTable);
        orders.setOrderDate(orderDate);
        orders.setListOfDishInOrder(dish);
        ordersDao.saveNewOrders(orders);
    }

    @Transactional
    public void deleteOrders (Long id) {
        ordersDao.deleteOrders(id);
    }

    @Transactional
    public void setOrdersDao(OrdersDao ordersDao) {
        this.ordersDao = ordersDao;
    }

    @Transactional
    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
