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
 * Created by Eric on 24/08/2017.
 */

public class fragment_match_info extends Fragment {
    private View view;
    private NestedScrollView nestedScrollView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_match_info, container, false);
       // getActivity().setTitle("Match Information");
        nestedScrollView=(NestedScrollView)view.findViewById(R.id.nested_scrollView);
        nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY > oldScrollY) {
                  //  hideViews();
                } else {
                    showViews();
                }
            }
        });
        return view;
    }

    private void hideViews() {
        try {
            if (getActivity().getActionBar().isShowing()) {
                getActivity().getActionBar().hide();
            }
        }catch (NullPointerException n){

        }
    }
    private void showViews() {
        try {
            getActivity().getActionBar().show();
        }
        catch (NullPointerException n){

        }
    }
}
