package edu.polytech.antigaspi.recipes;

import edu.polytech.antigaspi.ingredients.Ingredient;

public class RecipeComponent {
    private Ingredient ingredient;
    private int quantite;

    public RecipeComponent(Ingredient ingredient, int quantite) {
        this.ingredient = ingredient;
        this.quantite = quantite;
    }

}
