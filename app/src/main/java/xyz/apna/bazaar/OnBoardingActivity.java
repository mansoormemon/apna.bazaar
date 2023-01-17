package xyz.apna.bazaar;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

enum ViewPagerModelObject {
    PAGE_1(0, R.layout.activity_on_boarding_page_1),
    PAGE_2(1, R.layout.activity_on_boarding_page_2);

    private final int title;
    private final int layout;

    ViewPagerModelObject(int title, int layout) {
        this.title = title;
        this.layout = layout;
    }

    public int getTitle() {
        return title;
    }

    public int getLayout() {
        return layout;
    }
}

class ViewPagerAdapter extends PagerAdapter {
    protected Context context;

    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup collection, int position) {
        ViewPagerModelObject modelObject = ViewPagerModelObject.values()[position];
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewGroup layout = (ViewGroup) inflater.inflate(modelObject.getLayout(), collection, false);
        collection.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, @NonNull Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return ViewPagerModelObject.values().length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        ViewPagerModelObject viewPagerModelObject = ViewPagerModelObject.values()[position];
        return context.getString(viewPagerModelObject.getTitle());
    }
}


public class OnBoardingActivity extends AppCompatActivity {
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

//        SharedPreferences.Editor preferences_editor = getSharedPreferences(getPackageName(), MODE_PRIVATE).edit();
//        preferences_editor.putBoolean(getString(R.string.key_is_first_session), true);
//        preferences_editor.apply();

        viewPager = findViewById(R.id.OBA_VP_onBoardingPagerView);
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(adapter);
    }
}