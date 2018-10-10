package com.quohealth.danipractice.presentation

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.quohealth.danipractice.R
import com.quohealth.danipractice.domain.display
import com.quohealth.danipractice.domain.factory
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    private val interactor = factory.interactor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            //Navigator.goToHomeActivity(this)
            start()
        }, 3000)
    }

    private fun start() {
        interactor.retrieveWorkers { workers ->
            message.text = workers.display(this)
            loading.visibility = View.GONE
        }
    }
}