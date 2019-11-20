package com.example.hotelbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener

{

    private Spinner spnLocation;
    private Spinner spnRoom;
    TextView txtViewchkIn, txtViewchkOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spnLocation = findViewById(R.id.spnLocation);

        String Location[] = {"Kathmandu", "Pokhara","Butwal","Dhading", "Chitwan"};
        ArrayAdapter adapter = new ArrayAdapter<>
                (
                         this,
                        android.R.layout.simple_list_item_1,
                        Location

                );
        spnLocation.setAdapter(adapter);

        //spinroom

        spnRoom = findViewById(R.id.spnRoom);

        String Room[] = {"Deluxe Rs.2000", "AC Rs.1500","Suite Rs.5000"};
        ArrayAdapter adapter1 = new ArrayAdapter<>
                (
                        this,
                        android.R.layout.simple_list_item_1,
                        Room

                );
        spnRoom.setAdapter(adapter1);


        txtViewchkIn = findViewById(R.id.txtViewchkIn);
        txtViewchkOut = findViewById(R.id.txtViewchkOut);

        txtViewchkIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //function  call  gareko
                loadDatePicker();
            }

        });







    }


    private void loadDatePicker()
    {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog
                (this,this,year,month,day);
        datePickerDialog.show();

    }

    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth)
    {
        String date = "Your Selected date is: " + month + "/" + dayOfMonth + "/" + year;
        txtViewchkIn.setText(date);

    }








}

