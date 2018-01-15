package holy.shit.instragram.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import holy.shit.instragram.R;
import holy.shit.instragram.ui.home.HomeFragment;
import holy.shit.instragram.ui.like.LikeFragment;
import holy.shit.instragram.ui.profile.ProfileFragment;
import holy.shit.instragram.ui.search.SearchFragment;
import holy.shit.instragram.ui.share.ShareFragment;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ViewPager viewPager;

    private BottomNavigationViewEx bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        renderView();
    }

    private void renderView(){
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter pagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(new HomeFragment());
        pagerAdapter.addFragment(new SearchFragment());
        pagerAdapter.addFragment(new ShareFragment());
        pagerAdapter.addFragment(new LikeFragment());
        pagerAdapter.addFragment(new ProfileFragment());
        viewPager = findViewById(R.id.fragments_viewpager);
        bottomNavigationView = findViewById(R.id.bottomNavViewBar);
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        bottomNavigationView.enableAnimation(false);
        bottomNavigationView.enableShiftingMode(false);
        bottomNavigationView.enableItemShiftingMode(false);
        bottomNavigationView.setTextVisibility(false);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_home:
                        viewPager.setCurrentItem(0);
                        return true;
                    case R.id.navigation_search:
                        viewPager.setCurrentItem(1);
                        return true;
                    case R.id.navigation_share:
                        viewPager.setCurrentItem(2);
                        return true;
                    case R.id.navigation_like:
                        viewPager.setCurrentItem(3);
                        return true;
                    case R.id.navigation_profile:
                        viewPager.setCurrentItem(4);
                        return true;
                }
                return false;
            }
        });
    }

}
