package xyz.apna.bazaar.ui.onboarding;

import xyz.apna.bazaar.R;

public enum ViewPagerModelObject {
    PAGE_1(R.string.id_pager_onboarding_page_1, R.layout.pager_onboarding_page_1),
    PAGE_2(R.string.id_pager_onboarding_page_2, R.layout.pager_onboarding_page_2);

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
