package com.example.hp.demo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {
    private int tabsNumber;

    public PagerAdapter(FragmentManager fm,int tabs) {
        super(fm);
        this.tabsNumber = tabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return new First();
            case 1:
                return new Second();
            case 2:
                 return new Third();
            default : return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0)
        {
            title = "Practice";
        }
        else if (position == 1)
        {
            title = "Score";
        }
        else if (position == 2)
        {
            title = "Leader Board";
        }
        return title;
    }

    @Override
    public int getCount() {
        return tabsNumber;
    }
}
