package com.wenzhaot.tabdemo;


import android.os.Bundle;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.v4.view.ViewPager;

import com.shizhefei.view.indicator.FragmentListPageAdapter;
import com.shizhefei.view.indicator.IndicatorViewPager;
import com.shizhefei.view.indicator.slidebar.ColorBar;
import com.shizhefei.view.indicator.ScrollIndicatorView;
import com.shizhefei.view.indicator.IndicatorViewPager.IndicatorFragmentPagerAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends Fragment {

    private ScrollIndicatorView indicator;
    private IndicatorViewPager indicatorViewPager;
    private LayoutInflater inflate;
    private String[] names = { "CUPCAKE", "DONUT", "FROYO", "GINGERBREAD"};


    public SettingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_setting, container, false);

        ViewPager viewPager = (ViewPager)view.findViewById(R.id.moretab_viewPager);
        indicator = (ScrollIndicatorView)view.findViewById(R.id.moretab_indicator);
        indicator.setScrollBar(new ColorBar(getActivity(), Color.RED, 5));

        viewPager.setOffscreenPageLimit(2);
        indicatorViewPager = new IndicatorViewPager(indicator, viewPager);
        inflate = LayoutInflater.from(getActivity().getApplicationContext());
        indicatorViewPager.setAdapter(new MyAdapter(getActivity().getSupportFragmentManager()));

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        BaseFragmentActivity activity = (BaseFragmentActivity)getActivity();
        activity.setTitle("Setting");
    }



    private int size = 2;

    private class MyAdapter extends IndicatorFragmentPagerAdapter {

        public MyAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public int getCount() {
            return size;
        }

        @Override
        public View getViewForTab(int position, View convertView, ViewGroup container) {
            if (convertView == null) {
                convertView = inflate.inflate(R.layout.tab_top, container, false);
            }
            TextView textView = (TextView) convertView;
            textView.setText(names[position % names.length]);
            textView.setPadding(20, 0, 20, 0);
            return convertView;
        }

        @Override
        public Fragment getFragmentForPage(int position) {
            HomeFragment fragment = new HomeFragment();
//            Bundle bundle = new Bundle();
//            bundle.putInt(HomeFragment.INTENT_INT_INDEX, position);
//            fragment.setArguments(bundle);
            return fragment;
        }

        @Override
        public int getItemPosition(Object object) {
            return FragmentListPageAdapter.POSITION_NONE;
        }

    };


}
