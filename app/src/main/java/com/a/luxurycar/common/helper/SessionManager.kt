package com.a.luxurycar.common.helper;

import android.content.Context
import android.content.SharedPreferences
import com.a.luxurycar.common.application.LuxuryCarApplication
import com.a.luxurycar.common.utils.PrefUtil
import com.google.gson.Gson


class SessionManager(var context: Context) {

    internal var pref: SharedPreferences;
    internal var editor: SharedPreferences.Editor;

    init {
        pref = context.getSharedPreferences(KEY_USER_PREF, Context.MODE_PRIVATE);
        editor = pref.edit();
    }

    companion object {

        val KEY_USER_PREF = "user_pref" //
        val KEY_AUTHORIZATION_TOKEN = "authorization_token" //
        val KEY_USER_DATA = "user_data" //
        val IS_USER_LOGGED_IN = "is_user_logged_in" //


        fun setAuthorizationToken(authToken : String) {
            PrefUtil.putString(LuxuryCarApplication.instance, KEY_AUTHORIZATION_TOKEN, authToken)
        }

        fun getAuthorizationToken(): String {
            return PrefUtil.getString(LuxuryCarApplication.instance, KEY_AUTHORIZATION_TOKEN, "")?:""
        }


        fun setUserLoggedIn(isUserLoggedIn : Boolean) {
            PrefUtil.putBoolean(LuxuryCarApplication.instance, IS_USER_LOGGED_IN, isUserLoggedIn)
        }

        fun isUserLoggedIn(): Boolean {
            return PrefUtil.getBoolean(LuxuryCarApplication.instance, IS_USER_LOGGED_IN, false)
        }

    }

    fun logout() {
        PrefUtil.clear(context)
    }
}

