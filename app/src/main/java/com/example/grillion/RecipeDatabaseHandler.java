package com.example.grillion;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class RecipeDatabaseHandler extends SQLiteOpenHelper{

    //Current database version
    private static final int DATABASE_VERSION = 1;

    //Database name and table names
    private static final String DATABASE_NAME = "grillionDB.db";
    private static final String TABLE_IDENTIFIERS = "Identifiers";
    private static final String TABLE_RECIPE_TO_LIST = "Recipe_To_List";
    private static final String TABLE_USER_INPUT = "User_Input";

    //Columns for TABLE_IDENTIFIERS
    private static final String COLUMN_PRIMARY_ID = "ID";
    private static final String COLUMN_PRIMARY_NAME = "Recipe_Name";
    private static final String COLUMN_PRIMARY_LINK = "Recipe_JSON";

    //Columns for TABLE_RECIPE_TO_LIST
    private static final String COLUMN_ING_ID = "Ingredient_ID";
    private static final String COLUMN_ING = "Ingredient";

    //Columns for TABLE_USER_INPUT
    private static final String COLUMN_INP_ID = "Input_ID";
    private static final String COLUMN_NOTES = "Notes";

    public RecipeDatabaseHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database){

        //Creates the primary table of identifiers
        String CREATE_TABLE_IDENTIFIERS = "CREATE TABLE " +
                TABLE_IDENTIFIERS + "(" +
                COLUMN_PRIMARY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_PRIMARY_NAME + " TEXT, " +
                COLUMN_PRIMARY_LINK + " TEXT)";

        //Creates the recipe list table
        String CREATE_TABLE_RECIPE_TO_LIST = "CREATE TABLE " +
                TABLE_IDENTIFIERS + "(" +
                COLUMN_ING_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_ING + " TEXT)";

        //Creates the note populate data table
        String CREATE_TABLE_USER_INPUT = "CREATE TABLE " +
                TABLE_USER_INPUT + "(" +
                COLUMN_INP_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NOTES + " TEXT)";


        //Creates all of the tables in SQL
        database.execSQL(CREATE_TABLE_IDENTIFIERS);
        database.execSQL(CREATE_TABLE_RECIPE_TO_LIST);
        database.execSQL(CREATE_TABLE_USER_INPUT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_USER_INPUT);
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_IDENTIFIERS);
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_RECIPE_TO_LIST);
        onCreate(database);
    }

    public void addRecipeNotes(RecipeData recipeNotes){
        ContentValues myValues = new ContentValues();
        myValues.put(COLUMN_NOTES, recipeNotes.getmNote());

        SQLiteDatabase database = this.getWritableDatabase();
        database.insert(TABLE_USER_INPUT, null, myValues);
        database.close();
    }

    public boolean deleteNotes(String name){
        boolean result = false;

        String sqlQuery = "SELECT * FROM " + TABLE_USER_INPUT +
                " WHERE " + COLUMN_NOTES + " =\"" +
                name + "\"";
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor myCursor = database.rawQuery(sqlQuery, null);
        RecipeData myRecipe = null;

        if(myCursor.moveToFirst()){
            int tmpID = myCursor.getInt(0);

            String where = COLUMN_INP_ID + "=?";
            String[] whereArgs = {String.valueOf(tmpID)};
            database.delete(TABLE_USER_INPUT, where, whereArgs);
            myCursor.close();
            result = true;
        }
        database.close();
        return result;
    }

}
