package com.quohealth.danipractice.presentation

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.quohealth.danipractice.R
import com.quohealth.danipractice.domain.Worker
import com.quohealth.danipractice.domain.factory
import kotlinx.android.synthetic.main.activity_list_users.*
import kotlinx.android.synthetic.main.activity_splash.*
import kotlinx.android.synthetic.main.users_child.view.*

class ListUsersActivity : AppCompatActivity() {

    lateinit var users_list: RecyclerView
    //var users:MutableList<String> = ArrayList()

    val interactor = factory.interactor

    val progressBar: ProgressBar = this.loadingBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_users)

        //loadData()
        users_list = findViewById(R.id.user_list) as RecyclerView
        users_list.layoutManager = LinearLayoutManager(this)

        progressBar.visibility = View.VISIBLE
        interactor.retrieveWorkers { workers ->
            progressBar.visibility = View.GONE
            users_list.adapter = UserAdapter(workers,this)
        }


    }

    //class UserAdapter(items : List<String>, ctx: Context) : RecyclerView.Adapter<UserAdapter.ViewHolder>(){
    class UserAdapter(items: List<Worker>, ctx: Context) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

        var list = items
        var context = ctx

        override fun getItemCount(): Int {
            return list.size
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(LayoutInflater.from(context).inflate(R.layout.users_child, parent, false))
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder?.userName?.text = list.get(position).name
            holder?.userRole?.text = list.get(position).role
            //holder?.userImage?.
        }

        class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
            val userName = v.user_name
            val userRole = v.user_role
            val userImage = v.user_image
        }

    }

    /*fun loadData(){
        users.add("Pedro")
        users.add("Raul")
        users.add("Gustavo")
        users.add("Alvaro")
        users.add("Daniel")
        users.add("Raul")
        users.add("Gustavo")
        users.add("Alvaro")
        users.add("Daniel")
        users.add("Raul")
        users.add("Gustavo")
        users.add("Alvaro")
        users.add("Daniel")
        users.add("Raul")
        users.add("Gustavo")
        users.add("Alvaro")
        users.add("Daniel")
        users.add("Raul")
        users.add("Gustavo")
        users.add("Alvaro")
        users.add("Daniel")
        users.add("Raul")
        users.add("Gustavo")
        users.add("Alvaro")
        users.add("Daniel")
        users.add("Raul")
        users.add("Gustavo")
        users.add("Alvaro")
        users.add("Daniel")
        users.add("Raul")
        users.add("Gustavo")
        users.add("Alvaro")
        users.add("Daniel")
        users.add("Raul")
        users.add("Gustavo")
        users.add("Alvaro")
        users.add("Daniel")
        users.add("Raul")
        users.add("Gustavo")
        users.add("Alvaro")
        users.add("Daniel")
        users.add("Raul")
        users.add("Gustavo")
        users.add("Alvaro")
        users.add("Daniel")
        users.add("Raul")
        users.add("Gustavo")
        users.add("Alvaro")
        users.add("Daniel")
        users.add("Raul")
        users.add("Gustavo")
        users.add("Alvaro")
        users.add("Daniel")
        users.add("Raul")
        users.add("Gustavo")
        users.add("Alvaro")
    }*/


}