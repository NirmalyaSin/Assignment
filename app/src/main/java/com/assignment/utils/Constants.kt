package com.assignment.utils

import android.annotation.SuppressLint
import android.content.Context

@SuppressLint("StaticFieldLeak")
 object Constants {
   /* object SharePref {
        var FCM_Token = "FCM_Token"
        var UserId = "UserId"
        var UserType = "UserType"
        var Login_type = "Login_type"
        var First_Name = "First_Name"
        var Last_Name = "Last_Name"
        var Email = "Email"
        var UserName = "UserName"
        var Profile_Image = "Profile_Image"
        var Phone_number = "Phone_number"
        var Dail_Code = "Dail_Code"
        var Country_Code = "Country_Code"
        var BIO = "BIO"
        var Email_Verified = "Email_Verified"
        var Password = "Password"
        var Login_typeMain = "Login_typeMain"
        var Type = "Type"
        var Type_title = "Type_title"




    }*/

    var SERVER_URL= "http://dev.innofied.org/igx-basketball-app/api/"
    var USER_LOGGED_IN = "agent_logged_in"
    var publicContext: Context? = null

    interface IntentKey {
        companion object {
            const val RedirectionTarget = "RedirectionTarget"
            const val RedirectionExtra = "RedirectionExtra"
        }
    }
}