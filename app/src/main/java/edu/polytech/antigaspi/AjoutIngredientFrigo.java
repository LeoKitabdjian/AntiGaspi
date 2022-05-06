package edu.polytech.antigaspi;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class AjoutIngredientFrigo extends AppCompatActivity {
    public Calendar calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajout_ingredient_frigo);
        Intent intent = getIntent();
        String date = intent.getStringExtra("date");
        TextView msg = findViewById(R.id.DateP);
        msg.setText(date);
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
                        intent.putExtra("title", "A Test Event from android app");
                        startActivity(intent);
                    }
                };
                DatePickerDialog datePickerDialog = new DatePickerDialog(view.getContext(),
                        dateSetListener, year, month, day);
                datePickerDialog.show();

            }
        });
    }
    public void setTime(int year, int month, int dayOfMonth){
        calendar = new GregorianCalendar(year, month, dayOfMonth);
    }
}
