package com.quohealth.danipractice.presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.quohealth.danipractice.R
import kotlinx.android.synthetic.main.users_child.view.*

class ListUsersActivity : AppCompatActivity() {

    lateinit var users_list : RecyclerView
    var users:MutableList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_users)

        users_list =  findViewById(R.id.user_list) as RecyclerView

    }

    class UserAdapter(items : List<String>) : RecyclerView.Adapter<UserAdapter.ViewHolder>(){
        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getItemCount(): Int {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        class ViewHolder(v: View) : RecyclerView.ViewHolder(v){
            val name = v.user_name
        }

    }

    fun loadData(){
        users.add("Daniel")
        users.add("Raul")
        users.add("Gustavo")
        users.add("Alvaro")


    }


}