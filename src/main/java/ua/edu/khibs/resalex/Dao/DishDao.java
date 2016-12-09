package ua.edu.khibs.resalex.Dao;

import ua.edu.khibs.resalex.model.Dish;

import java.util.List;

public interface DishDao {

    void saveDish(Dish dish);

    Dish loadDish(Long id);

    List findAllDishes();

    void removeDish(Dish dish);

    Dish findDishByName(String name);
}


