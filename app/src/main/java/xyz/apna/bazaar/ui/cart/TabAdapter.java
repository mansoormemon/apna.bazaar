package xyz.apna.bazaar.ui.cart;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class TabAdapter extends FragmentStateAdapter {
    protected int tabCount;

    public TabAdapter(Fragment fragment, int tabCount_) {
        super(fragment);

        tabCount = tabCount_;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return position == 0 ? new CurrentFragment() : new HistoryFragment();
    }

    @Override
    public int getItemCount() {
        return tabCount;
    }
}
