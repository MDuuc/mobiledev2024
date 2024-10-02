package vn.edu.usth.usthweather;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import vn.edu.usth.usthweather.databinding.ActivityWeatherAcitvityBinding;
import vn.edu.usth.usthweather.home.HomeAdapter;

public class WeatherActitvity extends AppCompatActivity {
    private ActivityWeatherAcitvityBinding binding;
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    HomeAdapter homeAdapter;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_acitvity);

        // Initialize handler in the main thread
        handler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {
                // Handle the message from worker thread
                String content = msg.getData().getString("weather_data");
                Toast.makeText(WeatherActitvity.this, content, Toast.LENGTH_SHORT).show();
            }
        };

        // Play music
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.weather);
        mediaPlayer.start();

        // Add toolbar
        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        // Set up refresh button with thread handling
        ImageView refreshButton = toolbar.findViewById(R.id.refreshButton);
        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(WeatherActitvity.this, "Starting refresh...", Toast.LENGTH_SHORT).show();
                performRefresh();
            }
        });

        // Tab Layout setup
        setupTabs();
    }

    private void performRefresh() {
        Thread refreshThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // Simulate network delay
                    Thread.sleep(2000);

                    // Simulate getting weather data
                    Bundle weatherData = new Bundle();
                    weatherData.putString("weather_data", "Weather data refreshed successfully!");

                    // Send message back to main thread
                    Message message = new Message();
                    message.setData(weatherData);
                    handler.sendMessage(message);

                } catch (InterruptedException e) {
                    e.printStackTrace();

                    // Send error message if refresh fails
                    Bundle errorData = new Bundle();
                    errorData.putString("weather_data", "Failed to refresh weather data");
                    Message errorMessage = new Message();
                    errorMessage.setData(errorData);
                    handler.sendMessage(errorMessage);
                }
            }
        });

        refreshThread.start();
    }

    private void setupTabs() {
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
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.getTabAt(position).select();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bottom_nav_menu, menu);
        return true;
    }
}





