package com.example.student.triplogger;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Fragment;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.student.triplogger.R;

import java.io.InputStream;

public class Fragment_Log extends Fragment {

    SQLiteDatabase db;
    DatabaseHandler mdb;
    View viewInflater;
    EditText title,date,destination,trip_type,duration,comment;
    ImageView img;
    Button btnDelete;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        viewInflater =  inflater.inflate(R.layout.fragment_fragment__log, container, false);
        db = mdb.getReadableDatabase();

        title = (EditText) viewInflater.findViewById(R.id.secondDetail);
        date = (EditText) viewInflater.findViewById(R.id.secondDate);
        destination = (EditText) viewInflater.findViewById(R.id.secondDestination);
        trip_type = (EditText) viewInflater.findViewById(R.id.secondTripType);
        duration = (EditText) viewInflater.findViewById(R.id.secondDuration);
        comment = (EditText) viewInflater.findViewById(R.id.secondComment);
        img = (ImageView) viewInflater.findViewById(R.id.secondImage);

        btnDelete = (Button) viewInflater.findViewById(R.id.secondDelete);

        final String[] str = {getArguments().getString("ID")};

        Cursor cursor = db.query("table_trip",null,"ID = " + str,null,null,null,null,null);

        title.setText(cursor.getColumnIndex("title"));
        date.setText(cursor.getColumnIndex("date"));
        destination.setText(cursor.getColumnIndex("desination"));
        trip_type.setText(cursor.getColumnIndex("trip_type"));
        duration.setText(cursor.getColumnIndex("duration"));
        comment.setText(cursor.getColumnIndex("comment"));

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.delete("table_trip","id=?",str);
            }
        });

    return viewInflater;
    }


}
