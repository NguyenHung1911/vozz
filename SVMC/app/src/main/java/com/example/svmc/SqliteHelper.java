package com.example.svmc;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.svmc.model.iteam;

import java.util.ArrayList;
import java.util.List;

public class SqliteHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "NGHIEMVU.db";
    private static final int DATABASE_VERSION = 1;
    public SqliteHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String creatDB = "CREATE TABLE nv(" +
                "id INTERGER PRIMARY KEY AUTOINCREMENT,name TEXT,date TEXT, " +
                "timeStart TEXT,timeEnd TEXT,content TEXT,TrangThai INTEGER)";
        db.execSQL(creatDB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    public ArrayList<iteam> getAll() {
        ArrayList<iteam> list = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        //String order = "dateNV DESC;
        Cursor rs = db.query("nv", null, null, null, null, null, null);
        while (rs != null && rs.moveToNext()) {
            int id = rs.getInt(0);
            String name = rs.getString(1);
            String date = rs.getString(2);
            String timeSt = rs.getString(3);
            String timeEd = rs.getString(4);
            String content = rs.getString(5);
            int trangThai = rs.getInt(6);
            list.add(new iteam(id, name, date, timeSt, timeEd, content, trangThai));
        }
        return list;
    }
}
