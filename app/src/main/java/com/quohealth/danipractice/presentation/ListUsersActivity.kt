package com.quohealth.danipractice.presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.quohealth.danipractice.R

class ListUsersActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_users)

        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer,/*Aqui le tienes que pasar el fragment*/)
        //El fragment con la propiedad para poder*/
    }

}