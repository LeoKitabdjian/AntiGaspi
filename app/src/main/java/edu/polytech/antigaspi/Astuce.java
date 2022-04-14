package edu.polytech.antigaspi;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.graphics.BitmapFactory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import static edu.polytech.antigaspi.ApplicationDemo.CHANNEL_1_ID;
import static edu.polytech.antigaspi.ApplicationDemo.CHANNEL_2_ID;
import static edu.polytech.antigaspi.ApplicationDemo.CHANNEL_3_ID;

public class Astuce extends AppCompatActivity {

    private int notificationId=0;
    private void sendNotificationOnChannel(String title, String content, String channelId, int priority) {
        Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.graou);
        NotificationCompat.Builder notification = new NotificationCompat.Builder(this, channelId)
                .setContentTitle(title)
                .setContentText("id=" + ++notificationId + " - " + content)
                .setPriority(priority)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap)) ;// <---- Look here
        switch(channelId) {
            case CHANNEL_1_ID: notification.setSmallIcon( R.drawable.channel1 ); break;
            case CHANNEL_2_ID: notification.setSmallIcon( R.drawable.channel2 ); break;
            case CHANNEL_3_ID: notification.setSmallIcon( R.drawable.channel3 ); break;
        }
        NotificationManagerCompat.from(this).notify( notificationId, notification.build() );
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.astuce);

        findViewById( R.id.buttonNotify1 ).setOnClickListener( click -> {
            Log.d("fredrallo_","go to nofity");
            String title = ((EditText) findViewById( R.id.edit_text_title)).getText().toString();
            String message = ((EditText) findViewById( R.id.edit_text_message)).getText().toString();
            sendNotificationOnChannel( title, message, CHANNEL_1_ID, NotificationCompat.PRIORITY_LOW );
        });

        findViewById( R.id.buttonNotify2 ).setOnClickListener( click -> {
            Log.d("fredrallo_","go to nofity");
            String title = ((EditText) findViewById( R.id.edit_text_title)).getText().toString();
            String message = ((EditText) findViewById( R.id.edit_text_message)).getText().toString();
            sendNotificationOnChannel( title, message, CHANNEL_2_ID, NotificationCompat.PRIORITY_DEFAULT );
        });

        findViewById( R.id.buttonNotify3 ).setOnClickListener( click -> {
            Log.d("fredrallo_","go to nofity");
            String title = ((EditText) findViewById( R.id.edit_text_title)).getText().toString();
            String message = ((EditText) findViewById( R.id.edit_text_message)).getText().toString();
            sendNotificationOnChannel( title, message, CHANNEL_3_ID, NotificationCompat.PRIORITY_HIGH );
        });
    }
}
