package ua.edu.khibs.resalex.Dao;

import ua.edu.khibs.resalex.model.Ingredient;

import java.util.Set;

public interface IngredientDao {

    Set<Ingredient> findAllIngredient();

    Ingredient findIngredientByName (String name);

    Ingredient  findIngredientById (Long id);

    void updateIngredient (Ingredient ingredient);

    void  addNewIngredient (Ingredient ingredient);

    void deleteIngredient (Ingredient ingredient);
}
