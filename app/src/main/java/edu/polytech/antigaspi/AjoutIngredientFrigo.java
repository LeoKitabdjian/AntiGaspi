package edu.polytech.antigaspi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class AjoutIngredientFrigo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajout_ingredient_frigo);
        findViewById(R.id.logoPhoto).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AjoutIngredientFrigo.this, PhotoIngredient.class);
                startActivity(intent);
            }
        });
    }
}
