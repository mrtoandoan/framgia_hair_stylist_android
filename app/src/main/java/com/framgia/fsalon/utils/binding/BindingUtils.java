package com.framgia.fsalon.utils.binding;

import android.databinding.BindingAdapter;
import android.support.design.widget.TextInputLayout;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import com.framgia.fsalon.screen.home.ImagePagerAdapter;
import com.framgia.fsalon.screen.image.ImageFragment;

import java.util.List;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;

import com.framgia.fsalon.R;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

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
    public static void setImage(ImageView view, int src) {
        view.setImageResource(src);
    }

    @BindingAdapter({"recyclerAdapter"})
    public static void setAdapterForRecyclerView(RecyclerView recyclerView,
                                                 RecyclerView.Adapter adapter) {
        recyclerView.setAdapter(adapter);
    }

    @BindingAdapter({"searchableSpinnerAdapter"})
    public static void setSearchableSpinnerAdapter(SearchableSpinner view, ArrayAdapter adapter) {
        view.setAdapter(adapter);
        view.setTitle(view.getContext().getResources().getString(R.string.title_stylist));
        view.setPositiveButton(view.getContext().getResources().getString(R.string.action_close));
    }
}
