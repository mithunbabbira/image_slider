package com.example.auto_image_slide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class CustomSwipeAdapter  extends PagerAdapter {
    private int[] image_resources = {R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four,R.drawable.five};

    private Context ctx;

    private LayoutInflater layoutInflater;


    public CustomSwipeAdapter(Context ctx){
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return image_resources.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view==(LinearLayout)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


            View item_view = layoutInflater.inflate(R.layout.swipe_layout,container,false);

            ImageView imageView =item_view.findViewById(R.id.image_view);
            TextView textView = item_view.findViewById(R.id.image_count);

            imageView.setImageResource(image_resources[position]);

            position = position+1;

            textView.setText("image :"+position);

            container.addView(item_view);



        return item_view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
