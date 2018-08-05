package jmapps.arabicinyourhands.DBSetup;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import jmapps.arabicinyourhands.Models.ModelChaptersLessons;
import jmapps.arabicinyourhands.R;

public class SQLiteOpenHelperDataLessonsChapters extends SQLiteOpenHelper {

    private static final String DBName = "ArabicInYourHandsBD";
    private static final int DBVersion = 1;

    private static final String TableName = "Table_of_chapters";
    private static final String TitleName = "Title_name";
    private static final String TitleIcon = "Title_icon";
    private static final String setContentForChapter = "setContent_for_chapter";

    private static final String TableOfNames = "CREATE TABLE " + TableName +
            "(" + "_id" + " " + "INTEGER PRIMARY KEY AUTOINCREMENT, "
            + TitleName + " TEXT, " + TitleName + " TEXT, " + setContentForChapter + " TEXT)";

    private static final String[] mColumnsContent = {TitleName, TitleIcon, setContentForChapter};

    public SQLiteOpenHelperDataLessonsChapters(Context context) {
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

    public List<ModelChaptersLessons> getContentLessonsChapters(String contentForChapter) {

        SQLiteDatabase dbOnlyContent = this.getReadableDatabase();

        @SuppressLint("Recycle") Cursor cursor = dbOnlyContent.query(TableName,
                mColumnsContent,
                "getContent_for_chapter = ?",
                new String[]{String.valueOf(contentForChapter)},
                null, null, null, null);

        List<ModelChaptersLessons> allLessonsChaptersContent = new ArrayList<>();

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                allLessonsChaptersContent.add(new ModelChaptersLessons
                        (cursor.getString(cursor.getColumnIndex(TitleName)),
                        cursor.getString(cursor.getColumnIndex(TitleIcon)),
                                cursor.getString(cursor.getColumnIndex(setContentForChapter))));
                cursor.moveToNext();
            }
        }
        return allLessonsChaptersContent;
    }
}
