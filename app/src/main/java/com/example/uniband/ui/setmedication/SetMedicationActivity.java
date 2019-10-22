package com.example.uniband.ui.setmedication;
import android.app.FragmentTransaction;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.media.TimedMetaData;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;
import android.app.Fragment;
import com.example.uniband.R;
//import androidx.fragment.app.DialogFragment;
import java.util.Calendar;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

public class SetMedicationActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, TimePickerDialog.OnTimeSetListener{
//    private SpinnerActivity spinnerActivity;
    public static String meds_name;
    public static String meds_amount;
    public static String meds_frequency;
    public static final String EXTRA_MESSAGE_meds_name = "com.example.uniband.medsname";
    public static final String EXTRA_MESSAGE_meds_frequency = "com.example.uniband.medsfrequency";
    public static final String EXTRA_MESSAGE_meds_amount = "com.example.uniband.medsamount";
//    Button monday = (Button) findViewById(R.id.monday);
//    Button tuesday = (Button) findViewById(R.id.tuesday);
//    Button wednesday = (Button) findViewById(R.id.wednesday);
//    Button thursday = (Button) findViewById(R.id.thursday);
//    Button friday = (Button) findViewById(R.id.friday);
//    Button saturday = (Button) findViewById(R.id.saturday);
//    Button sunday = (Button) findViewById(R.id.sunday);
    int[] date = {R.id.monday, R.id.tuesday, R.id.wednesday, R.id.thursday, R.id.friday, R.id.saturday, R.id.sunday};
    private boolean isButtonClicked_monday = false;
    //    final Spinner spinner_frequency = findViewById(R.id.spinner_frequency);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_medication_activity);
//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.container, SetMedicationFragment.newInstance())
//                    .commitNow();
//        }

        Spinner spinner_frequency = (Spinner) findViewById(R.id.spinner_frequency);
// Create an ArrayAdapter using the string array and a default spinner layout
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
//                R.array.meds_frequency, android.R.layout.simple_spinner_item);
//// Specify the layout to use when the list of choices appears
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//// Apply the adapter to the spinner
//        spinner_frequency.setAdapter(adapter);
        spinner_frequency.setOnItemSelectedListener(this);
        Spinner spinner_medsname = (Spinner) findViewById(R.id.spinner_medsname);
        spinner_medsname.setOnItemSelectedListener(this);
        Spinner spinner_medsamount = (Spinner) findViewById(R.id.spinner_medsamount);
        spinner_medsamount.setOnItemSelectedListener(this);

        for (int i=0; i<date.length;i++){
            int day = date[i];
            final Button button = findViewById(day);
            button.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v) {
                    // Do something in response to button click
//                    if (v.getId() == R.id.monday) {
//                        isButtonClicked_monday = !isButtonClicked_monday; // toggle the boolean flag
//                        v.setBackgroundResource(isButtonClicked_monday ? R.drawable.roundedbutton_off : R.drawable.roundedbutton_on);
//                        v.setText
//                    }
                    if(button.getTag()=="off"){
                        button.setTag("on");
                        button.setBackgroundResource(R.drawable.roundedbutton_on);
                        button.setTextColor(Color.parseColor("#1E90FF"));

                    } else {
                        button.setTag("off");
                        button.setBackgroundResource(R.drawable.roundedbutton_off);
                        button.setTextColor(Color.WHITE);

                    }
                }
            });
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
//        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
        if (parent == findViewById(R.id.spinner_frequency)){
            meds_frequency = item;
            generateButton(position);
        }
        if (parent == findViewById(R.id.spinner_medsname)){
            meds_name = item;
        }
        if (parent == findViewById(R.id.spinner_medsamount)){
            meds_amount = item;
        }
        //generate buttons accordingly
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }


    public void generateButton(int times){
//        int button_id = 0;
        LinearLayout layout = (LinearLayout) findViewById(R.id.linear_layout);
        layout.removeAllViews();
//        TimePickerFragment timePickerFragment = new TimePickerFragment();
        final TimePickerFragment newFragment = new TimePickerFragment();

        final FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        String button_name = "btnTag";
        for (int i=0; i<times; i++){
            //set the properties for button
            EditText editText = new EditText(this);
//            editText.setId(R.id.edit_1);
            final Button btnTag = new Button(this);
//            EditText editText = findViewById(R.id.edit_1);
            btnTag.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            btnTag.setText("Time Slot" + i);
//            btnTag.setId(R.id.button_generated1);
            btnTag.setId(i);
//            fragmentTransaction.replace(R.id.linear_layout, new TimePickerFragment());
//            fragmentTransaction.commit();
//            EditText txtTime =new EditText(this);
//            layout.addView(txtTime);
            btnTag.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    TimePickerFragment newFragment = new TimePickerFragment();
                    newFragment.show(getFragmentManager(), "timePicker");

//                    newFragment.onTimeSet(editText);
//                    editText.setText();

                }
            });
            //add button to the layout
            layout.addView(btnTag);

            layout.addView(editText);
        }
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

    }
    public void next(View view){
        Intent intent = new Intent(this, ShowMedication.class);
        intent.putExtra(EXTRA_MESSAGE_meds_name,meds_name);
        intent.putExtra(EXTRA_MESSAGE_meds_frequency, meds_frequency);
        intent.putExtra(EXTRA_MESSAGE_meds_amount, meds_amount);

        startActivity(intent);
    }
}



