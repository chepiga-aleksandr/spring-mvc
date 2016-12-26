package ua.edu.khibs.resalex.Dao;

        import ua.edu.khibs.resalex.model.Dish;

import java.util.List;

public interface DishDao {

    void saveNewDish(Dish dish);

    List<Dish> findAllDishes();

    void removeDish(Long id);

    void updateDish (Dish dish);

    Dish findDishByName(String name);

    Dish findDishById (Long id);
}