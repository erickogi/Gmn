package com.example.eric.gmn;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Eric on 23/08/2017.
 */

public class matches_fixtures_adapter extends RecyclerView.Adapter<matches_fixtures_adapter.MyViewHolder> {
    private Context context;
    private ArrayList<matches_pojo> modelList;

    public matches_fixtures_adapter(Context context, ArrayList<matches_pojo> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    public matches_fixtures_adapter() {
    }

    @Override
    public matches_fixtures_adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.match_list_items, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(matches_fixtures_adapter.MyViewHolder holder, int position) {
        matches_pojo matches_pojo=modelList.get(position);
        holder.txtTeam1.setText(matches_pojo.getMatch_team1_home());
        holder.txtTeam2.setText(matches_pojo.getMatch_team2_away());
        holder.txtTime.setText(matches_pojo.getMatch_time());
        holder.txtTimeOfDay.setText("PM");

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtTime,txtTimeOfDay,txtTeam1,txtTeam2;
        public MyViewHolder(View itemView) {
            super(itemView);
            txtTime=(TextView)itemView.findViewById(R.id.time);
            txtTimeOfDay=(TextView)itemView.findViewById(R.id.time_hour);
            txtTeam1=(TextView)itemView.findViewById(R.id.team_name1);
            txtTeam2=(TextView)itemView.findViewById(R.id.team_name2);

        }
    }
}
