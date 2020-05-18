package com.appshat.healthadvisor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    ViewPager pager;
    TabLayout mTabLayout;
    TabItem nbabyItem,chItem,tikItem,nbhItem,helpItem,rqnItem;
    PagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        Toolbar toolbar = findViewById( R.id.toolbar_id );
        setSupportActionBar( toolbar );

        pager = findViewById( R.id.viewpager_id );
        mTabLayout = findViewById( R.id.tab_layout_id );
        nbabyItem = findViewById( R.id.item1_id );
        chItem = findViewById( R.id.item2_id );
        tikItem = findViewById( R.id.item3_id );
        helpItem = findViewById( R.id.item4_id );
        nbhItem = findViewById( R.id.item5_id );
        rqnItem = findViewById( R.id.item6_id );

        drawerLayout = findViewById( R.id.drawer);
        navigationView = findViewById( R.id.nav_view_id );
        navigationView.setNavigationItemSelectedListener( this );
        toggle = new ActionBarDrawerToggle( this,drawerLayout,toolbar,R.string.open,R.string.close );
        drawerLayout.addDrawerListener( toggle );
        toggle.setDrawerIndicatorEnabled( true );
        toggle.syncState();

        // load pager adapter
        adapter = new PagerAdapter( getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, mTabLayout.getTabCount() );
        pager.setAdapter( adapter );
        //Click on tab item
        mTabLayout.addOnTabSelectedListener( new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem( tab.getPosition() );
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        } );
        pager.addOnPageChangeListener( new TabLayout.TabLayoutOnPageChangeListener( mTabLayout ) );
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.nav_newbornbaby:
                pager.setCurrentItem( 0 );
                break;
            case R.id.nav_children:
                pager.setCurrentItem( 1 );
                break;

            case R.id.nav_tika:
                pager.setCurrentItem( 2 );
                break;
            case R.id.nav_helpline:
                pager.setCurrentItem( 3 );
                break;
            case R.id.nav_hospital:
                pager.setCurrentItem( 4 );
                break;
            case R.id.nav_nutrition:
                pager.setCurrentItem( 5 );
                break;
            case  R.id.nav_aboutus:
                Toast.makeText(this, "About Us", Toast.LENGTH_SHORT).show();
                break;
            case  R.id.nav_location:
                Toast.makeText(this, "Meet Us", Toast.LENGTH_SHORT).show();
                break;
            case  R.id.nav_share:
                Toast.makeText(this, "Share With", Toast.LENGTH_SHORT).show();
                break;

        }
        drawerLayout.closeDrawer( GravityCompat.START );
        return false;
    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen( GravityCompat.START ) || pager.getCurrentItem()!=0){
            drawerLayout.closeDrawer( GravityCompat.START );
            pager.setCurrentItem( 0 );
        }else {
            super.onBackPressed();
        }
    }
}
