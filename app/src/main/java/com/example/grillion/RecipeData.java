package com.example.grillion;

public class RecipeData {


    //Variables for TABLE_IDENTIFIERS
    private int mPrimaryID;
    private String mPrimaryName;
    private String mPrimaryLink;

    //Variables for TABLE_RECIPE_TO_LIST
    private int mIngID;
    private String mIngredient;

    //Variables for TABLE_USER_INPUT
    private String mNoteID;
    private String mNote;

    //Constructors
    public RecipeData(String id, String note){
        mNote = note;
        mNoteID = id;
    }

    //Getters and setters for TABLE_IDENTIFIERS
    public int getmPrimaryID() {return mPrimaryID;}
    public void setmPrimaryID(int mPrimaryID) {this.mPrimaryID = mPrimaryID;}
    public String getmPrimaryName() {return mPrimaryName;}
    public void setmPrimaryName(String mPrimaryName) {this.mPrimaryName = mPrimaryName;}
    public String getmPrimaryLink() {return mPrimaryLink;}
    public void setmPrimaryLink(String mPrimaryLink) {this.mPrimaryLink = mPrimaryLink;}

    //Getters and setters for TABLE_RECIPE_TO_LIST
    public int getmIngID() {return mIngID;}
    public void setmIngID(int mIngID) {this.mIngID = mIngID;}
    public String getmIngredient() {return mIngredient;}
    public void setmIngredient(String mIngredient) {this.mIngredient = mIngredient;}

    //Getters and setters for TABLE_USER_INPUT
    public String getmNoteID() {return mNoteID;}
    public void setmNoteID(String mNoteID) {this.mNoteID = mNoteID;}
    public String getmNote() {return mNote;}
    public void setmNote(String mNote) {this.mNote = mNote;}
}
