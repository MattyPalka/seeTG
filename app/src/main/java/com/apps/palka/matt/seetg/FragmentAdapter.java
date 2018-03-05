package com.apps.palka.matt.seetg;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by matt on 05.03.2018.
 */

public class FragmentAdapter extends FragmentPagerAdapter {

    /**
     * Context of the app
     */
    private Context mContext;

    /**
     * @param context is the context of the app
     * @param fm      is the fragment manager that will keep each fragment's state in the adapter
     *                across swipes.
     */
    public FragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new DrinkFragment();
        } else if (position == 1) {
            return new SeeFragment();
        } else if (position == 2) {
            return new RelaxFragment();
        } else {
            return new EatFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_drink);
        } else if (position == 1) {
            return mContext.getString(R.string.category_see);
        } else if (position == 2) {
            return mContext.getString(R.string.category_relax);
        } else {
            return mContext.getString(R.string.category_eat);
        }
    }
}
