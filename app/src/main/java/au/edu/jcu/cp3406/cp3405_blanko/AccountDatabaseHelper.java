package au.edu.jcu.cp3406.cp3405_blanko;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AccountDatabaseHelper extends SQLiteOpenHelper {

    private static final String TABLE_NAME = "accountTable";
    private static final String column1 = "firstName";
    private static final String column2 = "lastName";
    private static final String column3 = "question";
    private static final String column4 = "answer";

    public AccountDatabaseHelper(Context context) {

        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                column1 + " TEXT NOT NULL, " +
                column2 + " TEXT NOT NULL, " +
                column3 + " TEXT NOT NULL, " +
                column4 + " TEXT NOT NULL)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addUserAccount(String firstName, String lastName, String question, String answer) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(column1, firstName);
        contentValues.put(column2, lastName);
        contentValues.put(column3, question);
        contentValues.put(column4, answer);

        long result = db.insert(TABLE_NAME, null, contentValues);
    }
}
