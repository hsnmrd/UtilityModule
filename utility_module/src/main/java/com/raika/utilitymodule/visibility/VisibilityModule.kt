package com.raika.utilitymodule.visibility

import android.view.View

fun View.changeVisibleInvisible() {
    visibility = if (visibility == View.VISIBLE) {
        View.INVISIBLE
    } else {
        View.VISIBLE
    }
}

fun View.changeVisibleGone() {
    visibility = if (visibility == View.VISIBLE) {
        View.GONE
    } else {
        View.VISIBLE
    }
}

fun View.changeVisibleGone(visibleListener: () -> Unit, goneListener: () -> Unit) {
    visibility = if (visibility == View.VISIBLE) {
        goneListener.invoke()
        View.GONE
    } else {
        visibleListener.invoke()
        View.VISIBLE
    }
}

fun View.changeVisibleGone(isVisible: Boolean) {
    visibility = if (isVisible) {
        View.VISIBLE
    } else {
        View.GONE
    }
}


fun View.isVisible(): Boolean {
    return visibility == View.VISIBLE
}

fun View.isGone(): Boolean {
    return visibility == View.GONE
}

fun View.isInvisible(): Boolean {
    return visibility == View.INVISIBLE
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}