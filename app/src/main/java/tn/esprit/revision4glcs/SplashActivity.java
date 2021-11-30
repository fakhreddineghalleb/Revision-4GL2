package tn.esprit.revision4glcs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    private SharedPreferences mPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mPref = getSharedPreferences("tn.esprit.revision4glcs", MODE_PRIVATE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainInent = new Intent(SplashActivity.this, LoginActivity.class);

                if (mPref.getBoolean("REMEMBER", false)){
                    mainInent = new Intent(SplashActivity.this, HomeActivity.class);
                }

                startActivity(mainInent);
                finish();
            }
        }, 3000);

    }
}