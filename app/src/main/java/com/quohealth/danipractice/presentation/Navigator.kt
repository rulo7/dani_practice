package com.quohealth.danipractice.presentation

import android.content.Context
import android.content.Intent

class Navigator {
    companion object {
        fun goToHomeActivity(context: Context) {
            context.startActivity(Intent(context, HomeActivity::class.java))
        }

        fun goToListActivity(context: Context) {
            context.startActivity(Intent(context, ListUsersActivity::class.java))
        }

        fun goToAddUsersActivity(context: Context) {
            context.startActivity(Intent(context, AddUsersActivity::class.java))
        }

        fun goToDetailsUserActivity(context: Context){
            context.startActivity(Intent(context, DetailsUserActivity::class.java))
        }

    }
}