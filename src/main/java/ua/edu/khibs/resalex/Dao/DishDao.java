package ua.edu.khibs.resalex.Dao;

import ua.edu.khibs.resalex.model.Dish;

import java.util.List;

public interface DishDao {

//  Добавлять существующие блюда
    void saveDish(Dish dish);

//  Просматривать существующие блюда
    List<Dish> findAllDishes();

//  Удалять существующие блюда
    void removeDish(Dish dish);

// Редактировать существующие блюда

    void updateDish (Long id, Dish newDish);

    Dish findDishByName(String name);

    Dish setInformation (String name, Integer weight, Integer price);

    Dish findDishById (Long id);

}







