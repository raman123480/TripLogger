package com.example.student.triplogger;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.media.Image;

/**
 * Created by faisalali on 10/31/2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "tripLogger";
    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_TRIP_TYPE = "tripType";
    private static final String KEY_DATE = "date";
    private static final String KEY_DESINATION = "desination";
    private static final String TABLE_STUDENT = "table_student";
    private static final String TABLE_TRIP = "table_trip";
    private static final String KEY_DURATION = "duration";
    private static final String KEY_COMMENT = "comment";
    private static final String KEY_NAME = "name";
    private static final String KEY_ENROLLMENT = "enrollment";
    private static final String KEY_GENDER = "gender";
    private static final String KEY_LOCATION = "location";

    private static final String KEY_IMAGE = "image_data";


    public static final String CREATE_TABLE_TRIP =
                " CREATE TABLE IF NOT EXISTS " + TABLE_TRIP+ " ("
            + KEY_ID + 	" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "
                        + KEY_TITLE + " TEXT NOT NULL," +
                        KEY_DATE + " TEXT NOT NULL, " +
                        KEY_TRIP_TYPE + " EXT NOT NULL, " +
                        KEY_DESINATION + " TEXT NOT NULL, " +
                        KEY_DURATION + " TEXT NOT NULL, " +
                        KEY_COMMENT + " TEXT NOT NULL, " +
                       KEY_IMAGE + " BLOB NULL); ";

    public static final String CRATE_TABE_STUDENT =
            " CREATE TABLE IF NOT EXISTS " + TABLE_STUDENT + " ("
            + KEY_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "
            + KEY_NAME + " TEXT NOT NULL, "
            + KEY_GENDER + " TEXT NOT NULL, "
            + KEY_ENROLLMENT + " TEXT NOT NULL, "
            + KEY_ENROLLMENT + " TEXT NOT NULL, "
            + KEY_COMMENT + " TEXT NOT NULL); ";



    public DatabaseHandler(Context context) {

        super(context, DATABASE_NAME,null,DATABASE_VERSION );
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_TRIP);
        db.execSQL(CRATE_TABE_STUDENT);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TRIP);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENT);
        onCreate(db);

    }
}
