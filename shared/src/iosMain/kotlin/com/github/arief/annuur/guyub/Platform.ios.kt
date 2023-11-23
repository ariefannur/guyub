package com.github.arief.annuur.guyub

import androidx.compose.ui.window.ComposeUIViewController
import com.github.arief.annuur.guyub.form.group.GSingleForm
import com.github.arief.annuur.guyub.model.FormField
import platform.UIKit.UIDevice

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getPlatform(): Platform = IOSPlatform()

fun SingleFormView(data: List<FormField>) = ComposeUIViewController { GSingleForm(data) }