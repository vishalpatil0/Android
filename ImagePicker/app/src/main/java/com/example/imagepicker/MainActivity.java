package com.example.imagepicker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imgv;
    private FloatingActionButton fab,fab2;
    private CircleImageView profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgv=findViewById(R.id.imageView);
        fab=findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImagePicker.with(MainActivity.this)
//                        .galleryOnly()              //gallery only pick option
//                        .cameraOnly()               //camera only option
//                        .crop()	    			//Crop image(Optional), Check Customization for more option
//                        .crop(16f, 9f)       	//Crop image with 16:9 aspect ratio
//                        .cropSquare()	//Crop square image, its same as crop(1f, 1f)
//                        .compress(1024)	//Final image size will be less than 1 MB
//                        .maxResultSize(620, 620)	//Final image resolution will be less than 620 x 620
//                        .compress(1024)			//Final image size will be less than 1 MB(Optional)
//                        .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                        .start(10);
            }
        });
        fab2=findViewById(R.id.floatingActionButton2);
        profile=findViewById(R.id.profile_image);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImagePicker.with(MainActivity.this).crop().start(20);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==10) {
            Uri uri = data.getData();
            imgv.setImageURI(uri);
        }
        else if(requestCode==20)
        {
            Uri uri=data.getData();
            profile.setImageURI(uri);
        }
        else if (resultCode == ImagePicker.RESULT_ERROR) {
            Toast.makeText(this, ImagePicker.getError(data), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Task Cancelled", Toast.LENGTH_SHORT).show();
        }
    }
}