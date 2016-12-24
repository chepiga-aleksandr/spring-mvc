package ua.edu.khibs.resalex.Dao;

import ua.edu.khibs.resalex.model.Ingredient;

import java.util.Set;

public interface IngredientDao {

    Set<Ingredient> findAllIngredient();

    Ingredient findIngredientByName (String name);

    void  addNewIngredient (Ingredient ingredient);
}
