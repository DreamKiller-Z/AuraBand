package com.example.uniband.ui.setmedication;
import android.app.FragmentTransaction;
import android.app.TimePickerDialog;
import android.content.Intent;
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

public class SpinnerActivity extends AppCompatActivity implements OnItemSelectedListener, TimePickerDialog.OnTimeSetListener {
    public static String meds_name;
    public static String meds_amount;
    public static String meds_frequency;
    public static final String EXTRA_MESSAGE = "com.example.uniband.spinneractivity";
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.set_medication_activity);
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

        // Spinner Drop down elements
//        List<String> categories = new ArrayList<String>();
//        categories.add("Automobile");
//        categories.add("Business Services");
//        categories.add("Computers");
//        categories.add("Education");
//        categories.add("Personal");
//        categories.add("Travel");

        // Creating adapter for spinner
//        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
//        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
//        spinner.setAdapter(dataAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
//        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
        if (view == findViewById(R.id.spinner_frequency)){
            meds_frequency = item;
            generateButton(position);

        }
        if (view == findViewById(R.id.spinner_medsname)){
            meds_name = item;
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
        intent.putExtra(EXTRA_MESSAGE,meds_name);
        intent.putExtra(EXTRA_MESSAGE, meds_frequency);
        startActivity(intent);
    }
}
