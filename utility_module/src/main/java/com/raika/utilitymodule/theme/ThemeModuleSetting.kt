package com.raika.utilitymodule.theme

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager

object ThemeModuleSetting {
    
    private const val moduleSettingTheme = "ModuleSettingTheme"

    private inline fun SharedPreferences.editMe(operation: (SharedPreferences.Editor) -> Unit) {
        val editMe = edit()
        operation(editMe)
        editMe.apply()
    }
    
    var SharedPreferences.moduleSettingCurrentTheme
        get() = getString(moduleSettingTheme, "light")
        set(value) {
            editMe { it.putString(moduleSettingTheme, value) }
        }

}

fun themeModuleSettingGetPreference(context: Context?): SharedPreferences =
    PreferenceManager.getDefaultSharedPreferences(context)

