package com.raika.utilitymodule.drawable

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import android.media.Image
import android.os.Build

@SuppressLint("UseCompatLoadingForDrawables")
fun Context.getDrawableModule(id: Int): Drawable? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        resources.getDrawable(id, theme)
    } else {
        resources.getDrawable(id)
    }
}