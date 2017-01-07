package ua.edu.khibs.resalex.service;

import org.springframework.transaction.annotation.Transactional;
import ua.edu.khibs.resalex.Dao.DishDao;
import ua.edu.khibs.resalex.Dao.IngredientDao;
import ua.edu.khibs.resalex.model.Dish;
import ua.edu.khibs.resalex.model.Ingredient;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DishService {

    private DishDao dishDao;
    private IngredientDao ingredientDao;

    @Transactional
    public List<Ingredient> getIngredientToAddToDish(String dishName) {
        List<Ingredient> dishIngredients = dishDao.findDishByName(dishName).getListOfIngredient();

        Set<Ingredient> allIngredients = ingredientDao.findAllIngredient();
        List<Ingredient> ingredientToAdd = new ArrayList<>();
        for (Ingredient i : allIngredients) {
            if (!dishIngredients.contains(i)) {
                ingredientToAdd.add(i);
            }
        }
        return ingredientToAdd;
    }

    @Transactional
    public void addIngredientToDish(String dishName, String[] ingredientsToAdd) {
        Dish dish = dishDao.findDishByName(dishName);
        List<Ingredient> dishIngredient = dish.getListOfIngredient();

        for (String ingredientName : ingredientsToAdd) {
            Ingredient ingredient = ingredientDao.findIngredientByName(ingredientName);
            dishIngredient.add(ingredient);
        }

        dish.setListOfIngredient(dishIngredient);
        dishDao.updateDish(dish);
    }

    @Transactional
    public List<Dish> getAllDish() {
        return dishDao.findAllDishes();
    }


    @Transactional
    public void deleteIngredientFromDish(String dishName, String[] ingredientToDelete) {
        Dish dish = dishDao.findDishByName(dishName);

        List<Ingredient> dishIngredient = dish.getListOfIngredient();

        for (String ingredientName : ingredientToDelete) {

            Ingredient ingredient = ingredientDao.findIngredientByName(ingredientName);
            dishIngredient.remove(ingredient);
        }
        dish.setListOfIngredient(dishIngredient);
        dishDao.updateDish(dish);
    }


    @Transactional
    public Dish getDishByName(String dishName) {
        return dishDao.findDishByName(dishName);
    }

    @Transactional
    public void updateDishInfo(Long id, String name, Integer weight, Integer price) {
        Dish dish = dishDao.findDishById(id);
        dish.setInfo(name, weight, price);
        dishDao.updateDish(dish);
    }

    @Transactional
    public void addNewDish(String name, Integer weight, Integer price, List<Ingredient> ingredients) {

        Dish dish = new Dish();
        dish.setName(name);
        dish.setWeight(weight);
        dish.setPrice(price);
        dish.setListOfIngredient(ingredients);
        dishDao.saveNewDish(dish);
    }

    @Transactional
    public void deleteDish(Long id) {
        dishDao.removeDish(id);
    }

    @Transactional
    public Dish getDishById(Long id) {
        return dishDao.findDishById(id);
    }

    @Transactional
    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }

    @Transactional
    public void setIngredientDao(IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }
}