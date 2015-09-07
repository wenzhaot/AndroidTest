package com.wenzhaot.tabdemo;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by tanwenzhao on 9/7/15.
 */
public class BaseFragmentActivity extends FragmentActivity {

    private ActionBar actionBar;
    private ActionBar.LayoutParams layoutParams;
    private ViewGroup viewGroup;

    private TextView textView;
    private Button leftButton;
    private Button rightButton;

    private boolean isLeftBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupActionBar();
    }

    private void setupActionBar() {
        actionBar = getActionBar();
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowCustomEnabled(true);

        layoutParams = new ActionBar.LayoutParams(ActionBar.LayoutParams.FILL_PARENT, ActionBar.LayoutParams.FILL_PARENT);
        viewGroup = (ViewGroup)getLayoutInflater().inflate(R.layout.action_bar, null);
        actionBar.setCustomView(viewGroup, layoutParams);

        textView = (TextView)viewGroup.findViewById(R.id.title);
        leftButton = (Button)viewGroup.findViewById(R.id.left_button);
        rightButton = (Button)viewGroup.findViewById(R.id.right_button);

    }

    public void setTitle(String title) {
        textView.setVisibility(View.VISIBLE);
        textView.setText(title);
    }

    public void setDefaultBackButton() {
        isLeftBack = true;
        setLeftButtonIcon(R.mipmap.tab_icon_home_nor);
    }

    public void setLeftButtonIcon(int resid) {
        leftButton.setVisibility(View.VISIBLE);
        leftButton.setBackgroundResource(resid);
    }

    public void setRightButtonIcon(int resid) {
        rightButton.setVisibility(View.VISIBLE);
        rightButton.setBackgroundResource(resid);
    }

    public void leftButtonClicked(View v) {
        if (isLeftBack) {
            this.finish();
        }
    }

    public void rightButtonClicked(View v) {

    }


}
