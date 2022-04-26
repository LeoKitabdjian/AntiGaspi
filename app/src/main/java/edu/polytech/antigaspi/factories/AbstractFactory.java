package edu.polytech.antigaspi.factories;

import edu.polytech.antigaspi.ingredients.Ingredient;
import edu.polytech.antigaspi.recipes.Recipe;
import edu.polytech.antigaspi.recipes.RecipeComponent;

public abstract class AbstractFactory {

    abstract Ingredient buildIngredient(String nom);
    abstract Recipe buildRecipe(RecipeComponent[] recipeComponent);

}
