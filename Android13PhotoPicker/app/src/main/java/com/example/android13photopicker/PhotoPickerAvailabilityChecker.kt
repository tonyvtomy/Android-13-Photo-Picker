package com.example.android13photopicker

import android.os.Build
import android.os.ext.SdkExtensions.getExtensionVersion
import androidx.annotation.RequiresApi

private const val ANDROID_R_REQUIRED_EXTENSION_VERSION = 2

object PhotoPickerAvailabilityChecker {

    @RequiresApi(33)
    fun isPhotoPickerAvailable(): Boolean {
        return when {
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU -> true
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.R        -> {
                getExtensionVersion(Build.VERSION_CODES.R) >= ANDROID_R_REQUIRED_EXTENSION_VERSION
            }
            else                                                  -> false
        }
    }
}
