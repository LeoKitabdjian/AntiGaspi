package edu.polytech.antigaspi;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

//import com.google.gson.Gson;

import edu.polytech.antigaspi.fragments.PhotoFragment;
import edu.polytech.antigaspi.ingredients.SaltIngredient;
import edu.polytech.antigaspi.mainActivities.MonFrigo;
import edu.polytech.antigaspi.recipes.RecipeComponent;
import edu.polytech.antigaspi.recipes.RecipeComponents;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class AjoutIngredientFrigo extends AppCompatActivity {
    private PhotoFragment photoFragment;
    private Calendar calendar;
    private SharedPreferences prefs;
    private EditText quantity;
    private EditText name;
    private EditText date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajout_ingredient_frigo);
        prefs = this.getSharedPreferences("add_ingredient", Context.MODE_PRIVATE);
        quantity = (EditText) findViewById(R.id.add_ingredient_quantity);
        name = (EditText) findViewById(R.id.add_ingredient_name);
        date = (EditText) findViewById(R.id.add_ingredient_date);
        Intent intent = getIntent();
        String dateFromPhoto = intent.getStringExtra("date");
        date.setText(dateFromPhoto);
        findViewById(R.id.logoPhoto).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AjoutIngredientFrigo.this, PhotoIngredient.class);
                startActivity(intent);
            }
        });
        calendar= Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        int year = calendar.get(Calendar.YEAR);
        int month  = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        ImageView button = (ImageView) findViewById(R.id.logoAgenda);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                        setTime(year,monthOfYear,dayOfMonth);
                        long time = calendar.getTime().getTime();
                        Intent intent = new Intent(Intent.ACTION_EDIT);
                        intent.setType("vnd.android.cursor.item/event");
                        intent.putExtra("beginTime",time);
                        intent.putExtra("allDay", true);
                        intent.putExtra("rule", "FREQ=YEARLY");
                        intent.putExtra("endTime", time+60*60*1000);
                        intent.putExtra("title", "Date de péremption de : " + name.getText());
                        startActivity(intent);
                    }
                };
                DatePickerDialog datePickerDialog = new DatePickerDialog(view.getContext(),
                        dateSetListener, year, month, day);
                datePickerDialog.show();

            }
        });
        handleSaveButton();
    }

    private void handleSaveButton() {
        ((Button) findViewById(R.id.confirmButton)).setOnClickListener(view -> {
            if (name.getText().toString().length() != 0 && quantity.getText().toString().length() != 0 && date.getText().toString().length() != 0) {
                prefs.edit().remove("Ingredient name").apply();
                prefs.edit().remove("Ingredient quantity").apply();
                RecipeComponents.addComponent(new RecipeComponent(new SaltIngredient(name.getText().toString()),
                        Integer.parseInt(quantity.getText().toString())));
                name.setText("");
                quantity.setText("");
                //prefs.edit().putString("Liste", new Gson().toJson(RecipeComponents.getInstance())).apply();
                try {
                    prefs.edit().putString("Liste", ObjectSerializer.serialize(RecipeComponents.getInstance())).apply();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Log.d("liste 2", prefs.getString("Liste", ""));
                Intent intent = new Intent(AjoutIngredientFrigo.this, MonFrigo.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        prefs.edit().putString("Ingredient name", name.getText().toString()).apply();
        prefs.edit().putString("Ingredient quantity", quantity.getText().toString()).apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        name.setText(prefs.getString("Ingredient name", ""));
        quantity.setText(prefs.getString("Ingredient quantity", ""));
    }

    public void setTime(int year, int month, int dayOfMonth){
        calendar = new GregorianCalendar(year, month, dayOfMonth);
    }

}
