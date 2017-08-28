package com.example.eric.gmn.splash;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.eric.gmn.MainActivity;
import com.example.eric.gmn.R;

public class SplashScreen extends AppCompatActivity {
    private static  int spalsh_time_out=3000;
    ImageView imageView;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        imageView=(ImageView)findViewById(R.id.splashimage);
        swipeRefreshLayout=(SwipeRefreshLayout)findViewById(R.id.swipeContainer);

        swipeRefreshLayout.setProgressBackgroundColorSchemeResource(R.color.colorAccent);
        swipeRefreshLayout.setBackgroundResource(android.R.color.white);
        swipeRefreshLayout.setColorSchemeResources(android.R.color.white, android.R.color.holo_purple, android.R.color.white);

        swipeRefreshLayout.setRefreshing(true);
        Animation rotate= AnimationUtils.loadAnimation(SplashScreen.this,R.anim.rotate);
       // imageView.startAnimation(rotate);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(false);

                startActivity(new Intent(SplashScreen.this, MainActivity.class));
                finish();
            }

        },spalsh_time_out);

    }
}
