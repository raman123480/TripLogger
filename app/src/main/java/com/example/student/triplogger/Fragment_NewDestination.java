package com.example.student.triplogger;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.LocationManager;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;

import java.io.ByteArrayOutputStream;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import android.view.LayoutInflater;
import android.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Fragment_NewDestination extends Fragment {

    View inflaterView = null;
    public static final String DATE_FROM_NOW = "yyyy-MM-dd HH:mm:ss";
    EditText title,date,editdestination,duration,comment;
    Image image;
    private SQLiteDatabase db;
    private byte[] img = null;
    Spinner trip_type;
    Button btnSave, btnCancle;
    String valFromTripType, strTitle, strDate, strDestination, strTripType,
            strDuration, strComment;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        this.inflaterView = inflater.inflate(R.layout.fragment__new_destination,container,false);
       //setting TextFields

        DatabaseHandler mdb = new DatabaseHandler(getActivity());

        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.main);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        b.compress(Bitmap.CompressFormat.PNG, 100, bos);
        img = bos.toByteArray();
        db = mdb.getWritableDatabase();

        title = (EditText) inflaterView.findViewById(R.id.newDetail);
        date = (EditText) inflaterView.findViewById(R.id.newDate);
        editdestination = (EditText) inflaterView.findViewById(R.id.newDestination);
        duration = (EditText) inflaterView.findViewById(R.id.newDuration);
        comment = (EditText) inflaterView.findViewById(R.id.newComment);
        btnSave = (Button) inflaterView.findViewById(R.id.newSave);
        btnCancle = (Button) inflaterView.findViewById(R.id.newCancel);
        trip_type = (Spinner) inflaterView.findViewById(R.id.newTripType);

        //Spinner Setting
        final String[] values = {"Work", "Personal", "Commute"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),
               android.R.layout.simple_spinner_item,values );
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        trip_type.setAdapter(adapter);
        date.setText(now());

        trip_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                strTripType = values[position];

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Inflate the layout for this fragment

        //return inflater.inflate(R.layout.fragment__new_destination, container, false);

        Button btnNewSave = (Button) inflaterView.findViewById(R.id.newSave);
        Button btnNewCancle = (Button) inflaterView.findViewById(R.id.newCancel);

        btnNewSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strDate = now();
                strTitle = title.getText().toString();
                strDestination = editdestination.toString();
                strComment = comment.getText().toString();
                strDuration = duration.getText().toString();
                ContentValues cv = new ContentValues();

                cv.put("title",strTitle);
                cv.put("date",strDate);
                cv.put("tripType", strTripType);
                cv.put("desination", strDestination);
                cv.put("duration",strDuration);
                cv.put("comment", strComment);
                cv.put("image_data",img);

                db.insert("table_trip",null,cv);

                Toast.makeText(getActivity(),strDate,Toast.LENGTH_SHORT).show();


            }
        });

        btnNewCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment frm = new Fragment_List();
                FragmentManager manager = getFragmentManager();
                FragmentTransaction ft = manager.beginTransaction();
                ft.replace(R.id.fragment_place, frm);
                ft.commit();
            }
        });



        return inflaterView;
    }



    public static String now() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FROM_NOW);
        return sdf.format(cal.getTime());
    }


}
