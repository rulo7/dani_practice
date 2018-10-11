package com.quohealth.danipractice.presentation

import android.content.Context
import android.content.Intent

class Navigator {
    companion object {
        fun goToHomeActivity(context: Context) {
            context.startActivity(Intent(context, HomeActivity::class.java))
        }
    }
}