package ua.edu.khibs.resalex.service;

import org.springframework.transaction.annotation.Transactional;
import ua.edu.khibs.resalex.Dao.DishDao;
import ua.edu.khibs.resalex.model.Dish;

import java.util.List;

public class DishService {

    private DishDao dishDao;

    @Transactional
    public List<Dish> getAllDish() {
        return dishDao.findAllDishes();
    }

    @Transactional
    public Dish getDishByName(String dishName) {
        return dishDao.findDishByName(dishName);
    }

    @Transactional
    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }
}