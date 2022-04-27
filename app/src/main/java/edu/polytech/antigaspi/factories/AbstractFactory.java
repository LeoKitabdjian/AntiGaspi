package edu.polytech.antigaspi.factories;

import edu.polytech.antigaspi.ingredients.Ingredient;
import edu.polytech.antigaspi.recipes.Recipe;
import edu.polytech.antigaspi.recipes.RecipeComponent;

public abstract class AbstractFactory {

    public abstract Ingredient buildIngredient(String nom);
    public abstract Recipe buildRecipe(RecipeComponent[] recipeComponent);

}
