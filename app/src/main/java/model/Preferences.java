package model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import java.util.ArrayList;
import java.util.List;

public class Preferences {
    public static SharedPreferences myPrefs; // Global Shared preference
    public static String prefernceName="USER_INFO"; // The Name of the shared preference

    public static final String pref_USER_ID="USER_ID";
    public static String pref_UserName="username";
    public static String pref_Surname="surname";
    public static String pref_OthName="othname";
    public static String pref_Reg_done="no";
    public static String pref_USER_School="";
    public static Context context;
    private static final String IS_LOGGED_IN = "IS_LOGGED_IN";
    private static final String REG_DONE = "REG_DONE";




    // functions to manipulate specific data in the Sharedpreference
    public static void setUserInfo(String surname,String othname,String email, String phone, String user_id, String username,String accountnum,String balance )
    {
        Editor edits= Preferences.myPrefs.edit();
        edits.putString(pref_Surname, surname);

        edits.putString(pref_OthName, othname);

        edits.putString(pref_UserName, username);

        edits.putString(pref_USER_ID, user_id);


        edits.commit();
    }


    public static void setisLoggedIn(Context c,boolean name)
    {
        Editor edits= Preferences.myPrefs.edit();
        edits.putBoolean(IS_LOGGED_IN, name);
        edits.commit();
    }



    public static String getBank()
    {
        String bank = "bank";
        bank = Preferences.myPrefs.getString("bank", "Bank");
        return bank;
    }


    public static String getUsername()
    {
        String username = "username";
        username = Preferences.myPrefs.getString(pref_UserName, "Username");
        return username;
    }





    public static Boolean getisLoggedIn()
    {
        Boolean val=false;
        val= Preferences.myPrefs.getBoolean(IS_LOGGED_IN, false);
        return val;
    }
    public static void setisRegDone(Context c,boolean name)
    {
        Editor edits= Preferences.myPrefs.edit();
        edits.putBoolean(REG_DONE, name);
        edits.commit();
    }

    public static Boolean getRegDone()
    {
        Boolean val=false;
        val= Preferences.myPrefs.getBoolean(REG_DONE, false);
        return val;
    }


    public static List<String> getUserDetails()
    {
        List<String> user= new ArrayList<String>();
        String val="";
        val= Preferences.myPrefs.getString(pref_Surname, "");
        user.add(val);
        val= Preferences.myPrefs.getString(pref_UserName, "");
        user.add(val);
        val= Preferences.myPrefs.getString(pref_OthName, "");
        user.add(val);
        return user;
    }


    public static String getothname(){
        String othname = "name";
        othname = Preferences.myPrefs.getString(pref_OthName, "name");
        return othname;
    }


    public static String getsurname(){
        String othname = "name";
        othname = Preferences.myPrefs.getString(pref_Surname, "name");
        return othname;
    }

    public static String getSelectedSchool(){
        String selectedSchool = "school";
        selectedSchool = Preferences.myPrefs.getString(pref_USER_School, "school");
        return selectedSchool;
    }

    public static void setSelectedSchool(String School){
        Editor edits = Preferences.myPrefs.edit();
        edits.putString(pref_USER_School, School);
        edits.commit();
    }



    public static String getID(){
        String ID = "ID";
        ID = Preferences.myPrefs.getString(pref_USER_ID, "UID");
        return ID;
    }
    public static void setID(String UID){
        Editor edits = Preferences.myPrefs.edit();
        edits.putString(pref_USER_ID, UID);
        edits.commit();
    }


}
