package edu.polytech.antigaspi;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class QuantiteIngredient extends Observable {

    private java.util.List<Integer> List;

    // constructor to initialize the list
    public QuantiteIngredient(){
        List = new ArrayList<Integer>(3);

        List.add(0);
        List.add(0);
        List.add(0);
    }

    public int getValueAtIndex(final int the_index) throws IndexOutOfBoundsException{
        return List.get(the_index);
    }

    // function to make changes in the activity button's
    // count value when user touch it
    public void setValueAtIndex(final int the_index) throws IndexOutOfBoundsException{
        List.set(the_index,List.get(the_index) + 1);
        setChanged();
        notifyObservers();
    }

}
