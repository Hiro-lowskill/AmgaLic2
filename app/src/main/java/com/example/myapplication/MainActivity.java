package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageSwitcher;

public class MainActivity extends AppCompatActivity {

    private ImageSwitcher mImageSwitcher;
    private final int SWITCH=2000;
    private final int SPLASH_DISPLAY_LENGHT=4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageSwitcher = (ImageSwitcher)findViewById(R.id.imageSwitcher);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mImageSwitcher.showNext();
                mImageSwitcher = (ImageSwitcher)findViewById(R.id.imageSwitcher);
                Animation inAnimation = new AlphaAnimation(0, 3);
                inAnimation.setDuration(2000);
                Animation outAnimation = new AlphaAnimation(3, 0);
                outAnimation.setDuration(2000);

                mImageSwitcher.setInAnimation(inAnimation);
                mImageSwitcher.setOutAnimation(outAnimation);
            }
        },SWITCH);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent main = new Intent(MainActivity.this, MainMenuActivity.class);
                MainActivity.this.startActivity(main);
                MainActivity.this.finish();
            }
        },SPLASH_DISPLAY_LENGHT);
    }
}