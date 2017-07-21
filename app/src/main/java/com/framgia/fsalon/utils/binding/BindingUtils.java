package com.framgia.fsalon.utils.binding;

import android.databinding.BindingAdapter;
import android.support.design.widget.TextInputLayout;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import com.framgia.fsalon.screen.home.ImagePagerAdapter;
import com.framgia.fsalon.screen.image.ImageFragment;

import java.util.List;

/**
 * Created by MyPC on 20/07/2017.
 */
public class BindingUtils {
    @BindingAdapter("errorText")
    public static void setErrorText(TextInputLayout layout, String text) {
        layout.setError(text);
    }

    @BindingAdapter("bind:pagerAdapter")
    public static void setPagerAdapter(ViewPager viewPager, ImagePagerAdapter adapter){
        viewPager.setAdapter(adapter);
    }
    @BindingAdapter("android:src")
    public static void setImage(ImageView view, int src){
        view.setImageResource(src);
    }
}
