package com.example.uniband.ui.setmedication;

//import androidx.fragment.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.app.DialogFragment;
import android.app.Dialog;
import java.util.Calendar;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.uniband.R;

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
    public static final String EXTRA_MESSAGE = "com.example.uniband.SETTIME";

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current time as the default values for the picker
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        // Create a new instance of TimePickerDialog and return it
        return new TimePickerDialog(getActivity(), this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }
//    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        // Do something with the time chosen by the user
//        editText.setText(hourOfDay + ":" + minute);
//        view.setText();
//        EditText editText =view.findViewById(R.id.edit_1);
//        editText.setText(hourOfDay+":"+minute);
        Toast.makeText(view.getContext(), "time:"+hourOfDay, Toast.LENGTH_LONG).show();
//        Intent intent = new Intent(this, SpinnerActivity.class);


    }


}