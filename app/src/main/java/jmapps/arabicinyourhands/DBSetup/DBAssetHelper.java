package jmapps.arabicinyourhands.DBSetup;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DBAssetHelper extends SQLiteAssetHelper {

    private static final int DBVersion = 1;
    private static final String DBName = "ArabicInYourHandsBD";

    public DBAssetHelper(Context context) {
        super(context, DBName, null, DBVersion);

        setForcedUpgrade(DBVersion);
    }
}
