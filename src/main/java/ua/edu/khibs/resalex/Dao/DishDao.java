package ua.edu.khibs.resalex.Dao;

import ua.edu.khibs.resalex.model.Dish;

import java.util.List;

public interface DishDao {

    void save(Dish dish);

    List findAll();

    Dish findByName(String name);

}
