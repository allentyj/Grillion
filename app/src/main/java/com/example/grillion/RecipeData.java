package com.example.grillion;

public class RecipeData {


    //Variables for TABLE_IDENTIFIERS
    private int mPrimaryID;
    private String mPrimaryName;
    private String mPrimaryLink;

    //Variables for TABLE_RECIPE_TO_LIST
    private int mIngID;
    private String mIngredient;
    private String mIngQuantity;

    //Variables for TABLE_USER_INPUT
    private int mNoteID;
    private String mNote;
    private String mNoteLink;

    //Constructors
    public RecipeData(int id, String name, String link){
        mPrimaryID = id;
        mPrimaryName = name;
        mPrimaryLink = link;
    }

    public RecipeData(int id, String name, String link, String note){
        mPrimaryID = id;
        mPrimaryName = name;
        mPrimaryLink = link;
        mNote = note;
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
    public String getmIngQuantity() {return mIngQuantity;}
    public void setmIngQuantity(String mIngQuantity) {this.mIngQuantity = mIngQuantity;}

    //Getters and setters for TABLE_USER_INPUT
    public int getmNoteID() {return mNoteID;}
    public void setmNoteID(int mNoteID) {this.mNoteID = mNoteID;}
    public String getmNote() {return mNote;}
    public void setmNote(String mNote) {this.mNote = mNote;}
    public String getmNoteLink() {return mNoteLink;}
    public void setmNoteLink(String mNoteLink) {this.mNoteLink = mNoteLink;}
}
