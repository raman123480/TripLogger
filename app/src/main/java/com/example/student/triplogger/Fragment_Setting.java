package com.example.student.triplogger;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Fragment;
import android.widget.EditText;

import com.example.student.triplogger.R;


public class Fragment_Setting extends Fragment {

    SQLiteDatabase db;
    DatabaseHandler mdb;
    View viewInflater;
    EditText name, enrollment, gender, comment, email;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        viewInflater = inflater.inflate(R.layout.fragment__setting, container, false);

        name = (EditText) viewInflater.findViewById(R.id.settingName);
        enrollment = (EditText) viewInflater.findViewById(R.id.settingEnrollment);
        gender = (EditText) viewInflater.findViewById(R.id.settingGender);
        comment = (EditText) viewInflater.findViewById(R.id.settingComment);
        email = (EditText) viewInflater.findViewById(R.id.settingEmail);

        mdb = new DatabaseHandler(getActivity());

        String[] projection = {"name","enrollment","gender","email","comment"};

        db = mdb.getReadableDatabase();
        Cursor cursor = db.query("table_student",projection,null,null,null,null,null);

        name.setText(cursor.getColumnIndex("name"));
        enrollment.setText(cursor.getColumnIndex("enrollment"));
        gender.setText(cursor.getColumnIndex("gender"));
        comment.setText(cursor.getColumnIndex("comment"));
        email.setText(cursor.getColumnIndex("email"));



    return viewInflater;
    }



}


