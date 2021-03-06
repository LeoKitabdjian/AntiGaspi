package edu.polytech.antigaspi.mainActivities;


import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.io.IOException;
import java.util.Map;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import edu.polytech.antigaspi.AjoutIngredientFrigo;
import edu.polytech.antigaspi.GlobalParams;
import edu.polytech.antigaspi.ObjectSerializer;
import edu.polytech.antigaspi.QuantiteIngredient;
import edu.polytech.antigaspi.R;
import edu.polytech.antigaspi.RecipeComponentAdapter;
import edu.polytech.antigaspi.recipes.RecipeComponents;

import static edu.polytech.antigaspi.Notification.CHANNEL_1_ID;

//import com.google.gson.Gson;

public class MonFrigo extends ActivitesPrincipales implements Observer, View.OnClickListener {

    private QuantiteIngredient quantiteIngredient;
    private int notificationId=0;

    private Button Button1;
    private Button Button2;
    private TextView Quantity;
    private Boolean activate;
    SharedPreferences prefs;

    @Override
    protected void onResume() {
        super.onResume();
        boolean activated = retrieveNotifs();
        disableNotifs();
        ((Switch) findViewById(R.id.switchNotifs)).setChecked(activated);
        handleNotifs();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mon_frigo);
        prefs = this.getSharedPreferences("fridge", Context.MODE_PRIVATE);
        createLinks(R.mipmap.fridge_icon, "Mon Frigo");
        handleNotifs();

        SharedPreferences prefs2 = this.getSharedPreferences("add_ingredient", MODE_PRIVATE);
        String listIngredients = prefs2.getString("Liste", "");
        if (!listIngredients.equals("")) {
            Log.d("Liste", listIngredients);
            try {
                RecipeComponents.replaceInstance((RecipeComponents) ObjectSerializer.deserialize(listIngredients));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        quantiteIngredient = new QuantiteIngredient();
        quantiteIngredient.addObserver(this);

        ListView list = findViewById(R.id.componentsList);

        list.setAdapter(new RecipeComponentAdapter(this));

        /*Button1 = findViewById(R.id.button);
        Button2 = findViewById(R.id.button2);
        Quantity = findViewById(R.id.quantity);


        Button1.setOnClickListener(this);
        Button2.setOnClickListener(this);*/

        findViewById(R.id.btnAjoutIngredient).setOnClickListener(this);

    }

    private void disableNotifs() {
        ((Switch)findViewById(R.id.switchNotifs)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

            }
        });
    }

    private void handleNotifs() {
        ((Switch)findViewById(R.id.switchNotifs)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                setNotifs(b);
                String title="";
                String message="";
                if(retrieveNotifs()) {
                    title = "Notification activ??e";
                    message = "Vous avez maintenant activ?? les notifications";
                }
                else{
                    title = "Notification d??sactiv??e";
                    message = "Vous avez maintenant d??sactiv?? les notifications";
                }
                sendNotificationOnChannel(title, message, CHANNEL_1_ID, NotificationCompat.PRIORITY_HIGH);

                final Handler handler = new Handler(Looper.getMainLooper());

                int toCancel = notificationId;

                handler.postDelayed(() -> cancelNotification(getApplicationContext(), toCancel), 5000);
            }
        });
    }

    @Override

    public void onClick(View v) {
        switch(v.getId()){

            /*case R.id.button:
                quantiteIngredient.setValuePlus1(0);
                break;

            case R.id.button2:
                if (quantiteIngredient.getValueAtIndex(0)>1) {
                    quantiteIngredient.setValueMinus1(0);}
                else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage("Are you sure you want to exit?")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    MonFrigo.this.finish();
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();
                }
                break;*/
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
    private void sendNotificationOnChannel(String title, String content, String channelId, int priority) {
        Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.notif);
        ++notificationId;
        NotificationCompat.Builder notification = new NotificationCompat.Builder(this, channelId)
                .setContentTitle(title)
                .setContentText(content)
                .setPriority(priority)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap))
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC);

        notification.setSmallIcon( R.drawable.channel3 );
        NotificationManagerCompat.from(this).notify( notificationId, notification.build() );
    }

    public static void cancelNotification(Context ctx, int notifyId) {
        String ns = Context.NOTIFICATION_SERVICE;
        NotificationManager nMgr = (NotificationManager) ctx.getSystemService(ns);
        nMgr.cancel(notifyId);
    }

    public void setNotifs(boolean b) {
        Log.d("notifs", "J'enregistre :" + b);
        prefs.edit().putBoolean("Fridge notifs", b).apply();
    }

    public boolean retrieveNotifs() {
        boolean b = prefs.getBoolean("Fridge notifs", false);
        Log.d("notifs", "Je reprends : " + b);
        return b;
    }

}