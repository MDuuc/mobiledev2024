package vn.edu.usth.usthweather;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import vn.edu.usth.usthweather.databinding.ActivityWeatherAcitvityBinding;

public class WeatherActitvity extends AppCompatActivity {

    private ActivityWeatherAcitvityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWeatherAcitvityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_weather_acitvity);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        // Create a new Fragment to be placed in the activity l
        ForecastFragment firstFragment = new ForecastFragment();
        // Add the fragment to the 'container' FrameLayout

        getSupportFragmentManager().beginTransaction().add(
                R.id.main, firstFragment).commit();

    }


    public WeatherActitvity() {
        super();
    }



    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Weather","Start here");
    }

    @Override
    protected void onStop() {
        super.onStop();
        super.onStart();
        Log.i("Weather","Stop here");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Weather","Destroy here");
    }

}