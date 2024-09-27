package vn.edu.usth.usthweather;

import android.content.pm.PackageManager;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import vn.edu.usth.usthweather.databinding.ActivityWeatherAcitvityBinding;
import vn.edu.usth.usthweather.home.HomeAdapter;

public class WeatherActitvity extends AppCompatActivity {
    MediaPlayer mediaPlayer;

    private ActivityWeatherAcitvityBinding binding;
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    HomeAdapter homeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mediaPlayer= MediaPlayer.create(this, R.raw.weather);
        mediaPlayer.start();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_acitvity);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager2 = findViewById(R.id.view_pager);
        homeAdapter = new HomeAdapter(this);
        viewPager2.setAdapter(homeAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.getTabAt(position).select();
            }
        });

    }

}




//        binding = ActivityWeatherAcitvityBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//
//        BottomNavigationView navView = findViewById(R.id.nav_view);
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
//                .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_weather_acitvity);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        NavigationUI.setupWithNavController(binding.navView, navController);

        // Create a new Fragment to be placed in the activity l
//        ForecastFragment forecastFragment = new ForecastFragment();
//        WeatherFragment weatherFragment = new WeatherFragment();
        // Add the fragment to the 'container' FrameLayout

//         Add the second fragment to the 'container' FrameLayout
//        getSupportFragmentManager().beginTransaction()
//                .add(R.id.container_weather, weatherFragment).commit();
//        getSupportFragmentManager().beginTransaction().add(
//                R.id.container_forecast, forecastFragment).commit();




//    public WeatherActitvity() {
//        super();
//    }



//    @Override
//    protected void onStart() {
//        super.onStart();
//        Log.i("Weather","Start here");
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        super.onStart();
//        Log.i("Weather","Stop here");
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Log.i("Weather","Destroy here");
//    }

