package com.example.rexx.event_proj;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rexx.event_proj.R;

public class slideAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    private int[] slide_images = {
            R.drawable.dance,
            R.drawable.marathon,
            R.drawable.digital,
            R.drawable.dramatics,
            R.drawable.games,
            R.drawable.intracollege,
            R.drawable.fashion,
            R.drawable.books,
            R.drawable.management,
            R.drawable.miscellaneous,
            R.drawable.music,
            R.drawable.techie
    };

    private Class[] slide_activity = {
            Dance.class,
            Marathon.class,
            DesignDigitalArt.class,
            Dramatics.class,
            Gaming.class,
            Intracollege.class,
            LifeStyle.class,
            Literary.class,
            Management.class,
            Miscellaneous.class,
            Music.class,
            Technical.class,
    };


    public String[] slide_headings = {
            "DANCE",
            "MARATHON",
            "DESIGN AND DIGITAL ARTS",
            "DRAMATICS",
            "GAMING",
            "INTRACOLLEGE",
            "LIFESTYLE",
            "LITERARY",
            "MANAGEMENT",
            "MISCELLANEOUS",
            "MUSIC",
            "TECHNICAL"
    };

    public String[] slide_desc = {
            "Dance is more than the exploring of different ways to make a shape or learning a series of steps to music.",
            "Running engages your midsection,improves posture, strengthens limbs, and helps make everyday activities a breeze.",
            "An artistic work or practice that uses digital technology as an essential part of the creative or presentation process.",
            "is an important means of stimulating creativity in problem solving. It challenges the perception about the world.",
            "Gaming can actually improve your cognitive abilities. This promotes adaptability and cognitive flexibility.",
            "Competition provides motivation to achieve a goal; to demonstrate determination and perseverance to overcome challenges.",
            "Fashion is a constant presence in a person's life. It is used for self expression and boost confidence.",
            "Literature creates a way for people to record their thoughts and experiences in a way that is accessible to others.",
            "It arranges the factors of production, assembles and organizes the resources to achieve a goal.",
            "Tasks and competions that seperates child from an adult.",
            "It helps to be relaxed and plays a huge role in changing mood.",
            "Technology can help solve realtime problems of humans."
    };


    public slideAdapter(Context context) {
        this.context = context;
    }


    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

//        ImageView tempImageView;
//
//        for (int i : slide_images) {
//            tempImageView = view.findViewById(i);
//            //tempImageView.setOnClickListener(this);
//        }



        TextView slideTextView = view.findViewById(R.id.slide_image);
        TextView slideHeading = view.findViewById(R.id.slide_heading);
        TextView slideDescription = view.findViewById(R.id.slide_desc);

        slideTextView.setBackground(context.getResources().getDrawable(slide_images[position]));
        slideTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0;i< slide_images.length;i++){
                    if (i == position){
                        Class c = slide_activity[position];
                        Intent intent = new Intent(context,c);
                        context.startActivity(intent);
                    }
                }
            }
        });
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_desc[position]);

        container.addView(view);

        slideHeading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout) object);
    }

}
