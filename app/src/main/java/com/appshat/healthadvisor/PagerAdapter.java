package com.appshat.healthadvisor;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {
    private int tabsNumber;
    public PagerAdapter(@NonNull FragmentManager fm, int behavior, int tabs) {
        super( fm, behavior );
        this.tabsNumber = tabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Newbornbaby_fragment();
            case 1:
                return new Children_fragment();
            case 2:
                return new Tika_fragment();
            case 3:
                return new Helpline_fragment();
            case 4:
                return new NearbyHospital_fragment();
            case 5:
                return new Requird_nutrition_fragment();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return tabsNumber;
    }
}
