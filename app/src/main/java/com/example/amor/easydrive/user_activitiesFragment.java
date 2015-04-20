package com.example.amor.easydrive;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Amor on 2015-03-10.
 */
public class user_activitiesFragment extends Fragment {
    View rootview;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.lay_user_activities, container, false);

        Button sendmessageMana = (Button)rootview.findViewById(R.id.sendmessage);
        sendmessageMana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendmessm = new Intent(getActivity(), SendMessageManager.class);
                startActivity(sendmessm);
            }
        });







        Button report = (Button)rootview.findViewById(R.id.reportbtn);
        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takemetoreport = new Intent(getActivity(), ReportUserActivity.class);
                startActivity(takemetoreport);
            }
        });

        return rootview;





    }



}
