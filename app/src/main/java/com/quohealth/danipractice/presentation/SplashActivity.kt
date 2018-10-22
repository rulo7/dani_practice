package com.quohealth.danipractice.presentation

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.quohealth.danipractice.R

class SplashActivity : AppCompatActivity() {

    //val interactor = factory.interactor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            start()
        }, 3000)
    }

    private fun start() {
        /*interactor.retrieveWorkers {workers->
            workers[0].
        }*/
        Navigator.goToHomeActivity(this)
    }
}