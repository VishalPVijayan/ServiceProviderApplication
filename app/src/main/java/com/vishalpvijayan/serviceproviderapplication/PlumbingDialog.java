package com.vishalpvijayan.serviceproviderapplication;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import java.util.Calendar;

public class PlumbingDialog extends AppCompatDialogFragment {



    TextView txtDate,txtTime;
    CheckBox cb1,cb2,cb3,cb4;

    String datem;

    String Priority;
    private Spinner spinner1;


//    private DatabaseReference mDatabase;




    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private TimePickerDialog.OnTimeSetListener onTimeSetListener;
    Calendar calendar;
    int currentHour;
    int currentMin;
    String AmPm;
    String time;



    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());



        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.c_l_plumbing, null);

        cb1 = view.findViewById(R.id.cb1);
        cb2 = view.findViewById(R.id.cb2);
        cb3 = view.findViewById(R.id.cb3);
        cb4 = view.findViewById(R.id.cb4);
        spinner1 = view.findViewById(R.id.spinner1);




        txtDate = view.findViewById(R.id.txtDate);
        txtTime = view.findViewById(R.id.txtTime);


        txtTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calendar = Calendar.getInstance();
                currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                currentMin = calendar.get(Calendar.MINUTE);




                TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        if(hourOfDay>= 12){
                            AmPm = "PM";
                        }else {
                            AmPm = "AM";
                        }
                         txtTime.setText(hourOfDay +":"+minute + AmPm);

                        time = hourOfDay + minute +AmPm;
                    }
                },currentHour,currentMin,false); timePickerDialog.show();



            }
        });

        txtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int date = calendar.get(Calendar.DATE);

                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), android.R.style.Theme_DeviceDefault_Dialog,mDateSetListener,year,month,date);
                datePickerDialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {


                month = month+1;
               datem = month + "/" + dayOfMonth + "/" +year;
                txtDate.setText(datem);


            }
        };


        builder.setView(view)
                .setTitle("")
                .setPositiveButton("Request Service", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        StringBuilder result=new StringBuilder();
                        result.append("\n Selected Service :  \n");

                        if(cb1.isChecked()){
                            String cb1Value = cb1.getText().toString().trim();
                                result.append(cb1Value+" "+"\n ");
                        }

                        if(cb2.isChecked()){
                            String cb2Value = cb2.getText().toString().trim();
                            result.append(cb2Value+" "+"\n ");
                        }

                        if(cb3.isChecked()){
                            String cb3Value = cb3.getText().toString().trim();
                            result.append(cb3Value+" "+"\n ");
                        }

                        if(cb4.isChecked()){
                            String cb4Value = cb4.getText().toString().trim();
                            result.append(cb4Value+" "+"\n ");
                        }


                        Toast.makeText(getContext(), "" + "\n User Priority : \n"+ String.valueOf(spinner1.getSelectedItem()) +result, Toast.LENGTH_LONG).show();

                        String priority1 = spinner1.getSelectedItem().toString().trim();
                        String service = result.toString();
                        String date = datem.toString();
                        String title = " Plumbing ";




                        Bundle bundle = new Bundle();
                        bundle.putString("Title",title);
                        bundle.putString("ServiceNeeded",service);
                        bundle.putString("Time",time);
                        bundle.putString("Date",date);
                        bundle.putString("Priority",priority1);




//                        mDatabase = FirebaseDatabase.getInstance().getReference();







                            Intent intent = new Intent(getActivity(), FetchLocationActivity.class);
                            intent.putExtras(bundle);
                            startActivity(intent);










                    }


                })
                .setNegativeButton(" Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
return builder.create();

    }
}
