package xyz.apna.bazaar;

//import android.content.SharedPreferences;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import xyz.apna.bazaar.ui.onboarding.ViewPagerAdapter;

public class OnboardingActivity extends AppCompatActivity {

    protected ViewPager viewPager;

    protected Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_onboarding);

//        SharedPreferences.Editor preferencesEditor =
//                getSharedPreferences(getPackageName(), MODE_PRIVATE).edit();
//        preferencesEditor.putBoolean(getString(R.string.key_is_first_session), true);
//        preferencesEditor.apply();

        viewPager = (ViewPager) findViewById(R.id.OA_VP_slides);
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(adapter);

        btnNext = (Button) findViewById(R.id.OA_BTN_next);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OnboardingActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}