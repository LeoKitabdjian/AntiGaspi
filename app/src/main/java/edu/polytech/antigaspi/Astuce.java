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

import static edu.polytech.antigaspi.Notification.CHANNEL_1_ID;

public class Astuce extends AppCompatActivity {

    private int notificationId=0;
    private void sendNotificationOnChannel(String title, String content, String channelId, int priority) {
        Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.dlc);
        NotificationCompat.Builder notification = new NotificationCompat.Builder(this, channelId)
                .setContentTitle(title)
                .setContentText("id=" + ++notificationId + " - " + content)
                .setPriority(priority)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap)) ;// <---- Look here

        notification.setSmallIcon( R.drawable.channel3 );
        NotificationManagerCompat.from(this).notify( notificationId, notification.build() );
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.astuce);

        findViewById( R.id.buttonNotify1 ).setOnClickListener( click -> {
            Log.d("Antigaspi","go to nofity");
            String title = "Notif sur une astuce du jour";
            String message = "les oeufs se conservent au frais et non";
            sendNotificationOnChannel( title, message, CHANNEL_1_ID, NotificationCompat.PRIORITY_LOW );
        });
    }
}
