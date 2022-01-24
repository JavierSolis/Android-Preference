package dev.javiersolis.preference

import android.content.Context
import android.content.SharedPreferences

class UtilPreference {
    companion object {
        private var sharedPref: SharedPreferences? = null

        fun setSharedPreference(sharedPreference: SharedPreferences?) {
            sharedPref = sharedPreference
        }

        fun deleteAllPreference(){
            sharedPref!!.edit().clear().apply()
        }
        fun deletePreference(key:String){
            sharedPref!!.edit().remove(key).apply()
        }

        fun putInt(key: String?, value: Int?) {
            val editor = sharedPref!!.edit()
            if (value != null) {
                editor.putInt(key, value)
            }
            editor.apply()
        }

        fun getInt(key: String?): Int {
            return sharedPref!!.getInt(key, -1)
        }


        fun getBoolean(key: String?): Boolean {
            return sharedPref!!.getBoolean(key, false)
        }


        fun getBoolean(key: String?, defaultValue:Boolean): Boolean {
            return sharedPref!!.getBoolean(key, defaultValue)
        }


        fun putString(key: String?, value: String?) {
            val editor = sharedPref!!.edit()
            editor.putString(key, value)
            editor.apply()
        }


        fun putBolean(key: String?, value: Boolean?) {
            val editor = sharedPref!!.edit()
            if (value != null) {
                editor.putBoolean(key, value)
            }
            editor.apply()
        }

        fun putInt(context: Context, key: String?, value: Int) {
            val sharedPref = context.getSharedPreferences(
                "default",
                Context.MODE_PRIVATE
            ) //.getPreferences(Context.MODE_PRIVATE);
            val editor = sharedPref.edit()
            editor.putInt(key, value)
            editor.apply()
        }

        fun getString(key: String?): String? {
            return sharedPref!!.getString(key, null)
        }
        fun getStrOrEmpty(key: String): String {
            return sharedPref!!.getString(key,"")?:""
        }


        fun getInt(context: Context, key: String?): Int {
            val sharedPref = context.getSharedPreferences(
                "default",
                Context.MODE_PRIVATE
            ) //.getPreferences(Context.MODE_PRIVATE);
            return sharedPref.getInt(key, -1)
        }
    }
}