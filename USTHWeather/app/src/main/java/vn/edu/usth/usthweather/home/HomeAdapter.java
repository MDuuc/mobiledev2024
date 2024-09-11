package vn.edu.usth.usthweather.home;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import vn.edu.usth.usthweather.ui.home.HomeFragment;

public class HomeAdapter extends FragmentStateAdapter{


    public HomeAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new UsthWeather();
            case 1:
                return new HanoiWeather();
            case 2:
                return new SonlaWeather();
            default:
                return new UsthWeather();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }

}
