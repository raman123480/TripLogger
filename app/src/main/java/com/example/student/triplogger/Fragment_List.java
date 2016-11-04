package com.example.student.triplogger;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.app.Fragment;

import com.example.student.triplogger.R;


public class Fragment_List extends Fragment {

    private View viewInflater = null;
    private SQLiteDatabase db;
    String title,date,destination;
    tripAdaptor adaptor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        viewInflater =  inflater.inflate(R.layout.fragment__list, container, false);

        ListView list = (ListView) viewInflater.findViewById(R.id.myList);

        DatabaseHandler mdb = new DatabaseHandler(getActivity());

        db = mdb.getReadableDatabase();

        final String[] projection = {"id","title","date","desination"};
        Cursor cursor = db.query("table_trip",projection,null,null,null,null,null,null);
        cursor.moveToFirst();
        String[] fromTrip = {"title","date","desination"};
        int[] toTrip = {R.id.custitle, R.id.cusdate, R.id.cusdestionation};

        SimpleCursorAdapter myCursorAdapter;
        myCursorAdapter = new SimpleCursorAdapter(getActivity(),R.layout.customize_list,cursor,fromTrip,toTrip,0);
        list.setAdapter(myCursorAdapter);

        list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object o = projection[position];
                String string = o.toString();
                Bundle args = new Bundle();
                args.putString("ID", string);

                Fragment fragment = new Fragment_Log();
                fragment.setArguments(args);
                FragmentManager fm = getFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_place, fragment);
                fragmentTransaction.commit();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        /*while (cursor.moveToNext()) {
            title = cursor.getString(cursor.getColumnIndex("title"));
            date  = cursor.getString(cursor.getColumnIndex("date"));
            destination = cursor.getString(cursor.getColumnIndex("desination"));

            tripLoggerClass getTripDetails = new tripLoggerClass(title,date,destination);

        }*/


        return viewInflater;
    }


}
