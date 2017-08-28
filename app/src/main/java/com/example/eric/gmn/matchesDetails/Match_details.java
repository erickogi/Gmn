package com.example.eric.gmn.matchesDetails;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.eric.gmn.R;
import com.example.eric.gmn.fragment_weeks_matches;
import com.example.eric.gmn.matches_pojo;

import java.util.ArrayList;
import java.util.List;

public class Match_details extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FloatingActionButton fab;
    private ArrayList<matches_pojo> matches_pojos;
    private int dataPos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_details);
        Intent intent=getIntent();
        matches_pojos=(ArrayList<matches_pojo>) intent.getSerializableExtra("data");
        dataPos=intent.getIntExtra("datapos", 0);


      //  setTitle(matches_pojos.get(dataPos).getMatch_team1_home()+" VS "+matches_pojos.get(dataPos).getMatch_team2_away());
        setTitle("Test Teams : Manchester United vs Arsenal");

        overridePendingTransition(R.anim.trans_left_in,R.anim.trans_left_out);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        try {
            getActionBar().hide();
        }catch (NullPointerException n){

        }
        fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Play.class);


                intent.putExtra("data",matches_pojos);
                startActivity(intent);
               // startActivity(new Intent(Match_details.this,Play.class));
            }
        });



        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
    }
    @Override
    public  void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.trans_right_in,R.anim.trans_right_out);
    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new fragment_match_info(), "lo");
        adapter.addFragment(new fragment_stats(), "l");
        adapter.addFragment(new fragment_bet(), "o");

        viewPager.setOffscreenPageLimit(0);
        viewPager.setAdapter(adapter);
    }
    private void setupTabIcons() {

        tabLayout.getTabAt(0).setText("Info");
        tabLayout.getTabAt(1).setText("Stats");
        tabLayout.getTabAt(2).setText("Bet");



    }
    private class ViewPagerAdapter extends FragmentPagerAdapter {
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
            return null;
        }
    }

}
