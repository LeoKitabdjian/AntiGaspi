package edu.polytech.antigaspi.fragments;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import java.util.Objects;

import edu.polytech.antigaspi.IPictureActivity;
import edu.polytech.antigaspi.R;

public class PhotoFragment extends Fragment {
    private ImageView imageView;

    public PhotoFragment(){
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle){
        View rootView= inflater.inflate(R.layout.fragment_photo,container, false);
        imageView=rootView.findViewById(R.id.photo);
        rootView.findViewById(R.id.buttonImage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //pour demander la permission si elle a pas été demander
                if(ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA)== PackageManager.PERMISSION_DENIED){
                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA}, IPictureActivity.REQUEST_CAMERA);
                }
                else{
                    takePicture();
                }
            }
        });
        Log.d("Nol",this.toString());
        return rootView;
    }

    public void takePicture(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        requireActivity().startActivityForResult(intent,IPictureActivity.REQUEST_CAMERA);
    }

    public void setImage(Bitmap bitmap){
        imageView.setImageBitmap(bitmap);
    }

}
