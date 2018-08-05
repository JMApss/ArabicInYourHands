package jmapps.arabicinyourhands.DBSetup;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import jmapps.arabicinyourhands.Models.ModelContentsLessons;
import jmapps.arabicinyourhands.R;

public class SQLiteOpenHelperDataLessonsContents extends SQLiteOpenHelper {

    private static final String DBName = "ArabicInYourHandsBD";
    private static final int DBVersion = 1;

    private static final String TableName = "Table_content_of_chapters";
    private static final String ContentArabic = "Content_arabic";
    private static final String ContentRussian = "Content_russian";
    private static final String NameAudio = "Name_audio";

    private static final String TableOfNames = "CREATE TABLE " + TableName +
            "(" + "_id" + " " + "INTEGER PRIMARY KEY AUTOINCREMENT, "
            + ContentArabic + " TEXT, " + ContentRussian + " TEXT, "
            +  NameAudio + " TEXT)";

    private static final String[] mColumnsContent = {ContentArabic, ContentRussian, NameAudio};

    public SQLiteOpenHelperDataLessonsContents(Context context) {
        super(context, DBName, null, DBVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TableOfNames);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(R.string.drop_table_if_exists + TableName);
        this.onCreate(sqLiteDatabase);
    }

    public List<ModelContentsLessons> getLessonsContent(String contentID) {

        SQLiteDatabase dbOnlyContent = this.getReadableDatabase();

        @SuppressLint("Recycle") Cursor cursor = dbOnlyContent.query(TableName,
                mColumnsContent,
                "getContent_for_chapter = ?",
                new String[]{String.valueOf(contentID)},
                null, null, null, null);

        List<ModelContentsLessons> allLessonsContent = new ArrayList<>();

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                allLessonsContent.add(new ModelContentsLessons
                        (cursor.getString(cursor.getColumnIndex(ContentArabic)),
                                cursor.getString(cursor.getColumnIndex(ContentRussian)),
                                cursor.getString(cursor.getColumnIndex(NameAudio))));
                cursor.moveToNext();
            }
        }
        return allLessonsContent;
    }
}
