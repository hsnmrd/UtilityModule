package com.raika.utilitymodule.copy

import android.app.Activity
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import com.raika.utilitymodule.toast.toasting

fun Activity.copyToClipBoard(message: String) {
    val clipMan: ClipboardManager? = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager?
    clipMan?.setPrimaryClip(ClipData.newPlainText("label", message))
    toasting("متن کپی شد")
}
