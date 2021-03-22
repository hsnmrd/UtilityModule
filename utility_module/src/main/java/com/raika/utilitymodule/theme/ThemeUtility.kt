package com.raika.utilitymodule.theme

import android.app.Activity
import android.content.Intent
import android.content.res.Configuration
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import com.raika.utilitymodule.theme.ThemeModuleSetting.moduleSettingCurrentTheme

fun Activity.updateTheme(lightTheme: Int, darkTheme: Int) {
    if (android.os.Build.VERSION.SDK_INT >= 29) {
        when (this.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
            Configuration.UI_MODE_NIGHT_YES -> {
                themeModuleSettingGetPreference(this).moduleSettingCurrentTheme = "dark"
                this.setTheme(darkTheme)
            }
            Configuration.UI_MODE_NIGHT_NO -> {
                themeModuleSettingGetPreference(this).moduleSettingCurrentTheme = "light"
                this.setTheme(lightTheme)
            }
        }
    } else {
        if (themeModuleSettingGetPreference(this).moduleSettingCurrentTheme == "light") {
            this.setTheme(lightTheme)
        } else {
            this.setTheme(darkTheme)
        }
    }
}

fun Activity.setCustomTheme(isDark: Boolean, defaultActivity: Activity) {
    if (isDark) {
        themeModuleSettingGetPreference(this).moduleSettingCurrentTheme = "dark"
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
    } else {
        themeModuleSettingGetPreference(this).moduleSettingCurrentTheme = "light"
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
    val intent = Intent(this, defaultActivity::class.java)
    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
    startActivity(intent)
}

fun View.needToShowThemeAsOption() {
    if (android.os.Build.VERSION.SDK_INT >= 29) {
        this.visibility = View.GONE
    } else {
        this.visibility = View.VISIBLE
    }
}

fun needToShowThemeAsOption(): Boolean {
    return android.os.Build.VERSION.SDK_INT < 29
}