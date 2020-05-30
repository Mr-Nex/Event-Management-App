package com.example.rexx.event_proj;

import android.annotation.SuppressLint;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ViewPager mslideViewPager;
    private LinearLayout mdotsLayout;
    private slideAdapter SlideAdapter;
    private TextView[] mDots;
    private Button mPrevbtn;
    private Button mNextbtn;
    private int mCurrentPg;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mslideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        mdotsLayout = (LinearLayout) findViewById(R.id.dotsLayout);

        mPrevbtn = (Button) findViewById(R.id.prevbtn);
        mNextbtn = (Button) findViewById(R.id.nxtbtn);

        SlideAdapter = new slideAdapter(this);
        mslideViewPager.setAdapter(SlideAdapter);
        addDotsIndicator(0);
        mslideViewPager.addOnPageChangeListener(viewListener);

        mNextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mslideViewPager.setCurrentItem(mCurrentPg+1);
            }
        });

        mPrevbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mslideViewPager.setCurrentItem(mCurrentPg-1);
            }
        });
    }



    public void addDotsIndicator(int position){
        mDots = new TextView[12];
        mdotsLayout.removeAllViews();

        for(int i=0;i<mDots.length;i++){

            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));
            mdotsLayout.addView(mDots[i]);
        }
        if(mDots.length>0){
            mDots[position].setTextColor(getResources().getColor(R.color.colorPrimary));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);

            mCurrentPg = i;
            if(i == 0){
                mNextbtn.setEnabled(true);
                mPrevbtn.setEnabled(false);
                mPrevbtn.setVisibility(View.INVISIBLE);
                mNextbtn.setText("NEXT");
                mPrevbtn.setText("");

            }
            else if(i == mDots.length-1){
                mNextbtn.setEnabled(true);
                mPrevbtn.setEnabled(true);
                mPrevbtn.setVisibility(View.VISIBLE);
                mNextbtn.setText("FINISH");
                mPrevbtn.setText("PREV");

            }
            else{
                mNextbtn.setEnabled(true);
                mPrevbtn.setEnabled(true);
                mPrevbtn.setVisibility(View.VISIBLE);
                mNextbtn.setText("NEXT");
                mPrevbtn.setText("PREV");

            }

        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };


}
