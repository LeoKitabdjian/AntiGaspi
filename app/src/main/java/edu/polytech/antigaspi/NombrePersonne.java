package edu.polytech.antigaspi;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class NombrePersonne extends Observable {

    public List<Integer> List;

    // constructor to initialize the list
    public NombrePersonne(){
        List = new ArrayList<Integer>(3);

        List.add(0);
    }

    public int getValueAtIndex(final int the_index) throws IndexOutOfBoundsException{
        return List.get(the_index);
    }

    // function to make changes in the activity button's
    // count value when user touch it
    public void setValuePlus1(final int the_index) throws IndexOutOfBoundsException{
        List.set(the_index,List.get(the_index) + 1);
        setChanged();
        notifyObservers();
    }
    public void setValueMinus1(final int the_index) throws IndexOutOfBoundsException {
        if (List.get(the_index)>0){
            List.set(the_index, List.get(the_index) - 1);
            setChanged();
            notifyObservers();
        }
    }

}