package com.example.eric.gmn.matchesDetails;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.eric.gmn.R;
import com.example.eric.gmn.matches_pojo;

import java.util.ArrayList;
import java.util.Random;

public class Play extends AppCompatActivity {
    private Dialog dialog;
    private ArrayList<matches_pojo> matches_pojos;
    private Button button,button1,button2;
    TextView txt1,txt2;

    public int random(){
        Random random=new Random();
       return random.nextInt(6)+1;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        button=(Button)findViewById(R.id.buttonSet) ;
        button1=(Button)findViewById(R.id.team1) ;
        button2=(Button)findViewById(R.id.team2) ;
        txt1=(TextView)findViewById(R.id.txt1);
        txt2=(TextView)findViewById(R.id.txt2);
        Intent intent=getIntent();
        matches_pojos=(ArrayList<matches_pojo>) intent.getSerializableExtra("data");
    }

    public void team1(View view) {
        dialog =new Dialog(Play.this);
        dialog.setContentView(R.layout.dialog_play_team_selection);
        dialog.show();
        final Spinner spinner=(Spinner)dialog.findViewById(R.id.spinnerTeam);
        Button buttonset=(Button)dialog.findViewById(R.id.buttonSet);
        buttonset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setText(spinner.getSelectedItem().toString());
                txt1.setText(String.valueOf(random()));
                txt2.setText(String.valueOf(random()));
                dialog.dismiss();
            }
        });

        ArrayList<String> el=new ArrayList<>();
        for(int a=0;a<matches_pojos.size();a++){
            el.add(matches_pojos.get(a).getMatch_team1_home());
            el.add(matches_pojos.get(a).getMatch_team2_away());
        }
        ArrayAdapter<String> simpleAdapterB=new ArrayAdapter<String>(getApplicationContext(),R.layout.spinner_view,el);
        spinner.setAdapter(simpleAdapterB);




    }

    public void team2(View view) {
        dialog =new Dialog(Play.this);
        dialog.setContentView(R.layout.dialog_play_team_selection);
        dialog.show();
        Button buttonset=(Button)dialog.findViewById(R.id.buttonSet);
        final Spinner spinner=(Spinner)dialog.findViewById(R.id.spinnerTeam);
        buttonset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button2.setText(spinner.getSelectedItem().toString());
                txt1.setText(String.valueOf(random()));
                txt2.setText(String.valueOf(random()));
                dialog.dismiss();
               // dialog.dismiss();
            }
        });

        ArrayList<String> el=new ArrayList<>();
        for(int a=0;a<matches_pojos.size();a++){
            el.add(matches_pojos.get(a).getMatch_team1_home());
            el.add(matches_pojos.get(a).getMatch_team2_away());
        }
        ArrayAdapter<String> simpleAdapterB=new ArrayAdapter<String>(getApplicationContext(),R.layout.spinner_view,el);
        spinner.setAdapter(simpleAdapterB);


    }
}
