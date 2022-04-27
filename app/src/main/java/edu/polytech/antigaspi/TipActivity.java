package edu.polytech.antigaspi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import static edu.polytech.antigaspi.ApplicationTip.TIP;

import edu.polytech.antigaspi.mainActivities.ActivitesPrincipales;


public class TipActivity extends ActivitesPrincipales {
    private Tip tip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip);
        createLinks();

        tip = getIntent().getParcelableExtra(TIP);
        ((TextView)findViewById( R.id.IngredientName)).setText(tip.getIngredientName());
        ((TextView)findViewById( R.id.ContenuTip)).setText(tip.getContenuTip());

        ((Button)findViewById(R.id.button)).setOnClickListener( click -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("TIP");
            builder.setMessage("Vous avez cliqué sur : " + tip);
            builder.setNeutralButton("OK", null);
            builder.show();
        });
    }
}