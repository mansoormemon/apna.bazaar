package xyz.apna.bazaar;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;

public class EntryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SplashScreen.installSplashScreen(this);

        Intent next_activity = null;
        boolean is_first_session = getSharedPreferences(getPackageName(), MODE_PRIVATE).getBoolean(getString(R.string.key_is_first_session), false);
        if (is_first_session) {
            next_activity = new Intent(this, MainActivity.class);
        } else {
            next_activity = new Intent(this, OnBoardingActivity.class);
        }
        startActivity(next_activity);

        finish();
    }
}