package com.raika.utilitymodule.update_ui

import android.widget.TextView

fun TextView.setTextWithEmptyCheck(
    valueToShow: String,
    defaultValue: String,
    noValueListener: (() -> Unit)? = null,
    hasValueListener: (() -> Unit)? = null,
) {
    if (valueToShow == "") {
        this.text = defaultValue
        noValueListener?.invoke()
    } else {
        this.text = valueToShow
        hasValueListener?.invoke()
    }
}