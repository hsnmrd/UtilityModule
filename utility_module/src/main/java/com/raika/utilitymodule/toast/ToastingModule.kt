package com.raika.utilitymodule.toast

import android.app.Activity
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.textview.MaterialTextView
import com.raika.utilitymodule.R

fun Activity.toasting(message: String) {
    val inflater = this.layoutInflater
    val layout: ViewGroup = inflater.inflate(R.layout.utility_module_toasting, null) as ViewGroup
    val text: MaterialTextView = layout.findViewById(R.id.tv_utility_module_toasting_root)
    text.text = message
    with (Toast(this)) {
        setGravity(Gravity.CENTER_VERTICAL or Gravity.BOTTOM, 0, 80)
        duration = Toast.LENGTH_SHORT
        view = layout
        show()
    }
}

fun Activity.toastingLong(message: String) {
    val inflater = this.layoutInflater
    val layout: ViewGroup = inflater.inflate(R.layout.utility_module_toasting, null) as ViewGroup
    val text: MaterialTextView = layout.findViewById(R.id.tv_utility_module_toasting_root)
    text.text = message
    with (Toast(this)) {
        setGravity(Gravity.CENTER_VERTICAL or Gravity.BOTTOM, 0, 80)
        duration = Toast.LENGTH_LONG
        view = layout
        show()
    }
}