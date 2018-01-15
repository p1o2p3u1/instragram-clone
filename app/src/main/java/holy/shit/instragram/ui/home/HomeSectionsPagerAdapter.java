package holy.shit.instragram.ui.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeSectionsPagerAdapter extends FragmentPagerAdapter {

    private static final String TAG = "HomeSectionsPagerAdapter";

    private List<Fragment> fragments;

    public HomeSectionsPagerAdapter(FragmentManager fm) {
        super(fm);
        fragments = new ArrayList<>();
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    public void addFragment(Fragment fragment){
        this.fragments.add(fragment);
    }
}
