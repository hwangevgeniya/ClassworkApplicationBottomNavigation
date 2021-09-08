package com.geektech.classworkapplicationbottomnavigation.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.geektech.classworkapplicationbottomnavigation.R;
import com.geektech.classworkapplicationbottomnavigation.databinding.ActivityMainBinding;
import com.geektech.classworkapplicationbottomnavigation.ui.fragments.characters.CharacterFragment;
import com.geektech.classworkapplicationbottomnavigation.ui.fragments.info.InfoFragment;
import com.geektech.classworkapplicationbottomnavigation.ui.fragments.location.LocationFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        initBottomNav();

    }

    private void initBottomNav() {
        getSupportFragmentManager().beginTransaction().replace(R.id.flMainFrame, new CharacterFragment()).commit();
        binding.BottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.character:
                        binding.tvTitleToolbar.setText("Character");
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.flMainFrame, new CharacterFragment()).commit();
                        break;
                    case R.id.location:
                        binding.tvTitleToolbar.setText("Location");
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.flMainFrame, new LocationFragment()).commit();
                        break;
                    case R.id.info:
                        binding.tvTitleToolbar.setText("Info");
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.flMainFrame, new InfoFragment()).commit();
                        break;
                }
                return true;
            }
        });
    }

            }
