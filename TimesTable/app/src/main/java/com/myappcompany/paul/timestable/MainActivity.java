package com.myappcompany.paul.timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView timesTableListView;

    public void generateTimesTable (int timesTableNumber){

        ArrayList<String> timesTableContent = new ArrayList<String>();

        for (int j = 1; j <= 100; j++) {
            timesTableContent.add(Integer.toString(j * timesTableNumber));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timesTableContent);

        timesTableListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            SeekBar timesTableSeekBar = findViewById(R.id.timesTablesSeekBar);
        timesTableListView = findViewById(R.id.timesTablesListView);

        int max = 20;
        int statingPosition = 1;

        timesTableSeekBar.setMax(max);
        timesTableSeekBar.setProgress(statingPosition);

        generateTimesTable(statingPosition);

        timesTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min = 1;
                int timesTableNumber;

                if (i<min) {
                    timesTableNumber = min;
                    timesTableSeekBar.setProgress(min);
                } else {
                    timesTableNumber = i;
                }
                Log.i("SeekBar Value", Integer.toString((timesTableNumber)));
                generateTimesTable(timesTableNumber);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}