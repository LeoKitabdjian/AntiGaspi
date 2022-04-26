package edu.polytech.antigaspi;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import edu.polytech.antigaspi.fragments.PhotoFragment;

public class PhotoIngredient extends AppCompatActivity implements IPictureActivity {
    private Bitmap photo;
    private PhotoFragment photoFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo_ingredient);
        photoFragment = (PhotoFragment) getSupportFragmentManager().findFragmentById(R.id.photo);
        if(photoFragment==null){
            photoFragment=new PhotoFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.photoFragment, photoFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }

    @Override
    public void onRequestPermissionsResult (int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_CAMERA: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast toast = Toast.makeText(getApplicationContext(), "CAMERA Authorisation granted", Toast.LENGTH_LONG);
                    toast.show();
                    photoFragment.takePicture();
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "CAMERA Authorisation not granted", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
            break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CAMERA){
            if (resultCode==RESULT_OK){
                photo=(Bitmap) data.getExtras().get("data");
                photoFragment.setImage(photo);
                Intent intent = new Intent(PhotoIngredient.this, AjoutIngredientFrigo.class);
                intent.putExtra("date","14/05/2022");
                startActivity(intent);}
            else if(resultCode==RESULT_CANCELED){
                Toast toast = Toast.makeText(getApplicationContext(), "photo annulée", Toast.LENGTH_LONG);
                toast.show();
            }
            else{
                Toast toast = Toast.makeText(getApplicationContext(), "L'action n'a pas fonctionné", Toast.LENGTH_LONG);
                toast.show();
            }

        }

    }
}
