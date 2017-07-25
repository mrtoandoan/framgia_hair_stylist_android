package com.framgia.fsalon.utils.binding;

import android.databinding.BindingAdapter;
import android.databinding.InverseBindingAdapter;
import android.databinding.InverseBindingListener;
import android.support.design.widget.TextInputLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.framgia.fsalon.R;
import com.framgia.fsalon.data.model.Stylist;
import com.framgia.fsalon.screen.booking.BookingViewModel;
import com.framgia.fsalon.screen.home.ImagePagerAdapter;
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
    public static void setPagerAdapter(ViewPager viewPager, ImagePagerAdapter adapter) {
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

    @BindingAdapter({"resourceId"})
    public static void setResourceId(LinearLayout layout, int resId) {
        layout.setBackgroundResource(resId);
    }

    @InverseBindingAdapter(attribute = "stylistId", event = "stylistIdAttrChanged")
    public static int captureStylistId(SearchableSpinner view) {
        Object selectedItem = view.getSelectedItem();
        return ((Stylist) selectedItem).getId();
    }

    @BindingAdapter(value = {"viewModel", "stylistId", "stylistIdAttrChanged"}, requireAll = false)
    public static void setCategoryId(SearchableSpinner view, final BookingViewModel viewModel,
                                     int value, final InverseBindingListener bindingListener) {
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                bindingListener.onChange();
                // TODO: 25/07/2017  viewModel.getData();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        view.setOnItemSelectedListener(listener);
    }
}
