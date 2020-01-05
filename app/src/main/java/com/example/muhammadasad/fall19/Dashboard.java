package com.example.muhammadasad.fall19;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.muhammadasad.fall19.firebase.FireBaseMessagingServiceTest;
import com.example.muhammadasad.fall19.firebase.MapsActivity;
import com.example.muhammadasad.fall19.services.ServiceActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class Dashboard extends AppCompatActivity {

    Button signIn;
    Button singUp;
    ImageView img;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        signIn = findViewById(R.id.signin);
        singUp = findViewById(R.id.signup);
        img = findViewById(R.id.imageView);
        auth = FirebaseAuth.getInstance();
        checkLoginStatus();


    }

    private void checkLoginStatus(){
        if(auth.getCurrentUser() != null){
            Intent intent = new  Intent(this, Main2Activity.class);
            startActivity(intent);
            finish();
        }
    }

    public void signInClick(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);


    }

    public void signUpClick(View v){
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }

    public void showImage(View v) {
       loadImage();
    }

    private void loadImage(){
        Picasso.get().load("https://cdn.journaldev.com/wp-content/uploads/2016/11/android-image-picker-project-structure.png").into(img, new Callback() {
            @Override
            public void onSuccess() {
                Log.e("TAG", "Sucesss");
            }

            @Override
            public void onError(Exception e) {
                Log.e("TAG", "Faliure");
            }
        });
    }

    public void onStartService(View v){
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
        checkfirebasetoken();

    }

    private void checkfirebasetoken(){
        Log.e("My Tag", "123456789");
        FirebaseInstanceId.getInstance().getToken();
        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if (!task.isSuccessful()) {
                            Log.e("My Tag", "getInstanceId failed", task.getException());
                            return;
                        }

                        // Get new Instance ID token
                        String token = task.getResult().getToken();
                        Log.e("My Tag", token);

                        // Log and toast

//                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });
//        sendNotification("Title" , "Stefajsnda");
    }

//    private void sendNotification(String title, String body){
//        createNotificationChannel();
//        Intent notificationIntent = new Intent(this, Dashboard.class);
//        PendingIntent pendingIntent = PendingIntent.getActivity(this,
//                0, notificationIntent, 0);
//        Notification notification = new NotificationCompat.Builder(this, FireBaseMessagingServiceTest.CHANNEL_ID)
//                .setContentTitle(title)
//                .setContentText(body)
//                .setSmallIcon(R.drawable.ic_launcher_background)
//                .addAction(R.drawable.common_google_signin_btn_text_light,"OK", pendingIntent)
//                .setContentIntent(pendingIntent)
//                .build();
//        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//        notificationManager.notify(0,notification);
//
//    }
//    private void createNotificationChannel() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            NotificationChannel serviceChannel = new NotificationChannel(
//                    FireBaseMessagingServiceTest.CHANNEL_ID,
//                    "Foreground Service Channel",
//                    NotificationManager.IMPORTANCE_DEFAULT
//            );
//            NotificationManager manager = getSystemService(NotificationManager.class);
//            manager.createNotificationChannel(serviceChannel);
//        }
//    }
}
