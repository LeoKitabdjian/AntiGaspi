package edu.polytech.antigaspi.mainActivities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.Observable;
import java.util.Observer;

import edu.polytech.antigaspi.QuantiteIngredient;
import edu.polytech.antigaspi.R;

public class MonFrigo extends ActivitesPrincipales implements Observer, View.OnClickListener {

    private QuantiteIngredient quantiteIngredient;


    private Button Button1;
    private Button Button2;
    private Button Button3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mon_frigo);
        createLinks();

        quantiteIngredient = new QuantiteIngredient();
        quantiteIngredient.addObserver(this);


        Button1 = findViewById(R.id.button);
        Button2 = findViewById(R.id.button2);
        Button3 = findViewById(R.id.button3);


        Button1.setOnClickListener(this);
        Button2.setOnClickListener(this);
        Button3.setOnClickListener(this);

    }

    @Override

    public void onClick(View v) {
        switch(v.getId()){

            case R.id.button:
                quantiteIngredient.setValueAtIndex(0);
                break;

            case R.id.button2:
                quantiteIngredient.setValueAtIndex(1);
                break;

            case R.id.button3:
                quantiteIngredient.setValueAtIndex(2);
                break;
        }
    }

    @Override

    public void update(Observable arg0, Object arg1) {

        Button1.setText("Count: "+quantiteIngredient.getValueAtIndex(0));
        Button2.setText("Count: "+quantiteIngredient.getValueAtIndex(1));
        Button3.setText("Count: "+quantiteIngredient.getValueAtIndex(2));

    }
}

