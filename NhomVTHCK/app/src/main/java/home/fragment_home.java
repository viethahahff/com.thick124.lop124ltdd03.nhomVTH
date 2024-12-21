package home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.nhomvthck.R;
import com.google.android.material.tabs.TabLayout;

public class fragment_home extends Fragment {

    private TabLayout tablayout;
    private ViewPager viewpager;
    private View mView;

    public fragment_home() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_home, container, false);

        tablayout = mView.findViewById(R.id.tablayout);
        viewpager = mView.findViewById(R.id.oder_viewpager);

        HomeViewPagerAdapter adapter = new HomeViewPagerAdapter(getChildFragmentManager());
        viewpager.setAdapter(adapter);

        tablayout.setupWithViewPager(viewpager);



        return mView;
    }
}
