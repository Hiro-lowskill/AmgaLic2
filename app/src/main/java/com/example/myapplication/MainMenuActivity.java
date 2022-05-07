package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageSwitcher;

public class MainMenuActivity extends AppCompatActivity {

    private ImageSwitcher mImageSwitcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);
        mImageSwitcher = (ImageSwitcher)findViewById(R.id.imageSwitcher);
    }
    public void btn(View view){
        Intent i = new Intent(this,AuthorizeActivity.class);
        startActivity(i);
        finish();
    }
    public void onSwitcherClick(View view){
        mImageSwitcher.showNext();
    }

    public void btn2(View view) {
        Intent i = new Intent(this, UploadPhotoActivity.class);
        startActivity(i);
        finish();
    }
}