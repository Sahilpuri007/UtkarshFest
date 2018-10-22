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
import com.fest.utkarsh.fragments.dexteria.Aperture;
import com.fest.utkarsh.fragments.dexteria.DesignX;
import com.fest.utkarsh.fragments.dexteria.GoogleHunt;
import com.fest.utkarsh.fragments.dexteria.Problematic;
import com.fest.utkarsh.fragments.dexteria.Quibble;
import com.fest.utkarsh.fragments.dexteria.WebWeaver;
import com.fest.utkarsh.fragments.dexteria.WinShoot;

import java.util.ArrayList;
import java.util.List;

public class DexteriaTabActivity extends AppCompatActivity {

    private TabLayout tabLayout_dexteria;
    private ViewPager viewPager_dexteria;
    private Toolbar toolbar_dexteria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dexteria_tab);
        toolbar_dexteria = (Toolbar) findViewById(R.id.toolbar_dexteria);
        setSupportActionBar(toolbar_dexteria);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager_dexteria = (ViewPager) findViewById(R.id.viewpager_dexteria);
        setupViewPager(viewPager_dexteria);

        tabLayout_dexteria = (TabLayout) findViewById(R.id.tabs_dexteria);
        tabLayout_dexteria.setupWithViewPager(viewPager_dexteria);
    }
    private void setupViewPager(ViewPager viewPager) {
        DexteriaTabActivity.ViewPagerAdapter adapter = new DexteriaTabActivity.ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Aperture(), "Aperture");
        adapter.addFragment(new DesignX(), "DesignX");
        adapter.addFragment(new GoogleHunt(), "Google Hunt");
        adapter.addFragment(new Problematic(), "Problematic");
        adapter.addFragment(new Quibble(), "Quibble");
        adapter.addFragment(new WebWeaver(), "Web Weaver");
        adapter.addFragment(new WinShoot(), "Win Shoot");
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
        return true;
    }
}
