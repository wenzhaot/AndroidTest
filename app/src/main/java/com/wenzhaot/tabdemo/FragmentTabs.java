package com.wenzhaot.tabdemo;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.TabHost.TabSpec;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class FragmentTabs extends FragmentActivity {

    private FragmentTabHost mTabHost;
    private LayoutInflater layoutInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_tabs);

        initView();
    }

    private void initView(){
        layoutInflater = LayoutInflater.from(this);

        mTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        mTabHost.getTabWidget().setDividerDrawable(R.color.tab_background);

        addTabSpec(R.layout.tab_item_view, "home", "首页", R.drawable.tab_home_btn, HomeContainerFragment.class);
        addTabSpec(R.layout.tab_item_center_view, "Test", null, R.drawable.tab_home_btn, null);
        addTabSpec(R.layout.tab_item_view, "msg", "消息", R.drawable.tab_home_btn, HomeContainerFragment.class);

        mTabHost.getTabWidget().getChildTabViewAt(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("test", "click");
            }
        });
    }

    private void  addTabSpec(int indicator, String tag, String text, int icon, Class<?> clss) {
        View view = layoutInflater.inflate(indicator, null);

        ImageView imageView = (ImageView) view.findViewById(R.id.icon);
        imageView.setImageResource(icon);

        TextView textView = (TextView) view.findViewById(R.id.text);
        if (textView != null) {
            textView.setText(text);
        }

        TabSpec tabSpec = mTabHost.newTabSpec(tag).setIndicator(view);
        mTabHost.addTab(tabSpec, clss, null);
    }
}
