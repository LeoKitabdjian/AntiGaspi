package edu.polytech.antigaspi.factories;

import edu.polytech.antigaspi.ingredients.Ingredient;
import edu.polytech.antigaspi.ingredients.SaltIngredient;
import edu.polytech.antigaspi.recipes.Recipe;
import edu.polytech.antigaspi.recipes.RecipeComponent;
import edu.polytech.antigaspi.recipes.SaltRecipe;

public class SaltFactory extends AbstractFactory{
    @Override
    Ingredient buildIngredient(String nom) {
        return new SaltIngredient(nom);
    }

    @Override
    Recipe buildRecipe(RecipeComponent[] recipeComponent) {
        return new SaltRecipe(recipeComponent);
    }
}
