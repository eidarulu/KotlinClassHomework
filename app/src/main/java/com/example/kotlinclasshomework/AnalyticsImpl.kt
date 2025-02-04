package com.example.kotlinclasshomework

import android.util.Log

class AnalyticsImpl(private val tag: String) : Analytics {

    override fun onShown() {
        Log.d(tag, "onShown from the method of AnalyticsImpl")
    }
}