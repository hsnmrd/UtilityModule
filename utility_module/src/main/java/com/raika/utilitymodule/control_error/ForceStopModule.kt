package com.raika.utilitymodule.control_error

import android.app.Application
import android.content.Context
import com.raika.utilitymodule.R
import org.acra.ACRA
import org.acra.BuildConfig
import org.acra.config.CoreConfigurationBuilder
import org.acra.config.DialogConfigurationBuilder
import org.acra.config.LimiterConfigurationBuilder
import org.acra.config.MailSenderConfigurationBuilder
import org.acra.data.StringFormat

fun Context.controlForceStop() {
    val builder: CoreConfigurationBuilder = CoreConfigurationBuilder(this)
        .setBuildConfigClass(BuildConfig::class.java)
        .setReportFormat(StringFormat.JSON)
    builder.getPluginConfigurationBuilder(MailSenderConfigurationBuilder::class.java)
        .setMailTo("alimokhlesi@gmail.com")
        .setSubject("CRM Sana")
        .setBody("")
        .setReportAsFile(true)
        .setEnabled(true)
    builder.getPluginConfigurationBuilder(DialogConfigurationBuilder::class.java)
        .setTitle("از مشکل به وجود آمده متاسفیم")
        .setText("لطفا برای بهبود عملکرد برنامه، مشکل را با ما به اشتراک بگذارید")
        .setResIcon(R.drawable.ic_shield_exclamation)
        .setResTheme(R.style.Theme_UtilityModule)
        .setNegativeButtonText("انصراف")
        .setPositiveButtonText("ارسال")
        .setEnabled(true)
    builder.getPluginConfigurationBuilder(LimiterConfigurationBuilder::class.java)
        .setEnabled(false)
    ACRA.init(this.applicationContext as Application, builder)
}