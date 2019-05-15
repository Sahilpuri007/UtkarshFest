package com.fest.utkarsh.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.fest.utkarsh.R;
import com.fest.utkarsh.fragment.cultural.Asthetica;
import com.fest.utkarsh.fragment.cultural.DanceOff;
import com.fest.utkarsh.fragment.cultural.Dharohar;
import com.fest.utkarsh.fragment.cultural.Dramaturgy;
import com.fest.utkarsh.fragment.cultural.DrawingPainting;
import com.fest.utkarsh.fragment.cultural.Footloose;
import com.fest.utkarsh.fragment.cultural.Rampage;
import com.fest.utkarsh.fragment.cultural.Saaz;

import java.util.ArrayList;
import java.util.List;

public class CulturalTabActivity extends AppCompatActivity {

    private TabLayout tabLayout_cultural;
    private ViewPager viewPager_cultural;
    private Toolbar toolbar_cultural;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cultural_tab);
        toolbar_cultural = (Toolbar) findViewById(R.id.toolbar_cultural);
        setSupportActionBar(toolbar_cultural);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager_cultural = (ViewPager) findViewById(R.id.viewpager_cultural);
        setupViewPager(viewPager_cultural);

        tabLayout_cultural = (TabLayout) findViewById(R.id.tabs_cultural);
        tabLayout_cultural.setupWithViewPager(viewPager_cultural);
    }
    private void setupViewPager(ViewPager viewPager) {
        CulturalTabActivity.ViewPagerAdapter adapter = new CulturalTabActivity.ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Asthetica(), "Asthetica");
        adapter.addFragment(new DanceOff(), "Dance Off");
        adapter.addFragment(new Dharohar(), "Dharohar");
        adapter.addFragment(new Dramaturgy(), "Dramaturgy");
        adapter.addFragment(new DrawingPainting(), "Drawing/Painting");
        adapter.addFragment(new Footloose(), "Foot Loose");
        adapter.addFragment(new Rampage(), "Rampage");
        adapter.addFragment(new Saaz(), "Saaz");
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
