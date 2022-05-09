package edu.polytech.antigaspi;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import edu.polytech.antigaspi.fragments.PhotoFragment;

public class AjoutIngredientFrigo extends AppCompatActivity {
    private PhotoFragment photoFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajout_ingredient_frigo);
        Intent intent = getIntent();
        String date = intent.getStringExtra("date");
        TextView msg = findViewById(R.id.DateP);
        msg.setText(date);
        View frag= findViewById(R.id.photoFrag);

        findViewById(R.id.logoPhoto).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AjoutIngredientFrigo.this, PhotoIngredient.class);
                startActivity(intent);
            }
        });
        //Log.d("Nolwenn",photoFragment.toString());
    }
}
