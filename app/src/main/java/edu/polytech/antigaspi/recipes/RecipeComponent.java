package edu.polytech.antigaspi.recipes;

import edu.polytech.antigaspi.ingredients.Ingredient;

public class RecipeComponent {
    private Ingredient ingredient;
    private int quantite;

    public RecipeComponent(Ingredient ingredient, int quantite) {
        this.ingredient = ingredient;
        this.quantite = quantite;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
