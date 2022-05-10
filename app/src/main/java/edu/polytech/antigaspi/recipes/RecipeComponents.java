package edu.polytech.antigaspi.recipes;

import android.content.SharedPreferences;

import java.util.ArrayList;

import edu.polytech.antigaspi.factories.SaltFactory;
import edu.polytech.antigaspi.factories.SweetFactory;

public class RecipeComponents extends ArrayList<RecipeComponent> {
    private static RecipeComponents recipeComponents;

    private RecipeComponents(){
        SaltFactory saltFactory = new SaltFactory();
        SweetFactory sweetFactory = new SweetFactory();
        add(new RecipeComponent(saltFactory.buildIngredient("Fromage"), 8));
        add(new RecipeComponent(saltFactory.buildIngredient("Tomate"), 2));
        add(new RecipeComponent(sweetFactory.buildIngredient("Pomme"), 5));
        add(new RecipeComponent(sweetFactory.buildIngredient("Banane"), 3));
    }

    public static void addComponent(RecipeComponent recipeComponent) {
        recipeComponents.add(recipeComponent);
    }

    public static void replaceInstance(RecipeComponents recipeComponents) {
        RecipeComponents.recipeComponents = recipeComponents;
    }

    public static RecipeComponents getInstance() {
        if (recipeComponents == null) {
            recipeComponents = new RecipeComponents();
        }
        return recipeComponents;
    }

}