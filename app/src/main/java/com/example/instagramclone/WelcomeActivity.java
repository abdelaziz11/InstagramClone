package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.tabs.TabLayout;


public class WelcomeActivity extends AppCompatActivity {

private Toolbar toolbar;
private ViewPager viewPager;
private TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_activity);
        toolbar=(Toolbar)findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);



        viewPager=(ViewPager)findViewById(R.id.view_pager);
        addTabs(viewPager);


        tabLayout=(TabLayout)findViewById(R.id.tabLayout);
         tabLayout.setupWithViewPager(viewPager,false);




    }
    private void addTabs(ViewPager viewPager) {
        TabAdapter adapter=new TabAdapter(getSupportFragmentManager());
        adapter.addFrag(new ProfileTap(), "Profile");
        adapter.addFrag(new UsersTap(), "User");
        adapter.addFrag(new SharePictureTap(), "Share Picture");
        viewPager.setAdapter(adapter);
    }


}
