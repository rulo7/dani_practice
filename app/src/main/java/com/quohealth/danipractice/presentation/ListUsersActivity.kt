package com.quohealth.danipractice.presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ProgressBar
import com.quohealth.danipractice.R
import com.quohealth.danipractice.domain.factory
import com.quohealth.danipractice.domain.toArrayList
import kotlinx.android.synthetic.main.activity_list_users.*

class ListUsersActivity : AppCompatActivity() {

    lateinit var users_list: RecyclerView
    //var users:MutableList<String> = ArrayList()

    val interactor = factory.interactor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_users)

        //loadData()
        users_list = findViewById<RecyclerView>(R.id.user_list)
        users_list.layoutManager = LinearLayoutManager(this)

        val progressBar: ProgressBar = this.loadingBar

        progressBar.visibility = View.VISIBLE
        interactor.retrieveWorkers { workers ->
            progressBar.visibility = View.GONE
            //users_list.adapter = WorkersAdapter(workers, this)
            users_list.adapter = WorkersAdapter(workers.toArrayList())
        }

    }

}