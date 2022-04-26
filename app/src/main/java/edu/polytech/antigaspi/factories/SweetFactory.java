package edu.polytech.antigaspi.factories;

import edu.polytech.antigaspi.ingredients.Ingredient;
import edu.polytech.antigaspi.ingredients.SweetIngredient;
import edu.polytech.antigaspi.recipes.Recipe;
import edu.polytech.antigaspi.recipes.RecipeComponent;
import edu.polytech.antigaspi.recipes.SweetRecipe;

public class SweetFactory extends AbstractFactory{
    @Override
    Ingredient buildIngredient(String nom) {
        return new SweetIngredient(nom);
    }

    @Override
    Recipe buildRecipe(RecipeComponent[] recipeComponent) {
        return new SweetRecipe(recipeComponent);
    }
}
