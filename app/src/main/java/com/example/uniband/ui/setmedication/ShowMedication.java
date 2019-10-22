package com.example.uniband.ui.setmedication;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

import com.example.uniband.R;

import java.util.Set;

public class ShowMedication extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_medication);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Intent intent = getIntent();
        String message_meds_name = intent.getStringExtra(SetMedicationActivity.EXTRA_MESSAGE_meds_name);
        String message_meds_frequency = intent.getStringExtra(SetMedicationActivity.EXTRA_MESSAGE_meds_frequency);
        String message_meds_amount = intent.getStringExtra(SetMedicationActivity.EXTRA_MESSAGE_meds_amount);
        TextView view_meds_name = findViewById(R.id.meds_name);
        TextView view_meds_frequency = findViewById(R.id.meds_frequency);
        TextView view_meds_amount = findViewById(R.id.meds_amount);

        view_meds_name.setText(message_meds_name);
        view_meds_frequency.setText(message_meds_frequency);
        view_meds_amount.setText(message_meds_amount);

    }

}
