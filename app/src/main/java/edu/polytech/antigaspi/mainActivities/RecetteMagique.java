package edu.polytech.antigaspi.mainActivities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;

import edu.polytech.antigaspi.NombrePersonne;
import edu.polytech.antigaspi.R;

public class RecetteMagique extends ActivitesPrincipales implements Observer, View.OnClickListener {
        private NombrePersonne nbPers;

        private Button Button1;
        private Button Button2;
        private TextView NbPers;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.recette_magique);
                createLinks();

                nbPers = new NombrePersonne();
                nbPers.addObserver(this);

                Button1 = findViewById(R.id.button);
                Button2 = findViewById(R.id.button2);
                NbPers = findViewById(R.id.nbpers);

                Button1.setOnClickListener(this);
                Button2.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
                switch(v.getId()){
                        case R.id.button:
                                nbPers.setValuePlus1(0);
                                break;

                        case R.id.button2:
                                nbPers.setValueMinus1(0);
                                break;
                        }
        }

        @Override
        public void update(Observable arg0, Object arg1) {
                NbPers.setText("Nombre de Personne(s) : "+ nbPers.getValueAtIndex(0));
        }
}