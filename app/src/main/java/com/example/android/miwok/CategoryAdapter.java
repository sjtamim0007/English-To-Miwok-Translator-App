package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public CategoryAdapter(Context context,FragmentManager fragmentManager) {
        super(fragmentManager);
        mContext = context;
    }



    @Override
    public Fragment getItem(int i) {
        if (i == 0) {
            return new NumbersFragment();
        } else if (i == 1) {
            return new ColorsFragment();
        } else if (i == 2) {
            return new FamilyFragment();
        } else {
            return new PhrasesFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }


    @Override
    public CharSequence getPageTitle(int i) {
        if (i == 0) {
            return mContext.getString(R.string.category_numbers);
        } else if (i == 1) {
            return mContext.getString(R.string.category_colors);
        } else if (i == 2) {
            return mContext.getString(R.string.category_family);
        } else {
            return mContext.getString(R.string.category_phrases);
        }
    }
}
