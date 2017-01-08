package ua.edu.khibs.resalex.Dao;

import ua.edu.khibs.resalex.model.Orders;

import java.util.List;

public interface OrdersDao {

    List<Orders> findAllOrders();

    Orders findOrdersById(Long id);

    void updateOrders(Orders orders);

    void saveNewOrders(Orders orders);

    void deleteOrders(Long id);

    Orders findOrdersByNameWaiters(String name);

}
