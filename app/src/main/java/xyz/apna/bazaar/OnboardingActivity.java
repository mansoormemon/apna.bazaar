package xyz.apna.bazaar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

import xyz.apna.bazaar.ui.onboarding.ViewPagerAdapter;
import xyz.apna.bazaar.ui.onboarding.ViewPagerModelObject;

public class OnboardingActivity extends AppCompatActivity {

    protected ViewPager viewPager;
    protected TabLayout pageIndicator;

    protected Button btnGetStarted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_onboarding);

        SharedPreferences.Editor preferencesEditor = getSharedPreferences(getPackageName(), MODE_PRIVATE).edit();
        preferencesEditor.putBoolean(getString(R.string.key_is_first_session), true);
        preferencesEditor.apply();

        viewPager = findViewById(R.id.OA_VP_slides);
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                final int LAST_PAGE_INDEX = ViewPagerModelObject.values().length - 1;
                btnGetStarted.setVisibility(position == LAST_PAGE_INDEX ? View.VISIBLE : View.INVISIBLE);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        pageIndicator = findViewById(R.id.OA_TL_pageIndicator);
        for (View v : pageIndicator.getTouchables()) {
            v.setClickable(false);
        }
        pageIndicator.setupWithViewPager(viewPager);

        for (int i = 0; i < pageIndicator.getTabCount(); ++i) {
            Objects.requireNonNull(pageIndicator.getTabAt(i)).setText(R.string.empty_string);
        }

        btnGetStarted = findViewById(R.id.OA_BTN_getStarted);
        btnGetStarted.setOnClickListener(v -> {
            Intent intent = new Intent(OnboardingActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
}