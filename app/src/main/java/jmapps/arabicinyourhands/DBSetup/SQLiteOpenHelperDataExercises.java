package jmapps.arabicinyourhands.DBSetup;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import jmapps.arabicinyourhands.Models.ModelExercises;
import jmapps.arabicinyourhands.R;

public class SQLiteOpenHelperDataExercises extends SQLiteOpenHelper {

    private static final String DBName = "ArabicInYourHandsBD";
    private static final int DBVersion = 1;

    private static final String IDPosition = "_id";
    private static final String TableName = "Table_of_exercises";

    private static final String TitleName = "Title_name";
    private static final String TitleContent = "Title_content";

    private static final String QuestionOneName = "Question_one_name";
    private static final String NameAudioOne = "Name_audio_one";
    private static final String AnswerTwoName = "Answer_two_name";
    private static final String NameAudioTwo = "Name_audio_two";
    private static final String QuestionThreeName = "Question_three_name";
    private static final String NameAudioThree = "Name_audio_three";
    private static final String AnswerFourName = "Answer_four_name";
    private static final String NameAudioFour = "Name_audio_four";
    private static final String QuestionFiveName = "Question_five_name";
    private static final String NameAudioFive = "Name_audio_five";
    private static final String AnswerSixName = "Answer_six_name";
    private static final String NameAudioSix = "Name_audio_six";

    private static final String TableOfNames = "CREATE TABLE " + TableName +
            "(" + IDPosition + " " + "INTEGER PRIMARY KEY AUTOINCREMENT, "
            + TitleName + " TEXT, " + TitleContent + " TEXT, "
            + QuestionOneName + " TEXT, " + NameAudioOne + " TEXT, "
            + AnswerTwoName + " TEXT, " + NameAudioTwo + " TEXT, "
            + QuestionThreeName + " TEXT, " + NameAudioThree + " TEXT, "
            + AnswerFourName + " TEXT, " + NameAudioFour + " TEXT, "
            + QuestionFiveName + " TEXT, " + NameAudioFive + " TEXT, "
            + AnswerSixName + " TEXT, " + NameAudioSix + " TEXT)";

    private static final String[] mColumnsContent = {
            IDPosition, TitleName, TitleContent,
            QuestionOneName, NameAudioOne, AnswerTwoName, NameAudioTwo,
            QuestionThreeName, NameAudioThree, AnswerFourName, NameAudioFour,
            QuestionFiveName, NameAudioFive, AnswerSixName, NameAudioSix};

    public SQLiteOpenHelperDataExercises(Context context) {
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

    public List<ModelExercises> getExercisesContent(int exercisesItems) {

        SQLiteDatabase dbOnlyContent = this.getReadableDatabase();

        @SuppressLint("Recycle") Cursor cursor = dbOnlyContent.query(TableName,
                mColumnsContent,
                "Content_exercises_number = ?",
                new String[]{String.valueOf(exercisesItems)},
                null, null, null, null);

        List<ModelExercises> allExercisesContent = new ArrayList<>();

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                allExercisesContent.add(new ModelExercises
                        (cursor.getString(cursor.getColumnIndex(IDPosition)),
                                cursor.getString(cursor.getColumnIndex(TitleName)),
                                cursor.getString(cursor.getColumnIndex(TitleContent)),
                                cursor.getString(cursor.getColumnIndex(QuestionOneName)),
                                cursor.getString(cursor.getColumnIndex(NameAudioOne)),
                                cursor.getString(cursor.getColumnIndex(AnswerTwoName)),
                                cursor.getString(cursor.getColumnIndex(NameAudioTwo)),
                                cursor.getString(cursor.getColumnIndex(QuestionThreeName)),
                                cursor.getString(cursor.getColumnIndex(NameAudioThree)),
                                cursor.getString(cursor.getColumnIndex(AnswerFourName)),
                                cursor.getString(cursor.getColumnIndex(NameAudioFour)),
                                cursor.getString(cursor.getColumnIndex(QuestionFiveName)),
                                cursor.getString(cursor.getColumnIndex(NameAudioFive)),
                                cursor.getString(cursor.getColumnIndex(AnswerSixName)),
                                cursor.getString(cursor.getColumnIndex(NameAudioSix))));
                cursor.moveToNext();
            }
        }
        return allExercisesContent;
    }
}
