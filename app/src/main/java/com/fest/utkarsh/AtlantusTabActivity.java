package com.fest.utkarsh;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.fest.utkarsh.fragments.atlantus.ChromeRun;
import com.fest.utkarsh.fragments.atlantus.Cs;
import com.fest.utkarsh.fragments.atlantus.Dota;
import com.fest.utkarsh.fragments.atlantus.Fifa;
import com.fest.utkarsh.fragments.atlantus.MarioMod;
import com.fest.utkarsh.fragments.atlantus.Tekken;

import java.util.ArrayList;
import java.util.List;

public class AtlantusTabActivity extends AppCompatActivity {

    private TabLayout tabLayout_atlantus;
    private ViewPager viewPager_atlantus;
    private Toolbar toolbar_atlantus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atlantus_tab);
        toolbar_atlantus = (Toolbar) findViewById(R.id.toolbar_atlantus);
        setSupportActionBar(toolbar_atlantus);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager_atlantus = (ViewPager) findViewById(R.id.viewpager_atlantus);
        setupViewPager(viewPager_atlantus);

        tabLayout_atlantus = (TabLayout) findViewById(R.id.tabs_atlantus);
        tabLayout_atlantus.setupWithViewPager(viewPager_atlantus);
    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ChromeRun(), "Chrome Run");
        adapter.addFragment(new Cs(), "Counter Strike");
        adapter.addFragment(new Dota(), "DOTA");
        adapter.addFragment(new Fifa(), "FIFA");
        adapter.addFragment(new MarioMod(), "Mario Mod");
        adapter.addFragment(new Tekken(), "Tekken");
        viewPager.setAdapter(adapter);
    }
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
    public void onBackPressed() {
        super.onBackPressed();
    }
    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        // or call onBackPressed()
        return true;
    }
}
