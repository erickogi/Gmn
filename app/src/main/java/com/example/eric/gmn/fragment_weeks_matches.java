package com.example.eric.gmn;


import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.eric.gmn.matchesDetails.Match_details;
import com.example.eric.gmn.utills.RecyclerTouchListener;

import java.util.ArrayList;

/**
 * Created by Eric on 22/08/2017.
 */

public class fragment_weeks_matches extends Fragment {
    private  View view;
    private RecyclerView recyclerView;
    private StaggeredGridLayoutManager mStaggeredLayoutManager;
    static RecyclerView.LayoutManager mLayoutManager;
    private static ArrayList<matches_pojo> matches_pojos;
    private matches_fixtures_adapter matches_fixtures_adapter;
    private Button buttonSort;
    private Dialog dialog;
    private TextView textViewSortBy;
    private String Categories[]={"League","Country","All"};
    private String countries[]={"England","Argentina","France","Spain","Kenya","Brazil","Japan","South Africa","Nigeria","Ghana"};
    private String leagues[]={"Kenya Premier league","Eufa,Shield","Bundesliga","English Football League","Brazil Serie A","La liga"};


    public static ArrayList<matches_pojo> populate(){
        matches_pojos=new ArrayList<>();
        matches_pojo matches_pojo1=new matches_pojo(1,"07:10","23/08/2017","Manchester United","Arsenal");
        matches_pojo matches_pojo2=new matches_pojo(1,"08:30","23/08/2017","Barcelona","Real Madrid");
        matches_pojo matches_pojo3=new matches_pojo(1,"09:00","23/08/2017","Leicester City","Borussia Dortmud");
        matches_pojo matches_pojo4=new matches_pojo(1,"10:20","23/08/2017","Crystal  Palace","Swansea City");
        matches_pojo matches_pojo5=new matches_pojo(1,"11:00","23/08/2017","Newcastle","West Ham");
        matches_pojo matches_pojo6=new matches_pojo(1,"07:30","23/09/2017","Waltford Fc","Atletico Madrid");
        matches_pojo matches_pojo7=new matches_pojo(1,"07:40","23/09/2017","Cardiff City"," Queens Park Rangers");
        matches_pojo matches_pojo8=new matches_pojo(1,"09:00","23/09/2017","Chelsea ","Everton FC");
        matches_pojo matches_pojo9=new matches_pojo(1,"06:450","23/09/2017","AC Milan","Cagliar FC");
        matches_pojo matches_pojo10=new matches_pojo(1,"07:00","23/09/2017","Real Madrid","Valencia");

        matches_pojos.add(matches_pojo1);
        matches_pojos.add(matches_pojo2);
        matches_pojos.add(matches_pojo3);
        matches_pojos.add(matches_pojo4);
        matches_pojos.add(matches_pojo5);
        matches_pojos.add(matches_pojo6);
        matches_pojos.add(matches_pojo7);
        matches_pojos.add(matches_pojo8);
        matches_pojos.add(matches_pojo9);
        matches_pojos.add(matches_pojo10);

        return matches_pojos;
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_weeks_matches, container, false);
//        textViewSortBy=(TextView)view.findViewById(R.id.textViewSortBy);
//        textViewSortBy.setText("All");
        recyclerView=(RecyclerView)view.findViewById(R.id.recycle_view);
        matches_fixtures_adapter=new matches_fixtures_adapter(getActivity(),populate());
        matches_fixtures_adapter.notifyDataSetChanged();
        mLayoutManager = new LinearLayoutManager(getContext());
        mStaggeredLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(matches_fixtures_adapter);
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getContext(),recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent=new Intent(getContext(),Match_details.class);

                intent.putExtra("datapos", position);
                intent.putExtra("data",matches_pojos);
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));



        return view;
    }

}
