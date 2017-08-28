package com.example.eric.gmn;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.eric.gmn.matchesDetails.Play;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Button buttonSort;
    private Dialog dialog;
    private TextView textViewSortBy;
    private String Categories[]={"League","Country","All"};
    private String countries[]={"England","Argentina","France","Spain","Kenya","Brazil","Japan","South Africa","Nigeria","Ghana"};
    private String leagues[]={"Kenya Premier league","Eufa,Shield","Bundesliga","English Football League","Brazil Serie A","La liga"};

    private FloatingActionButton fab;
    ArrayList<matches_pojo> matches_pojos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("This weeks Matches");
        textViewSortBy=(TextView)findViewById(R.id.textViewSortBy);
        textViewSortBy.setText("All");
        buttonSort=(Button)findViewById(R.id.botton_sort);
        buttonSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog=new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.sort_dialog);
                Spinner spinnerCategories=(Spinner)dialog.findViewById(R.id.spinnerSortBy);
                final Spinner spinnerParticulars=(Spinner)dialog.findViewById(R.id.spinnerParticulars);
                //spinnerCategories.
                ArrayAdapter<String> simpleAdapterB=new ArrayAdapter<String>(getApplicationContext(),R.layout.spinner_view,Categories);
                spinnerCategories.setAdapter(simpleAdapterB);

                spinnerCategories.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if(position==0){

                            ArrayAdapter<String> simpleAdapterB=new ArrayAdapter<String>(getApplicationContext(),R.layout.spinner_view,leagues);
                            spinnerParticulars.setAdapter(simpleAdapterB);
                            // textViewSortBy.setText("Sort by legues");
                        }
                        else if(position==1){
                            ArrayAdapter<String> simpleAdapterB=new ArrayAdapter<String>(getApplicationContext(),R.layout.spinner_view,countries);
                            spinnerParticulars.setAdapter(simpleAdapterB);

                        }
                        else {
                            spinnerParticulars.setActivated(false);
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                Button buttonSet=(Button)dialog.findViewById(R.id.btnSet);
                Button buttonDismiss=(Button)dialog.findViewById(R.id.btnDismiss);
                buttonDismiss.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                buttonSet.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        textViewSortBy.setText(spinnerParticulars.getSelectedItem().toString());
                        dialog.dismiss();
                    }
                });

                dialog.show();

            }
        });

        fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Play.class);


                intent.putExtra("data",fragment_weeks_matches.populate());
                startActivity(intent);
                // startActivity(new Intent(Match_details.this,Play.class));
            }
        });
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
       // ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                //this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
      //  drawer.setDrawerListener(toggle);
      //  toggle.syncState();

       // NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
       // navigationView.setNavigationItemSelectedListener(this);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new fragment_weeks_matches(), "lo");
        adapter.addFragment(new fragment_weeks_matches(), "l");
        adapter.addFragment(new fragment_weeks_matches(), "o");
        adapter.addFragment(new fragment_weeks_matches(), "Ilo");
        adapter.addFragment(new fragment_weeks_matches(), "Mlo");
        adapter.addFragment(new fragment_weeks_matches(), "Nlo");
        adapter.addFragment(new fragment_weeks_matches(), "Blo");
        viewPager.setOffscreenPageLimit(1);
        viewPager.setAdapter(adapter);
    }

    private void setupTabIcons() {

        tabLayout.getTabAt(0).setText("Mon");
        tabLayout.getTabAt(1).setText("Tue");
        tabLayout.getTabAt(2).setText("Wed");
        tabLayout.getTabAt(3).setText("Thur");
        tabLayout.getTabAt(4).setText("Fri");
        tabLayout.getTabAt(5).setText("Sat");
        tabLayout.getTabAt(6).setText("Sun");


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
