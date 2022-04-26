package edu.polytech.antigaspi.recipes;

public abstract class Recipe {
    private RecipeComponent[] recipeComponents;

    public Recipe(RecipeComponent[] recipeComponents) {
        this.recipeComponents = recipeComponents;
    }
}
