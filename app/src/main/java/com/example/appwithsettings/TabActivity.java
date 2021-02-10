package com.example.appwithsettings;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class TabActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private Account mAccount;
    private Favourite mFavourite;
    private Store mStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        mToolbar = findViewById(R.id.tabtoolbar);
        setSupportActionBar(mToolbar);

        mViewPager = findViewById(R.id.view_pager);
        mTabLayout = findViewById(R.id.tab_layout);

        mAccount = new Account();
        mFavourite = new Favourite();
        mStore = new Store();

        mTabLayout.setupWithViewPager(mViewPager);


        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), 0);
       viewPagerAdapter.addFragment(mAccount, "Account");
       viewPagerAdapter.addFragment(mFavourite,"Favourite");
       viewPagerAdapter.addFragment(mStore,"Store");

        mViewPager.setAdapter(viewPagerAdapter);

        //Add icons dynamically
        mTabLayout.getTabAt(0).setIcon(R.drawable.droid);
        mTabLayout.getTabAt(1).setIcon(R.drawable.ic_message);
        mTabLayout.getTabAt(2).setIcon(R.drawable.ic_chat);

        BadgeDrawable mBadgeDrawable = mTabLayout.getTabAt(0).getOrCreateBadge();
        mBadgeDrawable.setVisible(true);
        mBadgeDrawable.setNumber(10);

    }




    private class ViewPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> mFragments = new ArrayList<>();
        private List<String> fragmentTitles = new ArrayList<>();


        public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        //Add Fragment Method
        public void addFragment(Fragment fragment, String title){

            mFragments.add(fragment);
            fragmentTitles.add(title);

        }



        @NonNull
        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }


        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitles.get(position);
        }
    }
}