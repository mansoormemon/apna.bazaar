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

        boolean isFirstSession =
                getSharedPreferences(getPackageName(), MODE_PRIVATE)
                        .getBoolean(getString(R.string.key_is_first_session), false);

        Intent nextActivity = isFirstSession
                ? new Intent(this, SignInActivity.class)
                : new Intent(this, OnboardingActivity.class);
        startActivity(nextActivity);

        finish();
    }
}