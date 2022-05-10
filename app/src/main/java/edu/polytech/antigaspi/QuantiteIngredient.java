package edu.polytech.antigaspi;

import android.content.DialogInterface;

import java.util.ArrayList;
import java.util.Observable;
import androidx.appcompat.app.AlertDialog;

import edu.polytech.antigaspi.mainActivities.MonFrigo;
import edu.polytech.antigaspi.recipes.RecipeComponent;
import edu.polytech.antigaspi.recipes.RecipeComponents;


public class QuantiteIngredient extends Observable {

    private ArrayList<RecipeComponent> list;

    // constructor to initialize the list
    public QuantiteIngredient(){
        list = RecipeComponents.getInstance();
    }

    public int getValueAtIndex(final int the_index) throws IndexOutOfBoundsException{
        return list.get(the_index).getQuantite();
    }

    // function to make changes in the activity button's
    // count value when user touch it
    public void setValuePlus1(final int the_index) throws IndexOutOfBoundsException{
        list.get(the_index).setQuantite(list.get(the_index).getQuantite()+1);
        setChanged();
        notifyObservers();
    }
    public void setValueMinus1(final int the_index) throws IndexOutOfBoundsException {
        if (list.get(the_index).getQuantite()>1){
            list.get(the_index).setQuantite(list.get(the_index).getQuantite()-1);
            setChanged();
            notifyObservers();
        }
    }

}