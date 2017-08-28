package com.example.eric.gmn.matchesDetails;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.eric.gmn.R;

/**
 * Created by Eric on 27/08/2017.
 */

public class fragment_stats extends Fragment {
    private View view;
    private NestedScrollView nestedScrollView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_stats, container, false);
        //getActivity().setTitle("Statistics");
        nestedScrollView=(NestedScrollView)view.findViewById(R.id.nested_scrollView);
        nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY > oldScrollY) {
                   // hideViews();
                } else {
                  //  showViews();
                }
            }
        });
        return view;
    }
}
