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
    public void updateDishInfo(Long id, Dish newDish) {
        dishDao.updateDish(id, newDish);
    }

    @Transactional
    public Dish getDishById (Long id) {
        return dishDao.findDishById(id);
    }

    @Transactional
    public Dish setInformationUpdateDish (String name, Integer weight, Integer price ){
        return dishDao.setInformation(name, weight, price);
    }

    @Transactional
    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }
}