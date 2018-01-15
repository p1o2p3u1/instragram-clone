package holy.shit.instragram.ui.home;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import holy.shit.instragram.R;

public class HomeFragment extends Fragment {

    private static final String TAG = "HomeFragment";

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if(view != null) return view;
        view = inflater.inflate(R.layout.fragment_home, container, false);
        HomeSectionsPagerAdapter adapter = new HomeSectionsPagerAdapter(getFragmentManager());
        adapter.addFragment(new CameraFragment());
        adapter.addFragment(new ContentFragmet());
        adapter.addFragment(new MessageFragment());
        ViewPager viewPager = view.findViewById(R.id.home_fragments_viewpager);
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_camera);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_instragram);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_arrow);

        return view;
    }
}
