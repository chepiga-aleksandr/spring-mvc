package ua.edu.khibs.resalex.service;

import org.springframework.transaction.annotation.Transactional;
import ua.edu.khibs.resalex.Dao.IngredientDao;
import ua.edu.khibs.resalex.model.Ingredient;

import java.util.Set;

public class IngredientService {
    private IngredientDao ingredientDao;

    @Transactional
    public Set<Ingredient> getAllIngredient() {
        return ingredientDao.findAllIngredient();
    }

    @Transactional
    public void addNewIngredient(String name, Integer amount) {
        Ingredient newIngredient = new Ingredient();
        newIngredient.setName(name);
        newIngredient.setAmount(amount);
        ingredientDao.addNewIngredient(newIngredient);
    }

    @Transactional
    public void setIngredientDao(IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }
}