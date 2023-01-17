package xyz.apna.bazaar;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class OnBoardingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

        SharedPreferences.Editor preferences_editor = getSharedPreferences(getPackageName(), MODE_PRIVATE).edit();
        preferences_editor.putBoolean(getString(R.string.key_is_first_session), true);
        preferences_editor.apply();
    }
}