package challenge.cabonline.com.movie.ui;

import android.arch.lifecycle.LifecycleActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.widget.Toolbar;

import challenge.cabonline.com.movie.R;


public class MainActivity extends LifecycleActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            MovieListFragment fragment = new MovieListFragment();


            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setActionBar(toolbar);

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
            ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

            FragmentManager fm = getSupportFragmentManager();
            MoviePagerAdapter pageAdapter = new MoviePagerAdapter(fm);

            viewPager.setAdapter(pageAdapter);

            // Give the TabLayout the ViewPager

            tabLayout.setupWithViewPager(viewPager);
            tabLayout.setTabMode(TabLayout.MODE_FIXED);
        }
    }

}