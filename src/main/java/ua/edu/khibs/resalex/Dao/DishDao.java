package ua.edu.khibs.resalex.Dao;

        import ua.edu.khibs.resalex.model.Dish;

        import java.util.List;

public interface DishDao {

    //  Добавлять существующие блюда
    void saveNewDish(Dish dish);

    //  Просматривать существующие блюда
    List<Dish> findAllDishes();

    //  Удалять существующие блюда
    void removeDish(Long id);

// Редактировать существующие блюда

    void updateDish (Dish dish);

    Dish findDishByName(String name);

    Dish findDishById (Long id);
}







