package com.quohealth.danipractice.presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.quohealth.danipractice.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        listUsersBtn.setOnClickListener {
            Navigator.goToListActivity(this)
        }

        addUsersBtn.setOnClickListener {
            Navigator.goToAddUsersActivity(this)
        }

        detailsUserBtn.setOnClickListener {
            Navigator.goToDetailsUserActivity(this)
        }

    }


}