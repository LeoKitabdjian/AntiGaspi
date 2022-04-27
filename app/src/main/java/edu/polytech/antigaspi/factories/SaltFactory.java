package edu.polytech.antigaspi.factories;

import edu.polytech.antigaspi.ingredients.Ingredient;
import edu.polytech.antigaspi.ingredients.SaltIngredient;
import edu.polytech.antigaspi.recipes.Recipe;
import edu.polytech.antigaspi.recipes.RecipeComponent;
import edu.polytech.antigaspi.recipes.SaltRecipe;

public class SaltFactory extends AbstractFactory{
    @Override
    public Ingredient buildIngredient(String nom) {
        return new SaltIngredient(nom);
    }

    @Override
    public Recipe buildRecipe(RecipeComponent[] recipeComponent) {
        return new SaltRecipe(recipeComponent);
    }
}
