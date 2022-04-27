package edu.polytech.antigaspi.mainActivities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.annotation.Nullable;

import java.util.Map;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import edu.polytech.antigaspi.AjoutIngredientFrigo;
import edu.polytech.antigaspi.GlobalParams;
import edu.polytech.antigaspi.QuantiteIngredient;
import edu.polytech.antigaspi.R;

public class MonFrigo extends ActivitesPrincipales implements Observer, View.OnClickListener {

    private QuantiteIngredient quantiteIngredient;


    private Button Button1;
    private Button Button2;
    private TextView Quantity;

    @Override
    protected void onPause() {
        super.onPause();
        
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mon_frigo);
        createLinks(R.mipmap.fridge_icon, "Mon Frigo");

        ((Switch)findViewById(R.id.switchNotifs)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                GlobalParams.NOTIFS = b;
                Log.i("Notifs", String.valueOf(b));
            }
        });

        quantiteIngredient = new QuantiteIngredient();
        quantiteIngredient.addObserver(this);


        Button1 = findViewById(R.id.button);
        Button2 = findViewById(R.id.button2);
        Quantity = findViewById(R.id.quantity);


        Button1.setOnClickListener(this);
        Button2.setOnClickListener(this);

        findViewById(R.id.btnAjoutIngredient).setOnClickListener(this);

    }

    @Override

    public void onClick(View v) {
        switch(v.getId()){

            case R.id.button:
                quantiteIngredient.setValuePlus1(0);
                break;

            case R.id.button2:
                quantiteIngredient.setValueMinus1(0);
                break;
            case R.id.btnAjoutIngredient:
                Intent intent = new Intent(MonFrigo.this, AjoutIngredientFrigo.class);
                startActivity(intent);
                break;
        }
    }

    @Override

    public void update(Observable arg0, Object arg1) {

        Quantity.setText("Quantity : "+quantiteIngredient.getValueAtIndex(0));

    }
}